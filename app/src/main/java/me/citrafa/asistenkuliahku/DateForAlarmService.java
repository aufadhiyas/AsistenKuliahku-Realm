package me.citrafa.asistenkuliahku;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import me.citrafa.asistenkuliahku.ModelClass.DateStorageModel;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.ModelClass.JadwalLainModel;
import me.citrafa.asistenkuliahku.ModelClass.JadwalUjianModel;

/**
 * Created by SENSODYNE on 23/04/2017.
 */

public class DateForAlarmService{
    Context context;
    Date date1;
    Realm realm;
    DateStorageModel dsm;
    public DateForAlarmService(){

    }




    public void getDateEarly(Context contex,TextView txt1,TextView txt2){
        int status = 1;
        Calendar calendar = Calendar.getInstance();


        realm = Realm.getDefaultInstance();
        //dsm = realm.where(DateStorageModel.class).greaterThan("",).findFirst();

    }

}
