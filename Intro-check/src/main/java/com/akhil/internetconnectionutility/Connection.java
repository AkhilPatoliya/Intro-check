package com.akhil.internetconnectionutility;

import android.app.Application;

/**
 * Created by akhil.patoliya on 3/18/2017.
 */

public class Connection extends Application {
    private static Connection mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized Connection getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

}
