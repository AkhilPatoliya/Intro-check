package com.akhil.internetconnectionutility;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityReceiver extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityReceiverListener;

    public ConnectivityReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent arg1) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        //  NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting() && cm.getActiveNetworkInfo().isConnected()
                && cm.getActiveNetworkInfo().isAvailable();
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
    }

    public static boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) Connection.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    //    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting()&& cm.getActiveNetworkInfo().isConnected()
                && cm.getActiveNetworkInfo().isAvailable();

    }

    public static boolean isDisconnected() {
        ConnectivityManager cm = (ConnectivityManager) Connection.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork == null && activeNetwork.isFailover();
    }


    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }

}
