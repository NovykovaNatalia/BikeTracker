package com.example.biketracker.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.biketracker.R;

public class SettingFragment extends Fragment {

    private TextView tvText;
    private Switch aSwitch;
     SharedPreferences sharedPreferences;
     public static final String MyPREFERENCES = "nightModePrefs";
     public static final String KEY_ISNIGHTMODE = "isNightMode";



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View fragmentSettings = inflater.inflate(R.layout.fragment_setting, container, false);
        tvText = fragmentSettings.findViewById(R.id.textMode);
        aSwitch = fragmentSettings.findViewById(R.id.switchMode);
        Spinner spLanguage = (Spinner) fragmentSettings.findViewById(R.id.spLanguage);
        TextView textLanguage = (TextView) fragmentSettings.findViewById(R.id.textLanguage);
        Log.e("LOG_TAG", "On create");
        sharedPreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                checkNightModeActivated();
        Log.e("LOG_TAG", "Night Mode Activated");

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                   saveNightModeState(true);
                   getActivity().recreate();
                } else {
                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    saveNightModeState(false);
                    getActivity().recreate();
                }
            }
        });
        Log.e("LOG_TAG", "Night Mode Activated");

        return fragmentSettings;
    }


    private void saveNightModeState(boolean nightMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_ISNIGHTMODE, nightMode);
        editor.apply();
        Log.e("LOG_TAG", "Save Night Mode State");
    }
    public void checkNightModeActivated() {
        if(sharedPreferences.getBoolean(KEY_ISNIGHTMODE,false)) {
            aSwitch.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            aSwitch.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        Log.e("LOG_TAG", "Check NightModeState");
    }

}



