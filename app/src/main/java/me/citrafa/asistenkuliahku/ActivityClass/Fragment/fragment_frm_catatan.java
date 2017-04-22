package me.citrafa.asistenkuliahku.ActivityClass.Fragment;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import me.citrafa.asistenkuliahku.CustomWidget.LibraryDateCustom;
import me.citrafa.asistenkuliahku.ModelClass.CatatanModel;
import me.citrafa.asistenkuliahku.ModelClass.JadwalLainModel;
import me.citrafa.asistenkuliahku.OperationRealm.CatatanOperation;
import me.citrafa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 17/04/2017.
 */

public class fragment_frm_catatan extends Fragment {
    EditText txtNamaCatatan,txtDeskripsi,txtWaktu;
    Button btnAttach, btnSimpan;
    TextView lblFile;
    Realm realm;
    CatatanModel cm;
    CatatanOperation co;
    Date Dates;
    private int mYear, mMonth, mDay, mHour, mMinute,id;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frm_catatan, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText txtNamaCatatan = (EditText) view.findViewById(R.id.txtCatatanNama);
        Button btnAttach = (Button)view.findViewById(R.id.btnCatatanAttach);
        final EditText txtWaktu = (EditText)view.findViewById(R.id.txtWaktuCatatan) ;
        Button btnSimpan = (Button)view.findViewById(R.id.btnCatatanSimpan);
        EditText txtDeskripsi = (EditText)view.findViewById(R.id.txtDeskripsiCatatan);
        TextView lblFile = (TextView)view.findViewById(R.id.lblCatatanFileName);
        final LibraryDateCustom LDC = new LibraryDateCustom();
        btnAttach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFile = new Intent();
                intentFile.setAction(Intent.ACTION_GET_CONTENT);
                intentFile.setType("file/*");
                startActivity(intentFile);
            }
        });
        txtWaktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LDC.DateTimePickerSingle(getActivity(),txtWaktu);
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void SimpanData() {
//        int ids = id(10000);
//        String nama = txtNamaCatatan.getText().toString().trim();
//        Date waktuS = Dates;
//
//
//        String deskripsi = txtdeskripsi.getText().toString();
//        int status = 1;
//        String created_at=getCurrentTimeStamp();
//        String updated_at=getCurrentTimeStamp();
//        String Author="User";
//        String noOnline="test";
//        jml = new JadwalLainModel(ids,nama,waktuS,waktuF,tempat,deskripsi,status,Author,created_at,updated_at,noOnline);
//        JUO.tambahJadwalLain(jml);

    }
    public int id(int status){
        //10000 untuk Menyimpan Data Di Realm
        //ELSE /Lainnya untuk mengupdate
        if (status==10000){
            id = co.getNextId();
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
