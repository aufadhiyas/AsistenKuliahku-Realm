package xyz.aufa.asistenkuliahku.ActivityClass;

import android.app.TimePickerDialog;

import java.util.Calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import xyz.aufa.asistenkuliahku.ModelClass.jkO;
import xyz.aufa.asistenkuliahku.R;

public class frmJadwalKuliah extends AppCompatActivity {

    Spinner sp;
    EditText Ruang, makul, dosen, kelas, Jam;
    Button simpan, batal;
    private int mHour, mMinute;
    private jkO jk;
    private String currentDateTime;

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
                String hari = sp.getSelectedItem().toString();
                jkO jk=new jkO();




                //Toast.makeText(getApplicationContext(),
                 //       currentDateTime, Toast.LENGTH_SHORT).show();

            }

        });
    }

    public int getNo(int no){

       return no;
    }
    /*public void onClick(View v) {
        if (v == simpan) {
            String hari = sp.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(),
                    hari, Toast.LENGTH_SHORT).show();
        }


    }*/
}
