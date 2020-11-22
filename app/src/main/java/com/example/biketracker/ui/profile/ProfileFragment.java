package com.example.biketracker.ui.profile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.location.Location;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.biketracker.R;

import org.w3c.dom.Text;

import static android.text.InputType.TYPE_CLASS_NUMBER;

public class ProfileFragment extends Fragment {
    private LinearLayout linerSex;
    private LinearLayout linerWeight;
    private LinearLayout linerHeight;
    private LinearLayout linerName;
    private LinearLayout linerAge;
    private TextView textViewSex;
    private TextView textViewWeight;
    private TextView textViewHeight;
    AlertDialog alertDialogWithRadioButtonSex;
    AlertDialog getAlertDialogWithRadioButtonBike;
    AlertDialog alertDialogWithName;
    AlertDialog alertDialogWithAge;
    AlertDialog alertDialogWithWeight;
    AlertDialog alertDialogWithHeight;
    private TextView textViewBicycle;
    private LinearLayout lineBike;
    private String selection;
    private String selection1;

    private TextView textName;
    private TextView textAge;

    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {
        View fragmentProfil = inflater.inflate(R.layout.fragment_profile, container, false);
        linerHeight = fragmentProfil.findViewById(R.id.linerHeight);
        linerWeight = fragmentProfil.findViewById(R.id.linerWeight);
        linerSex = fragmentProfil.findViewById(R.id.linerSex);
        linerName = fragmentProfil.findViewById(R.id.linerName);
        textViewHeight = fragmentProfil.findViewById(R.id.textViewHeight);
        textViewWeight = fragmentProfil.findViewById(R.id.textViewWeight);
        textViewSex = fragmentProfil.findViewById(R.id.textViewSex);
        textViewBicycle = fragmentProfil.findViewById(R.id.textViewBike);
        lineBike = fragmentProfil.findViewById(R.id.linerBike);
        linerAge = fragmentProfil.findViewById(R.id.linerAge);

       textName = fragmentProfil.findViewById(R.id.textViewName);
        textAge = fragmentProfil.findViewById(R.id.textViewAge);


        linerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               CreateAlertDialogWithName();
            }
        });
        linerAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithAge();
            }
        });
        linerWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithWeight();
            }
        });

        linerSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithRadioButtonSex();

            }
        });

        lineBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithRadioButtonBike();
            }
        });
        linerHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithHeight();
            }
        });

        return fragmentProfil;
    }

    private void CreateAlertDialogWithHeight() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View customHeightLayout = getLayoutInflater().inflate(R.layout.custom_height_layout, null);
        builder.setView(customHeightLayout);
        builder.setTitle("CustomDialogWithHeight");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editTextHeight = customHeightLayout.findViewById(R.id.ed_text_height);
                Toast.makeText(getActivity(),editTextHeight.getText().toString(), Toast.LENGTH_LONG).show();
                textViewHeight.setText(editTextHeight.getText().toString());
                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("textViewHeight", String.valueOf(textViewHeight));
                editor.commit();
            }
        });
        alertDialogWithHeight = builder.create();
        alertDialogWithHeight.show();
    }

    private void CreateAlertDialogWithWeight() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View customWeightLayout = getLayoutInflater().inflate(R.layout.custom_weight_layout, null);
        builder.setView(customWeightLayout);
        builder.setTitle("CustomDialogWithWeight");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editTextWeight = customWeightLayout.findViewById(R.id.ed_text_weight);
                Toast.makeText(getActivity(),editTextWeight.getText().toString(), Toast.LENGTH_LONG).show();
                textViewWeight.setText(editTextWeight.getText().toString());
                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("textViewWeight", String.valueOf(textViewWeight));
                editor.commit();
            }
        });
        alertDialogWithWeight = builder.create();
        alertDialogWithWeight.show();
    }

    public void CreateAlertDialogWithName() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View customLayout = getLayoutInflater().inflate(R.layout.customlayout, null);
        builder.setView(customLayout);
        builder.setTitle("CustomDialogWithName");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              EditText editText = customLayout.findViewById(R.id.ed_text);
              Toast.makeText(getActivity(),editText.getText().toString(), Toast.LENGTH_LONG).show();
              textName.setText(editText.getText().toString());

                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("textName", String.valueOf(textName));
                editor.commit();
            }
        });
        alertDialogWithName = builder.create();
        alertDialogWithName.show();
    }

    public void CreateAlertDialogWithAge() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View customAgeLayout = getLayoutInflater().inflate(R.layout.custom_age_layout, null);
        builder.setView(customAgeLayout);
        builder.setTitle("CustomDialogWithAge");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              EditText editTextAge = customAgeLayout.findViewById(R.id.ed_text_age);
              Toast.makeText(getActivity(),editTextAge.getText().toString(), Toast.LENGTH_LONG).show();
              textAge.setText(editTextAge.getText().toString());

                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("textAge", String.valueOf(textAge));
                editor.commit();
            }
        });
        alertDialogWithAge = builder.create();
        alertDialogWithAge.show();
    }

    public void CreateAlertDialogWithRadioButtonSex() {
       final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("AlertDialogWithRadioButtonSex");
        final String[] items = {getString(R.string.sexMale), getString(R.string.female)};
        int checkItem = 0;
        builder.setSingleChoiceItems(items, checkItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {
                selection = items[item];
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textViewSex.setText(selection);
                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("selection", selection);
                editor.commit();
            }
        });
        alertDialogWithRadioButtonSex = builder.create();
        alertDialogWithRadioButtonSex.setCanceledOnTouchOutside(false);
        alertDialogWithRadioButtonSex.show();
    }

    public void CreateAlertDialogWithRadioButtonBike() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("AlertDialogWithradioButtonBike");
        final String[] items = {getString(R.string.city_bicycle),getString(R.string.mountain_bike),getString(R.string.road_bike)};
        final int checkItem = 0;
        builder.setSingleChoiceItems(items, checkItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {
              selection1 = items[item];

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
             textViewBicycle.setText(selection1);
                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("selection1", selection1);
                editor.commit();
            }
        });
        getAlertDialogWithRadioButtonBike = builder.create();
        getAlertDialogWithRadioButtonBike.setCanceledOnTouchOutside(false);
        getAlertDialogWithRadioButtonBike.show();
    }
}
