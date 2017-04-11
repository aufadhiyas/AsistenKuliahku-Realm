package xyz.aufa.asistenkuliahku.ActivityClass;

import android.app.TimePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import io.realm.Realm;
import xyz.aufa.asistenkuliahku.ModelClass.jkO;
import xyz.aufa.asistenkuliahku.R;
import xyz.aufa.asistenkuliahku.opRealm.jkOP;

public class frmJadwalKuliah extends AppCompatActivity {

    Spinner sp;
    EditText Ruang, makul, dosen, kelas, Jam;
    Button simpan, batal;
    private int mHour, mMinute;
    private jkO jk;
    private String currentDateTime;
    private Realm realm;
    jkOP opJK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmjk);
        sp = (Spinner) findViewById(R.id.spinnerHari);
        Ruang = (EditText) findViewById(R.id.txtRuangan);
        makul = (EditText) findViewById(R.id.txtMakul);
        dosen = (EditText) findViewById(R.id.txtDosen);
        kelas = (EditText) findViewById(R.id.txtKelas);
        Jam = (EditText) findViewById(R.id.txtJam);
        simpan = (Button) findViewById(R.id.btnSimpan);
        batal = (Button) findViewById(R.id.btnBatal);
        opJK = new jkOP();
        getCurrentTimeStamp();


        Jam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(frmJadwalKuliah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Jam.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        simpan.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final int no = opJK.getNextId();
                final String hari = sp.getSelectedItem().toString();
                final String jam = Jam.getText().toString().trim();
                final String Makul= makul.getText().toString().trim();
                final String Ruangan = Ruang.getText().toString().trim();
                final String Dosen = dosen.getText().toString().trim();
                final String Kelas = kelas.getText().toString().trim();
                final String updated_at = getCurrentTimeStamp();
                final String created_at = getCurrentTimeStamp();
                final String Author = "User";
                final int No_Online = 0;
                jk = new jkO(no, hari, jam, Makul, Ruangan, Dosen, Kelas, created_at, updated_at, Author,No_Online);
                opJK.tambahJadwalKuliah(jk);

            }

        });
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    /*public void onClick(View v) {
        if (v == simpan) {
            String hari = sp.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(),
                    hari, Toast.LENGTH_SHORT).show();
        }


    }*/
}
