package me.citrafa.asistenkuliahku.ActivityClass;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;

import io.realm.Realm;
import io.realm.RealmResults;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.ModelClass.TugasModel;
import me.citrafa.asistenkuliahku.OperationRealm.JadwalKuliahOperation;
import me.citrafa.asistenkuliahku.R;

public class frmTugas extends AppCompatActivity {
    private  static final String TAG = frmDaftar.class.getSimpleName();
    JadwalKuliahModel jadwalKuliahModels;
    TugasModel tugasModel;
    JadwalKuliahModel jadwalKuliahModel;
    Realm realm;
    int id;
    JadwalKuliahOperation JKO;
    private EditText txt1,txt2,txt3;
    private TextView lbl1,lbl2, lblSwitch;
    private Button btn1,btn2;
    private String switchOn = "Waktu pengumpulan diluar jam kuliah";
    private String switchOff = "Pengumpulan tugas saat jam kuliah";
    Context mContext;
    private String namaMakul;
    private String hari_makul;
    private String jam_makul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JadwalKuliahOperation JKO = new JadwalKuliahOperation();
        if (JKO.getNextId() == 1) {
            //JadwalKuliah Kosong
            setContentView(R.layout.content_jadwalkulaih_isempty);

        } else {
            //JadwalKuliah Ada
            setContentView(R.layout.frm_tugas);
            realm = Realm.getDefaultInstance();
            txt1 = (EditText) findViewById(R.id.txtDeskripsiTugas);
            txt2 = (EditText) findViewById(R.id.txtWaktuKumpulTugas);
            lbl1 = (me.citrafa.asistenkuliahku.CustomWidget.TextViewLatoFontMedium) findViewById(R.id.lblMakulTugas);
            lbl2 = (me.citrafa.asistenkuliahku.CustomWidget.TextViewLatoFontRegular) findViewById(R.id.lblWaktuMakulTugas);
            lblSwitch = (TextView) findViewById(R.id.lblSwitchTugas);
            btn1 = (Button) findViewById(R.id.btnBrowseFileTugas);
            btn2 = (Button) findViewById(R.id.btnSimpanTugas);

            Intent intent = getIntent();
            int id = intent.getIntExtra("id", 0);
            jadwalKuliahModel = realm.where(JadwalKuliahModel.class).equalTo("no_jk", id).findFirst();
            String nama = jadwalKuliahModel.getMakul_jk();
            SimpleDateFormat jam = new SimpleDateFormat("HH:mm");
            String waktu = jam.format(jadwalKuliahModel.getWaktu_jk());
            lbl1.setText("" + nama);
            lbl2.setText("Jam : " + waktu);
        }
    }


}
