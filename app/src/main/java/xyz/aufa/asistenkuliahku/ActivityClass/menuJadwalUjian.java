package xyz.aufa.asistenkuliahku.ActivityClass;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import xyz.aufa.asistenkuliahku.R;
import xyz.aufa.asistenkuliahku.fragment_jadwal_ujian_form;
import xyz.aufa.asistenkuliahku.fragment_jadwal_ujian_menu;

public class menuJadwalUjian extends FragmentActivity{
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_jadwal_ujian);
        fab = (FloatingActionButton) findViewById(R.id.fabAddJadwalUjian);

       getSupportFragmentManager().beginTransaction().replace(R.id.content_activity_menu_jk, new fragment_jadwal_ujian_menu()).addToBackStack(null).commit();




    }
    public void onClick(View v){

    }
}
