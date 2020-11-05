package com.example.biketracker.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.biketracker.R;

public class ShareFragment extends Fragment {
    MenuItem itemShare;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View fragmentShare = inflater.inflate(R.layout.fragment_share, container, false);
        itemShare = fragmentShare.findViewById(R.id.nav_share);
        itemShare.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "Your body hear";
                String shareSub = "Your subject hear";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
                return true;
            }
        });

        return fragmentShare;

    }
}
