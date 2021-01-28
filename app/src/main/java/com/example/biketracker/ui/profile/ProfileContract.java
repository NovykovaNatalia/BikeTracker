package com.example.biketracker.ui.profile;

import android.provider.BaseColumns;

public final class ProfileContract {
    private ProfileContract(){

    }
public static final class MemberEntry implements BaseColumns {
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_AGE= "age";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_BIKE = "bike";
    public static final String COLUMN_WEIGHT = "bike";
    public static final String COLUMN_HEIGHT = "bike";


    public static final int GENDER_UNKNOWN = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;

    public static final int CITY_BIKE = 0;
    public static final int MOUNTAIN_BIKE = 2;
    public static final int SPORT_BIKE = 2;



}
}
