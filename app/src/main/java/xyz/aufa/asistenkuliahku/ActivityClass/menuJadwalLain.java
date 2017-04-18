package xyz.aufa.asistenkuliahku.ActivityClass;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import xyz.aufa.asistenkuliahku.ActivityClass.Fragment.fragment_frmJadwalLain;
import xyz.aufa.asistenkuliahku.R;
import xyz.aufa.asistenkuliahku.fragment_jadwal_ujian_form;

public class menuJadwalLain extends AppCompatActivity {
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_jadwallain);
        fab = (FloatingActionButton)findViewById(R.id.fabAddJadwalLain);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
                fab.hide();
            }
        });
    }
    private void changeFragment(){
        getFragmentManager().beginTransaction().replace(R.id.activity_menu_jadwal_lain, new fragment_frmJadwalLain()).addToBackStack(null).commit();
    }
}
