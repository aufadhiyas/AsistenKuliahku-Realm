package xyz.aufa.asistenkuliahku.SessionManager;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by SENSODYNE on 09/04/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
