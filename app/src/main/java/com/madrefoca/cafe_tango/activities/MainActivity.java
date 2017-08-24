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
import com.madrefoca.cafe_tango.helpers.DatabaseHelper;
import com.madrefoca.cafe_tango.model.Illness;

import com.madrefoca.cafe_tango.R;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //clear tables because is duplicated.
        // TODO: 8/21/2017 buscar otra forma para que no se dupliquen los datos.
        this.getHelper().clearTables();


        //Insert some illnesses
        // TODO: 8/19/2017 esto es temporal para mostrar datos, se tiene que mover a otro lado
        this.insertSomeIllnesses();

        //Create some schools in db to create tabs depending in this table.
        this.insertSchools();

        // Reading all illnesses
        Log.d("Reading: ", "Reading all illnesses from database...");
        List<Illness> illnesses = getAllIllnessesFromDatabase();

        //put the illnesses in the view
        for (Illness illness : illnesses) {
            String log = "Id: " + illness.getId() + " ,Name: " + illness.getName() + " ,Phone: " + illness.getDescription();
            // Writing Illness to log
            Log.d("Illness: ", log);
            //Writing Illnesses to the view
            illnessesArrayList.add(illness.getName());
        }

        listView = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

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
                bundle.putParcelableArrayList("schoolHouseList", getAllSchoolHouseFromDatabase());
                intent.putExtras(bundle);
                intent.putExtra("IllnessName", listView.getItemAtPosition(i).toString());
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

    private void insertSomeIllnesses() {
        Log.d("Insert: ", "Inserting ..");

        try {
            // This is how, a reference of DAO object can be done
            final Dao<Illness, Integer> illnessDao = getHelper().getIllnesDao();

            //This is the way to insert data into a database table
            illnessDao.create(new Illness("Cáncer de piel", "otro tipo de cancer de piel"));
            illnessDao.create(new Illness("Cáncer de mama", "otro tipo de cancer de mama"));
            illnessDao.create(new Illness("Cáncer de próstata", "otro tipo de cancer de prostata"));
            illnessDao.create(new Illness("Cáncer de hígado", "mucho vino da este cancer"));
            illnessDao.create(new Illness("Cáncer de páncreas", "ese cancer que no se por que da"));
            illnessDao.create(new Illness("Cáncer de huesos", "un tipo de cancer jodido que quedas deforme"));
            illnessDao.create(new Illness("Resfrío", "resfrio normal dar aspirina"));
            illnessDao.create(new Illness("Migraña", "un dolor de cabeza jodido"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertSchools() {
        Log.d("Insert: ", "Inserting some schools");

        try {
            // This is how, a reference of DAO object can be done
            final Dao<SchoolHouse, Integer> schoolsHouseDao = getHelper().getSchoolHouseDao();

            //This is the way to insert data into a database table
            schoolsHouseDao.create(new SchoolHouse("Escuela 1", "tab para la escuela 1"));
            schoolsHouseDao.create(new SchoolHouse("Escuela 2", "tab para la escuela 2"));
            schoolsHouseDao.create(new SchoolHouse("Escuela 3", "tab para la escuela 3"));
            schoolsHouseDao.create(new SchoolHouse("Escuela 4", "tab para la escuela 4"));

        } catch (SQLException e) {
            e.printStackTrace();
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
}
