package com.madrefoca.cafe_tango.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.madrefoca.cafe_tango.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhasesTab1 extends Fragment {


    public PhasesTab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_phases_tab1, container, false);
        TextView tv = (TextView) thisView.findViewById(R.id.treatmentText);
        tv.setMovementMethod(new ScrollingMovementMethod());
        // Inflate the layout for this fragment
        return thisView;
    }

}
