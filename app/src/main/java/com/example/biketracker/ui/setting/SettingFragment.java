package com.example.biketracker.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.example.biketracker.R;
public class SettingFragment extends Fragment {

    private Switch switchMode;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View fragmentSetting = inflater.inflate(R.layout.fragment_setting, container, false);
        //TODO: change application theme (dark/light)
        switchMode = fragmentSetting.findViewById(R.id.switchMode);

        return fragmentSetting;
    }
}
