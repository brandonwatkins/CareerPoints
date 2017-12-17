package edu.mhu.cs.brandonwatkins.careerpoints;

import android.app.Activity;
import android.content.SharedPreferences;

import java.io.Serializable;

/**
 * Created by brandonwatkins on 19/09/17.
 */
/*
public class IOManager implements {
    private static String MAIN_PREFS    = "edu.mhu.cs.bwatkins.MAINPREFS";
    private final static String CPOBJ   = "edu.mhu.cs.bwatkins.CPOBJ";

    static public void saveData(Activity a, cpData data) {
        if (data == null) return;

        SharedPreferences settings = a.getSharedPreferences(MAIN_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString(CPOBJ, data.serialize());

        editor.commit();
    }

    static public cpData loadData(Activity a) {
        SharedPreferences settings = a.getSharedPreferences(MAIN_PREFS, 0);

        cpData data = cpData.create(settings.getString(CPOBJ, ""));

        return data;
    }
}
*/