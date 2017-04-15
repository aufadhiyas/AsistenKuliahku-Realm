package xyz.aufa.asistenkuliahku;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SENSODYNE on 14/04/2017.
 */

public class fragment_jadwal_ujian_menu extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jadwal_ujian_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }
    private void changeFragment(){
        getFragmentManager().beginTransaction().replace(R.id.content_activity_menu_jk, new fragment_jadwal_ujian_form()).addToBackStack(null).commit();
    }
    private void initView(View view){
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabAddJadwalUjian);
        fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabAddJadwalUjian:
                changeFragment();
                break;
        }
    }
}
