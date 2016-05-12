package com.beliautopart.beliautopart.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by brandon on 12/05/16.
 */
public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Edcounting";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_IS_USERNAME = "username";
    private static final String KEY_IS_FULLNAME = "fullname";
    private static final String KEY_IS_EMAIL = "email";
    private static final String KEY_IS_NOHP = "nohp";
    private static final String KEY_IS_SEKOLAH = "sekolah";
    private static final String KEY_IS_USERID = "userId";
    private static final String KEY_IS_STATUS = "status";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public void setUsername(String username) {
        editor.putString(KEY_IS_USERNAME, username);
        // commit changes
        editor.commit();
        Log.d(TAG, "Username session modified!");
    }

    public void setStatus(int status) {
        editor.putInt(KEY_IS_STATUS, status);
        // commit changes
        editor.commit();
        Log.d(TAG, "Username session modified!");
    }

    public void setId(String uid) {
        editor.putString(KEY_IS_USERID, uid);
        // commit changes
        editor.commit();
        Log.d(TAG, "userId session modified!");
    }

    public void setFullName(String gcm) {
        editor.putString(KEY_IS_FULLNAME, gcm);
        // commit changes
        editor.commit();
        Log.d(TAG, "Fullname session modified!");
    }

    public void setEmail(String gcm) {
        editor.putString(KEY_IS_EMAIL, gcm);
        // commit changes
        editor.commit();
        Log.d(TAG, "Email session modified!");
    }

    public void setNoHp(String gcm) {
        editor.putString(KEY_IS_NOHP, gcm);
        // commit changes
        editor.commit();
        Log.d(TAG, "Nohp session modified!");
    }

    public void setSekolah(String gcm) {
        editor.putString(KEY_IS_SEKOLAH, gcm);
        // commit changes
        editor.commit();
        Log.d(TAG, "Sekolah session modified!");
    }

    public String getUsername() {
        return pref.getString(KEY_IS_USERNAME, "user");
    }

    public int getStatus() {
        return pref.getInt(KEY_IS_STATUS, 1);
    }

    public String getId() {
        return pref.getString(KEY_IS_USERID, "userId");
    }

    public String getFullName() {
        return pref.getString(KEY_IS_FULLNAME, "");
    }

    public String getEmail() {
        return pref.getString(KEY_IS_EMAIL, "");
    }

    public String getNOHp() {
        return pref.getString(KEY_IS_NOHP, "");
    }

    public String getSekolah() {
        return pref.getString(KEY_IS_SEKOLAH, "");
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }
}
