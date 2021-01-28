package com.example.biketracker.ui.profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.biketracker.R;


import static androidx.core.content.res.ResourcesCompat.getFont;

public class ProfileFragment extends Fragment {
    EditText firstnameEditText;
    EditText ageEditText;
    Spinner genderSpinner;
    EditText weightEditText;
    EditText heightEditText;
    Spinner bikeSpinner;
    private int gender = 0;
    private int bike = 0;
    private ArrayAdapter spinnerAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {
        View fragmentProfil = inflater.inflate(R.layout.fragment_profile, container, false);
        firstnameEditText = fragmentProfil.findViewById(R.id.firstNameEditText);
        ageEditText = fragmentProfil.findViewById(R.id.ageEditText);
        genderSpinner = fragmentProfil.findViewById(R.id.genderSpinner);
        weightEditText = fragmentProfil.findViewById(R.id.weightEditText);
        heightEditText = fragmentProfil.findViewById(R.id.heightEditText);
        bikeSpinner = fragmentProfil.findViewById(R.id.bikeSpinner);


        spinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.array_gender, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(spinnerAdapter);

        genderSpinner.setOnItemSelectedListener
                (new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        String selectedGender =
                                (String) parent.getItemAtPosition(position);
                        if (!TextUtils.isEmpty(selectedGender)) {
                            if (selectedGender.equals("Male")) {
                                gender = ProfileContract.MemberEntry.GENDER_MALE;
                            } else if (selectedGender.equals("Female")) {
                                gender = ProfileContract.MemberEntry.GENDER_FEMALE;
                            } else {
                                gender = ProfileContract.MemberEntry.GENDER_UNKNOWN;
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        gender = 0;
                    }
                });


        spinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.array_bike, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        bikeSpinner.setAdapter(spinnerAdapter);

        bikeSpinner.setOnItemSelectedListener
                (new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        String selectedBike =
                                (String) parent.getItemAtPosition(position);
                        if (!TextUtils.isEmpty(selectedBike)) {
                            if (selectedBike.equals("City Bike")) {
                                bike = ProfileContract.MemberEntry.SPORT_BIKE;
                            } else if (selectedBike.equals("Mountain Bike")) {
                                bike = ProfileContract.MemberEntry.MOUNTAIN_BIKE;
                            } else {
                                bike = ProfileContract.MemberEntry.CITY_BIKE;
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        bike = 0;
                    }
                });


        return fragmentProfil;
    }


}
