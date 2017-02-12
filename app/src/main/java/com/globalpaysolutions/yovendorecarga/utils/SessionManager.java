package com.globalpaysolutions.yovendorecarga.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Josué Chávez on 10/02/2017.
 */

public class SessionManager
{
    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;
    Context mContext;
    int PRIVATE_MODE = 0;

    /*  PREFERENCIAS DEL PIN    */
    SharedPreferences mPinPreferences;
    SharedPreferences.Editor mPinEditor;

    /*  PREFERENCIAS DE NOTIFICACIONES  */
    SharedPreferences NotificationsSettings;
    SharedPreferences.Editor NotificationsEditor;

    /*  ENCRIPTACION/DECRIPTACION  */
    String KEY = "8080808080808089"; //llave
    String IV = "8080808080808090"; // vector de inicialización


    private static final String PREF_NAME = "yvsPref";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_BALANCE = "availableBalance";
    public static final String KEY_USER_EMAIL = "userEmail";
    public static final String KEY_TOKEN = "userToken";
    public static final String KEY_FIRST_NAME = "firstName";
    public static final String KEY_LAST_NAME = "lastName";
    public static final String KEY_REMEMBER_EMAIL = "rememberEmail";
    public static final String KEY_PPW = "userOtherWayConffirmation";
    public static final String KEY_SESSION_ID = "sessionID";
    public static final String KEY_VENDOR_M = "vendorM";
    public static final String KEY_COUNTRY_ID = "countryId";
    public static final String KEY_ISO3_CODE = "iso3Code";
    public static final String KEY_PHONE_CODE = "PhoneCode";
    public static final String KEY_VENDOR_CODE = "VendorCode";
    public static final String KEY_SHOWCASE_SHOWN = "ShowcaseViewShown";
    private static final String KEY_DEVICE_IP_ADDRESS = "device_ip_address";
    private static final String KEY_DEVICE_ID = "device_id";

    public static final String KEY_ACTIVATE_PIN = "securityPin";
    public static final String KEY_PIN_CODE = "pinCode";

    public SessionManager(Context pContext)
    {
        this.mContext = pContext;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPreferences.edit();

        //Obtiene las preferencias guardadas en las Preferences
        mPinPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mPinEditor = mPinPreferences.edit();

    }

    /*
    * **************************************************
    *
    *   SAVE
    *
    * *************************************************
    */


    public void saveDeviceIpAddress(String pAddress)
    {
        mEditor.putString(KEY_DEVICE_IP_ADDRESS, pAddress);
        mEditor.commit();
    }

    public void saveDeviceID(String pDeviceId)
    {
        mEditor.putString(KEY_DEVICE_ID, pDeviceId);
        mEditor.commit();
    }

    public void saveUserPassword(String pPass)
    {
        mEditor.putString(KEY_PPW, pPass);
        mEditor.commit();
    }

    public void saveUserToken(String pToken)
    {
        mEditor.putString(KEY_TOKEN, pToken);
        mEditor.commit();
    }

    public void saveUserPin(String pUserPin)
    {
        mPinEditor.putString(KEY_PIN_CODE, pUserPin);
        mPinEditor.commit();
    }



    /*
    * **************************************************
    *
    *   RETRIEVE
    *
    * *************************************************
    */

    public String getDeviceIpAddress()
    {
        String deviceIpAddress = mPreferences.getString(KEY_DEVICE_IP_ADDRESS, "");
        return deviceIpAddress;
    }

    public String getDeviceID()
    {
        String deviceID = mPreferences.getString(KEY_DEVICE_ID, "");
        return deviceID;
    }

    public String getUserPassword()
    {
        String password = mPreferences.getString(KEY_PPW, "");
        return password;
    }

    public String getUserToken()
    {
        return mPreferences.getString(KEY_TOKEN, "");

    }

    public String getUserPin()
    {
        String securityPin = mPinPreferences.getString(KEY_PIN_CODE, "");
        return securityPin;
    }



    /*
    *
    *
    * SESION DEL USUARIO
    *
    */

    //Guarda los datos de la sesión
    public void createLoginSession(String pEmail, String pToken, String pBalance, int pSessionID, boolean pVendorM,
                                   String pCountryID, String pISO3code, String pPhoneCode, int pVendorCode)
    {
        mEditor.putBoolean(IS_LOGIN, true);
        mEditor.putString(KEY_USER_EMAIL, pEmail);
        mEditor.putString(KEY_TOKEN, pToken);
        mEditor.putString(KEY_BALANCE, pBalance);
        mEditor.putInt(KEY_SESSION_ID, pSessionID);
        mEditor.putBoolean(KEY_VENDOR_M, pVendorM);
        mEditor.putString(KEY_COUNTRY_ID, pCountryID);
        mEditor.putString(KEY_ISO3_CODE, pISO3code);
        mEditor.putString(KEY_PHONE_CODE, pPhoneCode);
        mEditor.putInt(KEY_VENDOR_CODE, pVendorCode);
        mEditor.commit();
    }

    /*
    *
    *
    *   PERFIL DEL USUARIO
    *
    */
    //Guarda el nombre y apellido del usuario
    public void saveUserProfile(String pFirstname, String pLastname)
    {
        mEditor.putString(KEY_FIRST_NAME, pFirstname);
        mEditor.putString(KEY_LAST_NAME, pLastname);
        mEditor.commit();
    }
}
