package com.example.biketracker.ui.profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.widget.EditText;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biketracker.R;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {
    private LinearLayout linerLayoutSex;
    private LinearLayout linerLayoutWeight;
    private LinearLayout linerLayoutHeight;
    private LinearLayout linerLayoutName;
    private LinearLayout linerLayoutAge;
    private LinearLayout linerLayoutBike;

    private TextView textViewSex;
    private TextView textViewWeight;
    private TextView textViewHeight;
    private TextView textViewName;
    private TextView textViewAge;
    private TextView textViewBicycle;

    private String selection;
    private String selection1;
    AlertDialog alertDialogWithRadioButtonSex;
    AlertDialog alertDialogWithRadioButtonBike;
    AlertDialog alertDialogWithName;
    AlertDialog alertDialogWithAge;
    AlertDialog alertDialogWithWeight;
    AlertDialog alertDialogWithHeight;


    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {
        View fragmentProfil = inflater.inflate(R.layout.fragment_profile, container, false);
        linerLayoutHeight = fragmentProfil.findViewById(R.id.linerHeight);
        linerLayoutWeight = fragmentProfil.findViewById(R.id.linerWeight);
        linerLayoutSex = fragmentProfil.findViewById(R.id.linerSex);
        linerLayoutName = fragmentProfil.findViewById(R.id.linerName);
        textViewHeight = fragmentProfil.findViewById(R.id.textViewHeight);
        textViewWeight = fragmentProfil.findViewById(R.id.textViewWeight);
        textViewSex = fragmentProfil.findViewById(R.id.textViewSex);
        textViewBicycle = fragmentProfil.findViewById(R.id.textViewBike);
        linerLayoutBike = fragmentProfil.findViewById(R.id.linerBike);
        linerLayoutAge = fragmentProfil.findViewById(R.id.linerAge);

       textViewName = fragmentProfil.findViewById(R.id.textViewName);
        textViewAge = fragmentProfil.findViewById(R.id.textViewAge);


        linerLayoutName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               CreateAlertDialogWithName();
            }
        });
        linerLayoutAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithAge();
            }
        });
        linerLayoutWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithWeight();
            }
        });

        linerLayoutSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithRadioButtonSex();

            }
        });

        linerLayoutBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithRadioButtonBike();
            }
        });
        linerLayoutHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithHeight();
            }
        });

        return fragmentProfil;
    }

    private void CreateAlertDialogWithHeight() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View customHeightLayout = getLayoutInflater().inflate(R.layout.custom_height_layout, null);
        builder.setView(customHeightLayout);
        builder.setTitle(R.string.alertTextHeight);

        builder.setPositiveButton(R.string.posBtnOk, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editTextHeight = customHeightLayout.findViewById(R.id.ed_text_height);
                    float height;
                     if(TextUtils.isEmpty(editTextHeight.getText())){
                         height = 0;
                     } else {
                         height = Float.parseFloat(editTextHeight.getText().toString());
                     } if(height <= 50) {
                        Toast.makeText(getActivity(), R.string.toastCorectValue, Toast.LENGTH_LONG).show();
                        textViewHeight.setText("0");
                    } else if (height >= 300) {
                        Toast.makeText(getActivity(),R.string.toastCorectValue, Toast.LENGTH_LONG).show();
                        textViewHeight.setText("0");
                    } else {
                        textViewHeight.setText(editTextHeight.getText().toString());
                    }

                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("textViewHeight", String.valueOf(textViewHeight));
                editor.commit();
            }
        });
        alertDialogWithHeight = builder.create();
        alertDialogWithHeight.show();
    }

    private void CreateAlertDialogWithWeight() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View customWeightLayout = getLayoutInflater().inflate(R.layout.custom_weight_layout, null);
        builder.setView(customWeightLayout);
        builder.setTitle(R.string.alertTextWeight);

        builder.setPositiveButton(R.string.posBtnOk, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editTextWeight = customWeightLayout.findViewById(R.id.ed_text_weight);
                float weight;
                if(TextUtils.isEmpty(editTextWeight.getText())) {
                    weight = (float) 0.0;
                } else {
                    weight = Float.parseFloat(editTextWeight.getText().toString());
                } if(weight <= 0.0) {
                    Toast.makeText(getActivity(),R.string.toastCorectValue, Toast.LENGTH_LONG).show();
                    textViewWeight.setText("0.0");
                } else if (weight >= 700.0) {
                    Toast.makeText(getActivity(),R.string.toastCorectValue, Toast.LENGTH_LONG).show();
                    textViewWeight.setText("0.0");
                }  else  {
                    textViewWeight.setText(editTextWeight.getText().toString());
                }

                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("textViewWeight", String.valueOf(textViewWeight));
                editor.commit();
            }
        });
        alertDialogWithWeight = builder.create();
        alertDialogWithWeight.show();
    }

    public void CreateAlertDialogWithName() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View customLayout = getLayoutInflater().inflate(R.layout.customlayout, null);
        builder.setView(customLayout);
        builder.setTitle(R.string.alertTextName);

        builder.setPositiveButton(R.string.posBtnOk, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              EditText editText = customLayout.findViewById(R.id.ed_text);
              if(editText.length()<= 0) {
                  editText.setText("0");
                  Toast.makeText(getActivity(), R.string.toastCorectValue, Toast.LENGTH_LONG).show();
              } else {
                  textViewName.setText(editText.getText().toString());
              }

                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("textName", String.valueOf(textViewName));
                editor.commit();
            }
        });
        alertDialogWithName = builder.create();
        alertDialogWithName.show();
    }

    public void CreateAlertDialogWithAge() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View customAgeLayout = getLayoutInflater().inflate(R.layout.custom_age_layout, null);
        builder.setView(customAgeLayout);
        builder.setTitle(R.string.alertTextAge);

        builder.setPositiveButton(R.string.posBtnOk, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              EditText editTextAge = customAgeLayout.findViewById(R.id.ed_text_age);
                float age;
                if(TextUtils.isEmpty(editTextAge.getText())) {
                    age = 0;
                } else {
                   age = Float.parseFloat(editTextAge.getText().toString());
                } if(age <= 0) {
                    Toast.makeText(getActivity(),R.string.toastCorectValue, Toast.LENGTH_LONG).show();
                    textViewAge.setText("0");
                } else if (age >= 130) {
                    Toast.makeText(getActivity(),R.string.toastCorectValue, Toast.LENGTH_LONG).show();
                    textViewAge.setText("0");
                } else {
                    textViewAge.setText(editTextAge.getText().toString());
                }
                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("textAge", String.valueOf(textViewAge));
                editor.commit();
            }
        });
        alertDialogWithAge = builder.create();
        alertDialogWithAge.show();
    }

    public void CreateAlertDialogWithRadioButtonSex() {
       final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.alertTextSex);
        final String[] items = {getString(R.string.sexMale), getString(R.string.female)};
        final int checkItem = 0;
        builder.setSingleChoiceItems(items, checkItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {
                selection = items[item];
            }
        });
        builder.setPositiveButton(R.string.posBtnOk, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textViewSex.setText(selection);
                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("selection", selection);
                editor.commit();
            }
        });
        alertDialogWithRadioButtonSex = builder.create();
        alertDialogWithRadioButtonSex.setCanceledOnTouchOutside(false);
        alertDialogWithRadioButtonSex.show();
    }

    public void CreateAlertDialogWithRadioButtonBike() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.alertTextBike);
        final String[] items = {getString(R.string.city_bicycle),getString(R.string.mountain_bike),getString(R.string.road_bike)};
        final int checkItem = 0;
        builder.setSingleChoiceItems(items, checkItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {
              selection1 = items[item];
            }
        });
        builder.setPositiveButton(R.string.posBtnOk, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
             textViewBicycle.setText(selection1);
                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("selection1", selection1);
                editor.commit();
            }
        });
        alertDialogWithRadioButtonBike = builder.create();
        alertDialogWithRadioButtonBike.setCanceledOnTouchOutside(false);
        alertDialogWithRadioButtonBike.show();
    }
}
