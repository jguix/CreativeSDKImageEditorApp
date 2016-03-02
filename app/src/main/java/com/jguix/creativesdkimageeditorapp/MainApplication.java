package com.jguix.creativesdkimageeditorapp;

import android.app.Application;

import com.aviary.android.feather.sdk.IAviaryClientCredentials;

/**
 * Created by jguixer on 2/3/16.
 */
public class MainApplication extends Application implements IAviaryClientCredentials {

    // Client ID and Client Secret stored in a resources file in res/values/keys.xml
    // private static final String CREATIVE_SDK_CLIENT_ID = "";
    // private static final String CREATIVE_SDK_CLIENT_SECRET = "";

    @Override
    public String getBillingKey() {
        return ""; // Leave this blank
    }

    @Override
    public String getClientID() {
        return getString(R.string.csdk_client_id);
    }

    @Override
    public String getClientSecret() {
        return getString(R.string.csdk_client_secret);
    }
}
