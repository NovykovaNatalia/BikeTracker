package com.example.biketracker.ui.profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.location.Location;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

import java.util.List;

import com.example.biketracker.R;

public class ProfileFragment extends Fragment {
    private LinearLayout linerSex;
    private LinearLayout linerWeight;
    private LinearLayout linerHeight;
    private TextView textViewSex;
    private TextView textViewWeight;
    private TextView textViewHeight;
    AlertDialog alertDialogWithRadioButton;


    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {
        View fragmentProfil = inflater.inflate(R.layout.fragment_profile, container, false);
        linerHeight = fragmentProfil.findViewById(R.id.linerHeight);
        linerWeight = fragmentProfil.findViewById(R.id.linerWeight);
        linerSex = fragmentProfil.findViewById(R.id.linerSex);
        textViewHeight = fragmentProfil.findViewById(R.id.textViewHeight);
        textViewWeight = fragmentProfil.findViewById(R.id.textViewHeight);
        textViewSex = fragmentProfil.findViewById(R.id.textViewSex);

        linerSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            CreateAlertDialogWithRadioButton();

            }
        });

        return fragmentProfil;
    }
    public void CreateAlertDialogWithRadioButton() {
       final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("AlertDialog");
        final String[] items = {"male", "female"};
        final int checkItem = 0;
        builder.setSingleChoiceItems(items, checkItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {
               switch (item) {
                   case 0:
                       break;

                   case 1:

                       break;
               }

            }
        });
        alertDialogWithRadioButton = builder.create();
        alertDialogWithRadioButton.setCanceledOnTouchOutside(false);
        alertDialogWithRadioButton.show();
    }

}
