package me.citrafa.asistenkuliahku.ActivityClass;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
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

import com.google.android.gms.maps.model.Dash;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import github.vatsal.easyweather.Helper.TempUnitConverter;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.WeatherMap;
import github.vatsal.easyweather.retrofit.models.Weather;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;
import me.citrafa.asistenkuliahku.DateForAlarmService;
import android.Manifest;
import me.citrafa.asistenkuliahku.R;
import me.citrafa.asistenkuliahku.Service.GPSTracker;
import me.citrafa.asistenkuliahku.Service.ImageLoadTask;
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
    Context mContext;
    DateForAlarmService DFA;
    LocationManager locationManager;
    String provider;
    static double lat, lng;
    int MY_PERMISSION = 0;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        //if (!session.isLoggedIn()){
        //    logoutUser();
       // }



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
