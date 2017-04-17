package xyz.aufa.asistenkuliahku.ActivityClass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xyz.aufa.asistenkuliahku.R;
import xyz.aufa.asistenkuliahku.fragment_jadwal_ujian_form;

public class menuJadwalLain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_jadwallain);

    }
    private void changeFragment(){
        getFragmentManager().beginTransaction().replace(R.id.activity_menu_jadwal_lain, new fragment_jadwal_ujian_form()).addToBackStack(null).commit();
    }
}
