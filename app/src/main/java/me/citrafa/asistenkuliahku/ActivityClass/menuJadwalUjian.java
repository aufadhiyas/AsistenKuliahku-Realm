package me.citrafa.asistenkuliahku.ActivityClass;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.citrafa.asistenkuliahku.R;
import me.citrafa.asistenkuliahku.ActivityClass.Fragment.fragment_form_ujian;

public class menuJadwalUjian extends AppCompatActivity{
    FloatingActionButton fab;
    private Context mContex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_jadwal_ujian);
        fab = (FloatingActionButton) findViewById(R.id.fabAddJadwalUjian);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
                fab.hide();
            }
        });

    }

    private void changeFragment(){
        getFragmentManager().beginTransaction().replace(R.id.activity_menu_ujian, new fragment_form_ujian()).addToBackStack(null).commit();
    }
    public void onStart(){
        super.onStart();
        //fab.show();

    }
    public void onResume(){
        super.onResume();
        fab.show();
    }

    public void onClick(View v){

    }
}
