package com.madrefoca.cafe_tango.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.madrefoca.cafe_tango.helpers.DatabaseHelper;
import com.madrefoca.cafe_tango.model.Illness;

import com.madrefoca.cafe_tango.R;

public class MainActivity extends AppCompatActivity {

    // List view
    private ListView listView;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    List illnessesArrayList= new ArrayList();

    private final int REQ_CODE_SPEECH_INPUT = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        //clean all data
        db.deleteAllIllnesses();

        //Insert some illnesses
        this.insertSomeIllnesses(db);

        // Reading all illnesses
        Log.d("Reading: ", "Reading all illnesses..");
        List<Illness> illnesses = db.getAllIllnesses();

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

    private void insertSomeIllnesses(DatabaseHelper db) {
        Log.d("Insert: ", "Inserting ..");
        db.addIllness(new Illness("Cáncer de piel", "otro tipo de cancer de piel"));
        db.addIllness(new Illness("Cáncer de mama", "otro tipo de cancer de mama"));
        db.addIllness(new Illness("Cáncer de próstata", "otro tipo de cancer de prostata"));
        db.addIllness(new Illness("Cáncer de hígado", "mucho vino da este cancer"));
        db.addIllness(new Illness("Cáncer de páncreas", "ese cancer que no se por que da"));
        db.addIllness(new Illness("Cáncer de huesos", "un tipo de cancer jodido que quedas deforme"));
        db.addIllness(new Illness("Resfrío", "resfrio normal dar aspirina"));
        db.addIllness(new Illness("Migraña", "un dolor de cabeza jodido"));
    }
}
