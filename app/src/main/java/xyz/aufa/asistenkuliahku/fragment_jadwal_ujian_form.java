package xyz.aufa.asistenkuliahku;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.plus.PlusOneButton;

import xyz.aufa.asistenkuliahku.ActivityClass.menuJadwalUjian;


public class fragment_jadwal_ujian_form extends Fragment implements View.OnClickListener{
    menuJadwalUjian mju;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jadwal_ujian_form, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    private void initView(View view){

    }

    @Override
    public void onClick(View v) {

    }
}
