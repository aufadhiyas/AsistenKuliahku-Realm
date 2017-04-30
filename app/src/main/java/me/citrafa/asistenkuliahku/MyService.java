package me.citrafa.asistenkuliahku;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import me.citrafa.asistenkuliahku.ModelClass.DateStorageModel;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.Service.MyBroadcastReceiver;

public class MyService extends Service {

    private final IBinder iBinder = new LocalBinder();

    private HandlerThread mHandlerThread;
    private Handler mHandler;

    Date date1;
    Realm realm;
    DateStorageModel dsm;
    getCurrentDateTime gtm;
    private static String TAG = "";
    long millisJamJK;
    String NamaMakul = "NAMA MAKUL";



    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mHandlerThread = new HandlerThread("LocalServiceThread");
        mHandlerThread.start();
        getJadwalKuliahEarly();
        mHandler = new Handler(mHandlerThread.getLooper());
        Log.d(TAG, "TAG : SERVICE STARTED");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

    public void getJadwalKuliahEarly(){
        realm = Realm.getDefaultInstance();
        gtm = new getCurrentDateTime();
        int noHari = getNoHariHariIni(gtm.getEEE());
        final int year0 = 2011;
        final int month0 = 1;
        final int day0 = 1;
        Calendar c = Calendar.getInstance();
        int jam = c.get(Calendar.HOUR_OF_DAY);
        int minutes = c.get(Calendar.MINUTE);
        long jadis = 10000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formatedDate = sdf.format(new Date(year0,month0,day0,jam,minutes));
        try {
            Date dateMowForJK = sdf.parse(formatedDate);
            JadwalKuliahModel jkm = realm.where(JadwalKuliahModel.class).equalTo("nohari",noHari).greaterThan("waktu_jk",dateMowForJK).findFirst();
            Log.d(TAG,"waktu : CEK ");
            if (jkm != null) {
                SimpleDateFormat formatjam = new SimpleDateFormat("HH:mm");
                Date now = new Date();
                String Nows = formatjam.format(now);
                final String JK = formatjam.format(jkm.getWaktu_jk());
                final long jadi = formatjam.parse(JK).getTime() - formatjam.parse(Nows).getTime();

                scheduleNotification(getNotification(jkm.getMakul_jk()),jadi);

            }else{
                scheduleNotification(getNotification("COBA AJAJ"),10000);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d(TAG,"waktu : error");
        }
    }

    public void TampilKeDashboard(long milis,String Content){

    }

    private void scheduleNotification(Notification notification, long menit) {

        Intent notificationIntent = new Intent(this, MyBroadcastReceiver.class);
        notificationIntent.putExtra(MyBroadcastReceiver.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(MyBroadcastReceiver.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + menit;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis,pendingIntent);
    }

    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("JUDUL NOTIFIKASI");
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.ic_audiotrack_light);
        return builder.build();
    }

    public void getDateEarly(Context contex, TextView txt1, TextView txt2){
        int status = 1;
        Calendar calendar = Calendar.getInstance();


        realm = Realm.getDefaultInstance();
    }

    public int getNoHariHariIni(String EEE){

        if (EEE.equals("Mon")){
            return 1;
        }else if (EEE.equals("Tue")) {
            return 2;
        }else if (EEE.equals("Wed")) {
            return 3;
        }else if (EEE.equals("Thu")) {
            return 4;
        }else if (EEE.equals("Fri")) {
            return 5;
        }else if (EEE.equals("Sat")) {
            return 6;
        }else if (EEE.equals("Sun")) {
            return 7;
        }
        return 0;
    }

    public class getCurrentDateTime{
        Date date;
        int year,month,day,hour,minute;
        String EEE;
        public getCurrentDateTime(){
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.getMinimum(Calendar.MINUTE);
            date = new Date();
            SimpleDateFormat eee = new  SimpleDateFormat("EEE");
            EEE = eee.format(date);
        }

        public Date getDate() {
            return date;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public String getEEE() {
            return EEE;
        }
    }



}
