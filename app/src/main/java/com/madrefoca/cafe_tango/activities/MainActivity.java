package com.madrefoca.cafe_tango.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.madrefoca.cafe_tango.Utils.DatabasePopulatorUtil;
import com.madrefoca.cafe_tango.helpers.DatabaseHelper;
import com.madrefoca.cafe_tango.model.Illness;

import com.madrefoca.cafe_tango.R;
import com.madrefoca.cafe_tango.model.IllnessesSchoolHouses;
import com.madrefoca.cafe_tango.model.SchoolHouse;

public class MainActivity extends AppCompatActivity {

    // List view
    private ListView listView;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    List illnessesArrayList= new ArrayList();

    // Declaration of DAOs to interact with corresponding table
    private Dao<Illness, Integer> illnessDao;

    private final int REQ_CODE_SPEECH_INPUT = 100;

    private DatabaseHelper databaseHelper = null;



    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //clear tables because is duplicated.
        // TODO: 8/21/2017 buscar otra forma para que no se dupliquen los datos.
        this.getHelper().clearTables();


        //Insert some illnesses and schools
        DatabasePopulatorUtil databasePopulatorUtil = new DatabasePopulatorUtil(this.getHelper());
        databasePopulatorUtil.populate();

        // Reading all illnesses
        Log.d("MainActivity: ", "Reading all illnesses from database...");
        List<Illness> illnesses = getAllIllnessesFromDatabase();

        Log.d("MainActivity: ", "put the illnesses in the view...");
        for (Illness illness : illnesses) {
            // Writing Illness to log
            Log.d("MainActivity: ", "Name: " + illness.getIllnessName() + " ,Description: " + illness.getDescription());
            //Writing Illnesses to the view
            illnessesArrayList.add(illness.getIllnessName());
        }

        listView = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.illness_name, illnessesArrayList);
        listView.setAdapter(adapter);

        //set listener to the list for the clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SchoolsActivity.class);
                Bundle bundle = new Bundle();
                //pass to school activity all schools in db to create tabs
                try {
                    // TODO: 27/08/17 cambiar la busqueda por el nobre a una por id
                    Illness illness = getHelper().getIllnesDao().queryForEq("illnessName",
                            listView.getItemAtPosition(i).toString()).get(0);
                    Log.d("MainActivity: ", "Illness selected: " + illness.getIllnessName() + "with id: " + illness.getIllnessId());
                    bundle.putParcelableArrayList("schoolHouseList", lookupSchoolsForIllness(illness));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                intent.putExtras(bundle);
                Log.d("MainActivity: ", "send data to schoolActivity");
                startActivity(intent);
            }
        });
        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                MainActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        //adding listener to the microphone button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                //Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
                //startActivity(intent);
                promptSpeechInput();
            }
        });
    }

    // This is how, DatabaseHelper can be initialized for future use
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this,DatabaseHelper.class);
        }
        return databaseHelper;
    }

    /**
     * Showing google speech input dialog
     * */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    inputSearch.setText(result.get(0));
                }
                break;
            }

        }
    }

    private List<Illness> getAllIllnessesFromDatabase() {
        List<Illness> illnessesList = null;
        try {
            // This is how, a reference of DAO object can be done
            illnessesList = getHelper().getIllnesDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return illnessesList;
    }

    private ArrayList<SchoolHouse> getAllSchoolHouseFromDatabase() {
        ArrayList<SchoolHouse> schoolHouseList = new  ArrayList<SchoolHouse>();
        try {
            // This is how, a reference of DAO object can be done
            schoolHouseList.addAll(getHelper().getSchoolHouseDao().queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schoolHouseList;
    }


    private ArrayList<SchoolHouse> lookupSchoolsForIllness(Illness illness) throws SQLException {
        PreparedQuery<SchoolHouse> schoolsForIllnessQuery = makeSchoolsForIllnessQuery();

        schoolsForIllnessQuery.setArgumentHolderValue(0, illness.getIllnessId());
        Dao<SchoolHouse, Integer> schoolsHouseDao = getHelper().getSchoolHouseDao();
        ArrayList<SchoolHouse> schoolHouseArrayList = new ArrayList<>();
        schoolHouseArrayList.addAll(schoolsHouseDao.query(schoolsForIllnessQuery));
        Log.d("MainActivity: ", "Schools found for Illness: " + illness.getIllnessName() + "Id: " + illness.getIllnessId());
        for(SchoolHouse schoolHouse: schoolHouseArrayList){
            Log.d("MainActivity: ", "---->School: " + schoolHouse.getSchoolName() + "Id: " + schoolHouse.getSchoolHouseId());
        }
        return schoolHouseArrayList;
    }

    /**
     * Build our query for Post objects that match a User.
     */
    private PreparedQuery<SchoolHouse> makeSchoolsForIllnessQuery() throws SQLException {
        // build our inner query for IllnessesSchoolHouses objects
        Dao<IllnessesSchoolHouses, Integer> illnessesSchoolsHouseDao = getHelper().getIllnessesSchoolHousesDao();
        QueryBuilder<IllnessesSchoolHouses, Integer> illnessesSchoolsHouseQb = illnessesSchoolsHouseDao.queryBuilder();
        // just select the schoolName field
        illnessesSchoolsHouseQb.selectColumns("schoolHouseId");
        SelectArg illnessSelectArg = new SelectArg();
        illnessesSchoolsHouseQb.where().eq("illnessId", illnessSelectArg);

        // build our outer query for School objects
        Dao<SchoolHouse, Integer> schoolsHouseDao = getHelper().getSchoolHouseDao();
        QueryBuilder<SchoolHouse, Integer> schoolHouseQb = schoolsHouseDao.queryBuilder();
        // where the schoolName matches in the schoolName id from the inner query
        schoolHouseQb.where().in("schoolHouseId", illnessesSchoolsHouseQb);
        return schoolHouseQb.prepare();
    }
}
