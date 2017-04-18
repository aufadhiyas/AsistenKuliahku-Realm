package xyz.aufa.asistenkuliahku.ActivityClass.Fragment;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import xyz.aufa.asistenkuliahku.ModelClass.JadwalLainModel;
import xyz.aufa.asistenkuliahku.ModelClass.JadwalUjianModel;
import xyz.aufa.asistenkuliahku.OperationRealm.JadwalLainOperation;
import xyz.aufa.asistenkuliahku.R;

public class fragment_frmJadwalLain extends Fragment {
    private EditText txtNama,txtwaktuS,txtwaktuF,txttempat,txtdeskripsi;
    private Button btnSimpan;
    private int id;
    private JadwalLainOperation JUO;
    private JadwalLainModel jml;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frm_jadwal_lain, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }
    private void initView(View view){
        txtNama = (EditText)view.findViewById(R.id.txtNamaJl);
        txtwaktuS = (EditText)view.findViewById(R.id.txtWaktuJlS);
        txtwaktuF = (EditText)view.findViewById(R.id.txtWaktuJlF);
        txttempat = (EditText)view.findViewById(R.id.txtTempatJl);
        txtdeskripsi = (EditText)view.findViewById(R.id.txtDeskripsiJl);
        btnSimpan = (Button)view.findViewById(R.id.btnSimpanJl);
    }
    public void SimpanData() {
        int ids = id(10000);
        String nama = txtNama.getText().toString().trim();
        String waktuS = txtwaktuS.getText().toString();
        String waktuF = txtwaktuF.getText().toString();
        String tempat = txttempat.getText().toString().trim();
        String deskripsi = txtdeskripsi.getText().toString();
        int status = 1;
        String created_at=getCurrentTimeStamp();
        String updated_at=getCurrentTimeStamp();
        String Author="User";
        String noOnline="test";
        jml = new JadwalLainModel(ids,nama,waktuS,waktuF,tempat,deskripsi,status,Author,created_at,updated_at,noOnline);
        JUO.tambahJadwalLain(jml);

    }
    public int id(int status){
        //10000 untuk Menyimpan Data Di Realm
        //Lainnya untuk mengupdate
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
