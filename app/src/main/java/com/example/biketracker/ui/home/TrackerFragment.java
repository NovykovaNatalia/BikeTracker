package com.example.biketracker.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.biketracker.R;

public class TrackerFragment extends Fragment {

    private TrackerViewModel trackerViewModel;

    ImageButton playButton;
    ImageButton stopButton;
    boolean isPressed;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        trackerViewModel =
                ViewModelProviders.of(this).get(TrackerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tracker, container, false);

        playButton  = (ImageButton)root.findViewById(R.id.play);
        stopButton  = (ImageButton)root.findViewById(R.id.stop);
        Log.e("no"," ### dnovykov PlayButton " + playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("no"," ### dnovykov ONCLICK !! WORK");
                if(!isPressed) {
                    System.out.println(" ### dnovykov ONCLICK !! WORK 1");
                    isPressed = true;
                    playButton.setBackgroundResource(R.drawable.baseline_pause);
                } else {
                    Log.e("no"," ### dnovykov ONCLICK !! WORK");
                    isPressed = false;
                    playButton.setBackgroundResource(R.drawable.play_arrow);
                }
            }
        });



        return root;

    }
}