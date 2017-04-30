package me.citrafa.asistenkuliahku.ActivityClass;


import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import github.vatsal.easyweather.Helper.TempUnitConverter;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.WeatherMap;
import github.vatsal.easyweather.retrofit.models.Weather;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;
import io.realm.Realm;

import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.MyService;
import me.citrafa.asistenkuliahku.R;
import me.citrafa.asistenkuliahku.Service.GPSTracker;
import me.citrafa.asistenkuliahku.SessionManager.SessionManager;
import me.citrafa.asistenkuliahku.SettingsActivity;

import static java.lang.String.valueOf;
import static me.citrafa.asistenkuliahku.BuildConfig.OWM_API_KEY;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private SessionManager session;
    private static final int REQUEST_PERMISSIONS = 20;
    public ImageView imgProfile;
    public TextView txtnama,txtEmail;
    TextView lblnamaKegiatan,lblTime, lblCelcius;
    ImageView imgWeather;
    Realm realm;
    Context mContext;

    LocationManager locationManager;
    String provider;
    static double lat, lng;
    int MY_PERMISSION = 0;
    GPSTracker gps;
    MyService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            realm = Realm.getDefaultInstance();
            setContentView(R.layout.activity_dashboard);
            WeatherMap weatherMap = new WeatherMap(this, OWM_API_KEY);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            txtnama = (TextView)findViewById(R.id.lblNamaDashboard);
            txtEmail = (TextView)findViewById(R.id.lblEmailDashboard);
            imgProfile = (ImageView)findViewById(R.id.imgProfileDashboard);
            lblnamaKegiatan = (TextView)findViewById(R.id.namaKegiatan) ;
            lblTime = (TextView)findViewById(R.id.TimeRemainingDahsboard) ;
            lblCelcius = (TextView)findViewById(R.id.celciusWeather);
            imgWeather = (ImageView)findViewById(R.id.imgWeather);
            gps = new GPSTracker(this);
            String Lat = Double.toString(gps.getLatitude());
            String Long = Double.toString(gps.getLongitude());
            setSupportActionBar(toolbar);
            session = new SessionManager(getApplicationContext());


            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.hide();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            weatherMap.getLocationWeather(Lat, Long, new WeatherCallback() {
                @Override
                public void success(WeatherResponseModel response) {
                    Weather weather[] = response.getWeather();
                    Double temp = TempUnitConverter.convertToCelsius(response.getMain().getTemp());
                    Integer i = temp.intValue();

                    final String DEGREE  = "\u00b0";
                    String iconLink = weather[0].getIconLink();
                    lblCelcius.setText(valueOf(i)+DEGREE+"C");
                    Picasso.with(Dashboard.this).load(iconLink).into(imgWeather);
                }

                @Override
                public void failure(String message) {

                }
            });

        int noHari = 7;
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
            JadwalKuliahModel jkm = realm.where(JadwalKuliahModel.class).equalTo("nohari", noHari).greaterThan("waktu_jk", dateMowForJK).findFirst();

            if (jkm != null) {
                SimpleDateFormat formatjam = new SimpleDateFormat("HH:mm");
                Date now = new Date();
                String Nows = formatjam.format(now);
                String JK = formatjam.format(jkm.getWaktu_jk());
                final long jadi = formatjam.parse(JK).getTime() - formatjam.parse(Nows).getTime();
                int i = (int) (jadi/1000);
                String NamaMakul = jkm.getMakul_jk();
                lblTime.setText(""+i);


            }else{
                Toast.makeText(this, "Kosong JAdwal Kuliahnya", Toast.LENGTH_SHORT).show();
            }
        }catch (ParseException e) {
            e.printStackTrace();

        }
    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.btnMenuJadwalKuliah) {
            startActivity(new Intent(Dashboard.this, menuJadwalKuliahTab.class));
        } else if (id == R.id.imgProfileDashboard){
            startActivity(new Intent(Dashboard.this, MenuPersonalInfo.class));
        } else if (id == R.id.btnMenuJadwalLain) {
            startActivity(new Intent(Dashboard.this, menuJadwalLain.class));
        } else if (id == R.id.btnMenuUjian) {
            startActivity(new Intent(Dashboard.this, menuJadwalUjian.class));
        } else if (id == R.id.btnmenuCatatan) {
            startActivity(new Intent(Dashboard.this, menuCatatan.class));
        }else if (id==R.id.btnMenuSetting){
            startActivity(new Intent(Dashboard.this, SettingsActivity.class));
        }
        else if (id == R.id.btnMenuTentang) {

        } else if (id == R.id.btnMenuLogout) {
            logoutUser();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void logoutUser(){
        session.setLogin(false);

        Intent i = new Intent(Dashboard.this, frmLogin.class);
        startActivity(i);
        finish();

    }
}
