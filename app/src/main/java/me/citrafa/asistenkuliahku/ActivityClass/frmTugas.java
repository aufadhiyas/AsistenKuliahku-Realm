package me.citrafa.asistenkuliahku.ActivityClass;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import io.realm.Realm;
import io.realm.RealmResults;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.ModelClass.TugasModel;
import me.citrafa.asistenkuliahku.OperationRealm.JadwalKuliahOperation;
import me.citrafa.asistenkuliahku.R;

public class frmTugas extends AppCompatActivity {
    JadwalKuliahModel jadwalKuliahModels;
    TugasModel tugasModel;
    RealmResults<JadwalKuliahModel> jadwalKuliahModel;
    Realm realm;
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

        initview();
        JKO = new JadwalKuliahOperation();

        if(JKO.getNextId() ==1){
            //JadwalKuliah Kosong
            setContentView(R.layout.content_jadwalkulaih_isempty);

        }else{
            //JadwalKuliah Ada
            setContentView(R.layout.frm_tugas);
        }


//        jadwalKuliahModel = realm.where(JadwalKuliahModel.class)
//                .equalTo("no_jk",i)
//                .findFirst();
//        tugasModel = realm.createObject(TugasModel.class);


      //  jadwalKuliahModel.getTugas().add(tugasModel);


    }

    private void initview(){
        txt1 = (EditText) findViewById(R.id.txtDeskripsiTugas);
        txt2 = (EditText) findViewById(R.id.txtWaktuKumpulTugas);
        lbl1 = (TextView) findViewById(R.id.lblMakulTugas);
        lbl2 = (TextView) findViewById(R.id.lblWaktuMakulTugas);
        lblSwitch = (TextView)findViewById(R.id.lblSwitchTugas);
        btn1 = (Button) findViewById(R.id.btnBrowseFileTugas);
        btn2 = (Button) findViewById(R.id.btnSimpanTugas);
    }
    private void CheckJadwalkuliah(){

    }
}
