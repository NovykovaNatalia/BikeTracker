package com.example.biketracker.ui.tracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.biketracker.R;

public class TrackerFragment extends Fragment {
    private Chronometer chronometer;
    private long pauseOffSet;

    ImageButton buttonPlayPause;
    ImageButton buttonStop;
    boolean isPlayPausePressed;
    boolean isChronoStart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        View fragmentTracker = inflater.inflate(R.layout.fragment_tracker, container, false);

        buttonPlayPause = (ImageButton)fragmentTracker.findViewById(R.id.button_play_pause);
        buttonStop = (ImageButton)fragmentTracker.findViewById(R.id.button_stop);
        chronometer = fragmentTracker.findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //TODO: mb it will be convenient to use this tick for map get localisation?? for example every 3 secs
            }
        });

        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(!isPlayPausePressed) {
                    isPlayPausePressed = true;
                    buttonPlayPause.setImageResource(R.drawable.baseline_pause);
                    startChronometer(chronometer);
                    buttonStop.setVisibility(View.VISIBLE);

                } else {
                    isPlayPausePressed = false;
                    buttonPlayPause.setImageResource(R.drawable.baseline_play);
                    pauseChronometer(chronometer);
                }
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog(buttonStop);
            }
        });
        return fragmentTracker;



    }
    public void startChronometer(View v) {
        if(!isChronoStart) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            isChronoStart = true;
        }

    }
    public void pauseChronometer(View v) {
        if(isChronoStart) {
            chronometer.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            isChronoStart = false;
        }

    }
    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffSet = 0;
    }
    public void showAlertDialog(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setMessage("Do you want to finish your track?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "You finished your track", Toast.LENGTH_LONG).show();
                resetChronometer(chronometer);
                buttonPlayPause.setImageResource(R.drawable.baseline_play);
                isPlayPausePressed = false;
                buttonStop.setVisibility(View.GONE);
            }

        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "You prolong your travel", Toast.LENGTH_LONG).show();
            }

        });
        alert.create().show();
    }

}