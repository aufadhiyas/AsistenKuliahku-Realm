package me.citrafa.asistenkuliahku;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.ModelClass.JadwalLainModel;

/**
 * Created by SENSODYNE on 23/04/2017.
 */

public class DateForAlarmService extends Service {
    Context context;
    Date date1;
    Realm realm;
    public DateForAlarmService(){

    }
    public void getDateEarly(){
        final Date now = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        Calendar today = Calendar.getInstance();

        realm = Realm.getDefaultInstance();
        RealmResults<JadwalLainModel> resultJadwalLain = realm.where(JadwalLainModel.class).equalTo("waktus_jl",now).findAllSorted("waktus_jl", Sort.ASCENDING);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
