package com.example.shanindu.hearts.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class sharedPref {

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "UserLogin";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    public sharedPref(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d("sharedPref", "User login session modified!");
    }

    public boolean isLoggedIn()
    {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // save uname and pword
    public void setAuthentication(String Uname, String pword) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("uname", Uname);
        editor.putString("pword", pword);
        editor.commit();
    }

    public String[] getAuthentication() {
        return new String[]{pref.getString("uname", ""),
                pref.getString("pword", "")};
    }


    public void clearAuthentication() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("uname", "");
        editor.putString("pword", "");
        editor.commit();
    }


    /*Set User type*/
    public void setUserType(int userType) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("USER_TYPE", userType);
        editor.commit();
    }

    /*Retrieve User type*/
    public int getUserType() {
        return pref.getInt("USER_TYPE", 0);
    }

    /*Clear User type*/
    public void clearUserType() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("USER_TYPE", 0);
        editor.commit();
    }
    public void setUserId(int userId) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("USER_ID", userId);
        editor.commit();
    }

    public int getUserId() {
        return pref.getInt("USER_ID", 0);
    }

    /*Clear User type*/
    public void clearUserTypeId() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("USER_TYPE", 2);
        editor.commit();
    }

    public void clear_shared_pref() {

        pref.edit().clear().commit();

    }

}



