package me.citrafa.asistenkuliahku.ActivityClass.Fragment;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v4.app.Fragment;
import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.OpenableColumns;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import io.realm.Realm;
import me.citrafa.asistenkuliahku.ActivityClass.frmDaftar;
import me.citrafa.asistenkuliahku.CustomWidget.LibraryDateCustom;
import me.citrafa.asistenkuliahku.ModelClass.CatatanModel;
import me.citrafa.asistenkuliahku.ModelClass.JadwalLainModel;
import me.citrafa.asistenkuliahku.OperationRealm.CatatanOperation;
import me.citrafa.asistenkuliahku.R;

import static android.support.v4.content.PermissionChecker.checkSelfPermission;


/**
 * Created by SENSODYNE on 17/04/2017.
 */

public class fragment_frm_catatan extends Fragment {
    public static final int FILE_PICKER_REQUEST_CODE = 1;
    private  static final String TAG = fragment_frm_catatan.class.getSimpleName();
    EditText txtNamaCatatan, txtDeskripsi, txtWaktu;
    Button btnAttach, btnSimpan;
    Realm realm;
    TextView lblFile;
    CatatanOperation co;
    Date Dates;
    File source, destination;
    ContentResolver contentResolver;
    int PICKFILE_RESULT_CODE;
    String filePaths;
    CatatanModel cm;

    private static final int MY_READ_EXTERNAL_STORAGE=0;

    private int mYear, mMonth, mDay, mHour, mMinute, id;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frm_catatan, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtNamaCatatan = (EditText) view.findViewById(R.id.txtCatatanNama);
        btnAttach = (Button) view.findViewById(R.id.btnCatatanAttach);
        txtWaktu = (EditText) view.findViewById(R.id.txtWaktuCatatan);
        btnSimpan = (Button) view.findViewById(R.id.btnCatatanSimpan);
        txtDeskripsi = (EditText) view.findViewById(R.id.txtDeskripsiCatatan);
        lblFile = (TextView) view.findViewById(R.id.lblCatatanFileName);
        final LibraryDateCustom LDC = new LibraryDateCustom();
        co = new CatatanOperation();



        btnAttach.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                boolean statusPermission = false;
                statusPermission = isStoragePermissionGranted();
                if (statusPermission !=false){
                    openFilePicker();

                }else{
                    Toast.makeText(getActivity(), "MyCollege Assistant tidak mendapat perizinan untuk membaca file kamu", Toast.LENGTH_SHORT).show();
                    btnAttach.setClickable(false);
                }
            }
        });
        txtWaktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LDC.DateTimePickerSingle(getActivity(), txtWaktu);
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }



    public void SimpanData() {
        int ids = id(10000);
        String nama = txtNamaCatatan.getText().toString().trim();
        Date waktuS = Dates;
        String paths = filePaths;
        String deskripsi = txtDeskripsi.getText().toString();
        String created_at=getCurrentTimeStamp();
        String updated_at=getCurrentTimeStamp();
        String Author="User";
        String noOnline="test";
        cm = new CatatanModel(ids,nama,deskripsi,waktuS,paths,Author,created_at,updated_at,noOnline);
        co.tambahCatatan(cm);
    }
    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(getActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                return true;
            } else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }

    public int id(int status) {
        //10000 untuk Menyimpan Data Di Realm
        //ELSE /Lainnya untuk mengupdate
        if (status == 10000) {
            id = co.getNextId();
        } else {
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


    private void openFilePicker() {
        new MaterialFilePicker()
                .withSupportFragment(fragment_frm_catatan.this)
                .withRequestCode(FILE_PICKER_REQUEST_CODE)
                .withHiddenFiles(true)
                .start();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_PICKER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String path = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            if (path != null) {
                lblFile.setText(path);
                filePaths = path;

            }
        }
    }

}

