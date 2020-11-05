package com.example.biketracker.ui.setting;

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

    private TextView modeText;
    private Switch switchMode;
    private SharedPreferences sharedPreferences = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View fragmentSettings = inflater.inflate(R.layout.fragment_setting, container, false);
        modeText = fragmentSettings.findViewById(R.id.textMode);
        switchMode = fragmentSettings.findViewById(R.id.switchMode);
        switchMode.setChecked(false);

        Spinner spLanguage = (Spinner) fragmentSettings.findViewById(R.id.spLanguage);
        TextView textLanguage = (TextView) fragmentSettings.findViewById(R.id.textLanguage);

        sharedPreferences = getActivity().getSharedPreferences("night", 0);
        Boolean isNightMode = sharedPreferences.getBoolean("night_mode",true);
        if(isNightMode) {
            switchMode.setChecked(true);
            modeText.setText(R.string.dark);
        } else {
            switchMode.setChecked(false);
            modeText.setText(R.string.lightText);
        }
        //TODO: this if block should be placed on MainActivity, and set default the during start application

        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("night_mode", true);
                    editor.commit();
                    modeText.setText("Dark");
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("night_mode",false);
                    editor.commit();
                    modeText.setText("Light");
                }
            }
        });

        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchMode.setChecked(true);
        }

        return fragmentSettings;
    }

//TODO: this method mb should be called for applying settings
//    public void restartApp() {
//        Intent i = new Intent(getContext(),SettingFragment.class);
//        startActivity(i);
//        onStop();
//    }

}
