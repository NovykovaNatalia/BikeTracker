package com.example.biketracker.ui.tracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.biketracker.R;

public class TrackerFragment extends Fragment {
    private static final long START_TIME_IN_MILLIS = 600000;
    private TrackerViewModel trackerViewModel;
    private Chronometer chronometer;
    private long pauseOffSet;

    ImageButton playButton;
    ImageButton stopButton;
    boolean isPressed;
    boolean isStart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        trackerViewModel =
                ViewModelProviders.of(this).get(TrackerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tracker, container, false);

        playButton  = (ImageButton)root.findViewById(R.id.play);
        stopButton  = (ImageButton)root.findViewById(R.id.stop);
        chronometer = root.findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime() - chronometer.getBase()) > 10000) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(getContext(), "Bing!", Toast.LENGTH_LONG).show();
                }
            }
        });


        Log.e("no"," ### dnovykov PlayButton " + playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Log.e("no"," ### dnovykov ONCLICK !! WORK");
                if(!isPressed) {
                    System.out.println(" ### dnovykov ONCLICK !! WORK 1");
                    isPressed = true;
                    playButton.setBackgroundResource(R.drawable.baseline_pause);
                    startChronometer(chronometer);
                    stopButton.setVisibility(View.VISIBLE);

                } else {
                    Log.e("no"," ### dnovykov ONCLICK !! WORK");
                    isPressed = false;
                    playButton.setBackgroundResource(R.drawable.play_arrow);
                    //TODO: button
                    pauseChronometer(chronometer);
                }
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPressed) {
                    isPressed = true;
                    showAlertDialog(stopButton);
                    playButton.setBackgroundResource(R.drawable.play_arrow);
                }
            }
        });
        return root;



    }
    public void startChronometer(View v) {
        Log.e("no"," ### dnovykov ONCLICK !! Chronometer");
        if(!isStart) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            isStart = true;
        }

    }
    public void pauseChronometer(View v) {
        if(isStart) {
            chronometer.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            isStart = false;
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
                stopButton.setVisibility(View.GONE);
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