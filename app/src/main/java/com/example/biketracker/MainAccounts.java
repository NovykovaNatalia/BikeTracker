package com.example.biketracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.biketracker.ui.main.MainAccountsFragment;

public class MainAccounts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_accounts_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainAccountsFragment.newInstance())
                    .commitNow();
        }
    }
}