package xyz.aufa.asistenkuliahku.ActivityClass.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.PlusOneButton;

import java.text.SimpleDateFormat;
import java.util.Date;

import xyz.aufa.asistenkuliahku.ActivityClass.menuJadwalUjian;
import xyz.aufa.asistenkuliahku.ModelClass.JadwalUjianModel;
import xyz.aufa.asistenkuliahku.OperationRealm.JadwalUjianOperation;
import xyz.aufa.asistenkuliahku.R;


public class fragment_form_ujian extends Fragment{
    menuJadwalUjian mju;
    private Spinner spJenis;
    private EditText txtMakul, txtWaktu, txtDeskripsi,txtRuangan;
    private Button simpan;
    private JadwalUjianModel jum;
    JadwalUjianOperation JUO;
    int id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jadwal_ujian_form, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        JUO = new JadwalUjianOperation();
        initView(view);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpanData();
            }
        });

    }
    private void initView(View view){
        spJenis = (Spinner)view.findViewById(R.id.spJenisUjian);
        txtMakul = (EditText)view.findViewById(R.id.txtNamaJU);
        txtWaktu = (EditText)view.findViewById(R.id.txtWaktuJU);
        txtDeskripsi = (EditText)view.findViewById(R.id.txtDeskripsiJU);
        txtRuangan = (EditText)view.findViewById(R.id.txtRuanganJU);
        simpan = (Button)view.findViewById(R.id.btnSimpanJu);
    }

    public void SimpanData() {
        int ids = id(10000);
        String Jenis = spJenis.getSelectedItem().toString();
        String Makul = txtMakul.getText().toString().trim();
        String Waktu = txtWaktu.getText().toString();
        String Deskripsi = txtDeskripsi.getText().toString();
        String Ruangan = txtRuangan.getText().toString().trim();
        String Author="User";
        String created_at = getCurrentTimeStamp();
        String updated_at = getCurrentTimeStamp();
        int Status = 1;
        jum = new JadwalUjianModel(ids,Jenis,Makul,Waktu,Deskripsi,Ruangan,Status,Author,created_at,updated_at);
        JUO.tambahJadwalUjian(jum);
    }
    public int id(int status){
        if (status==10000){
            id = JUO.getNextId();
        }else{
            id = status;
        }
        return id;
    }


    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
