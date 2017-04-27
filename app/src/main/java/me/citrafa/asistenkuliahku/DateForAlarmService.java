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
    public DateForAlarmService(){

    }


    private Date yesterday(){
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }
    private Date tomorrow(){
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public void getDateEarly(Context contex,TextView txt1,TextView txt2){
        int status = 1;

        realm = Realm.getDefaultInstance();

//        JadwalLainModel resultJadwalLain = realm.where(JadwalLainModel.class)
//                .between("waktus_jl",yesterday(),tomorrow())
//                .findAllSorted("waktus_jl",Sort.ASCENDING).first();
//        if (resultJadwalLain.isLoaded()){
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yy");
//            txt1.setText(resultJadwalLain.getNama_jl());
//            txt2.setText(sdf.format(resultJadwalLain.getWaktuf_jl()));

//        }else {
//            Toast.makeText(contex, "Hati Ini Libur", Toast.LENGTH_SHORT).show();
//        }

        //JadwalUjianModel resultUjianModel = realm.where(JadwalUjianModel.class).equalTo("waktu",now).equalTo("status",status).findFirst();


    }

}
