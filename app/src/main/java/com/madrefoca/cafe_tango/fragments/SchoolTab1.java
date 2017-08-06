package com.madrefoca.cafe_tango.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.madrefoca.cafe_tango.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolTab1 extends Fragment {

    Activity context;


    public SchoolTab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        View thisView = inflater.inflate(R.layout.fragment_school_tab1, container, false);

        Button button1 = (Button) thisView.findViewById(R.id.button1);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        // Inflate the layout for this fragment
        return thisView;
    }

    private void buttonClicked(View v) {
        Intent intent = new Intent(context, PhasesActivity.class);
        //Button btn = (Button) context.findViewById(R.id.)

        // define the button that invoked the listener by id
        switch (v.getId()) {
            case R.id.button1:
                intent.putExtra("buttonName", "boton 1 apretado");
                break;
            case R.id.button2:
                intent.putExtra("buttonName", "boton 2 apretado");
                break;
        }
        startActivity(intent);
    }

}
