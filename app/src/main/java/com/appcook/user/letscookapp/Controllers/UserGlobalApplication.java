package com.appcook.user.letscookapp.Controllers;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.appcook.user.letscookapp.Model.AuthenticUser;
import com.appcook.user.letscookapp.Model.SimpleUser;
import com.appcook.user.letscookapp.Model.User;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

public class UserGlobalApplication extends Application {

    public User simpleUser;
    public User authenticUser;
    public static CircularProgressView progressView;
    public static Dialog overlayDialog;

    public UserGlobalApplication() {
        this.simpleUser = new SimpleUser();
        this.authenticUser = new AuthenticUser();
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public String toString() {
        return "UserGlobalApplication{" +
                "simpleUser=" + simpleUser +
                ", authenticUser=" + authenticUser +
                '}';
    }
}
