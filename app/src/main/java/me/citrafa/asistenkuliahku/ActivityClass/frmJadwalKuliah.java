package me.citrafa.asistenkuliahku.ActivityClass;

import android.app.TimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import io.realm.Realm;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.R;
import me.citrafa.asistenkuliahku.OperationRealm.JadwalKuliahOperation;

public class frmJadwalKuliah extends AppCompatActivity {

    Spinner sp;
    EditText Ruang, makul, dosen, kelas, Jam;
    Button simpan, batal;
    private int mHour, mMinute;
    private JadwalKuliahModel jk;
    private String currentDateTime, hari;
    private Date waktus,waktuf;
    private Realm realm;
    JadwalKuliahOperation opJK;
    int no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_jadwalkuliah);
        sp = (Spinner) findViewById(R.id.spinnerHari);
        Ruang = (EditText) findViewById(R.id.txtRuangan);
        makul = (EditText) findViewById(R.id.txtMakul);
        dosen = (EditText) findViewById(R.id.txtDosen);
        kelas = (EditText) findViewById(R.id.txtKelas);
        Jam = (EditText) findViewById(R.id.txtJam);
        disableSoftInputFromAppearing(Jam);
        simpan = (Button) findViewById(R.id.btnSimpan);
        batal = (Button) findViewById(R.id.btnBatal);
        opJK = new JadwalKuliahOperation();


        Jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();

                final int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final int mYear = mcurrentTime.get(Calendar.YEAR);
                final int mMonth = mcurrentTime.get(Calendar.MONTH);
                final int mDay = mcurrentTime.get(Calendar.DAY_OF_MONTH);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(frmJadwalKuliah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {//Ontime Set Punya Waktu Mulai
                        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
                        final String Jadis = sdf.format(new Date(mYear,mMonth,mDay,selectedHour,selectedMinute));
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(frmJadwalKuliah.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHourf, int selectedMinutef) {//Ontime Set Punya Waktu Selesai
                                SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
                                String Jadif = sdf.format(new Date(mYear,mMonth,mDay,selectedHourf,selectedMinutef));
                                try {
                                    waktus = sdf.parse(Jadis);
                                    waktuf = sdf.parse(Jadif);
                                    if (waktuf.before(waktus)){
                                        Toast.makeText(frmJadwalKuliah.this, "Jam selesai kuliah kamu tidak valid", Toast.LENGTH_SHORT).show();
                                        simpan.setClickable(false);
                                    }else{
                                        simpan.setClickable(true);
                                    }

                                    SimpleDateFormat jam = new SimpleDateFormat("HH:mm");
                                    String prints = jam.format(waktus);
                                    String printf = jam.format(waktuf);
                                    Jam.setText(prints+" - "+printf);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, hour, minute, true);//Yes 24 hour time
                        mTimePicker.setTitle("Jam Selesai Kuliah");
                        mTimePicker.show();
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Jam Mulai Kuliah");
                mTimePicker.show();

            }
        });
        simpan.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final int no = opJK.getNextId();
                hari = sp.getSelectedItem().toString();
                final Date jams = waktus;
                final Date jamf = waktuf;
                final String Makul= makul.getText().toString().trim();
                final String Ruangan = Ruang.getText().toString().trim();
                final String Dosen = dosen.getText().toString().trim();
                final String Kelas = kelas.getText().toString().trim();
                final String updated_at = getCurrentTimeStamp();
                final String created_at = getCurrentTimeStamp();
                final String Author = "User";
                final int No_Online = 0;
                final String uid = "";
                final boolean status = true;
                final String Type = "Jadwal";
                final int nohari= noHariMen();
                //Toast.makeText(frmJadwalKuliah.this, "SIMPAN : "+hari+", " +Makul, Toast.LENGTH_SHORT).show();

                //memasukkan variable ke constructor
                jk = new JadwalKuliahModel(no, uid, hari, nohari, jams, jamf, Makul, Ruangan, Dosen, Kelas, created_at, updated_at, status, Author,Type,No_Online);

                kosongField();
                Toast.makeText(frmJadwalKuliah.this, "Jadwal Kuliahmu Tersimpan !", Toast.LENGTH_SHORT).show();
                if (hari.equals("Pilih Hari")){
                    Toast.makeText(frmJadwalKuliah.this, "Pilih Hari Dengan Benar", Toast.LENGTH_SHORT).show();
                }else if(hari.equals("Minggu")){
                    AlertHariMinggu();
                }else{
                    insert();
                }
            }
        });
    }

    private void insert(){
        opJK.tambahJadwalKuliah(jk);
    }

    private void AlertHariMinggu(){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(frmJadwalKuliah.this);
        alertDialog.setMessage("Apakah Anda Yakin Ada Kuliah Pada Hari Minggu?");
        alertDialog.setPositiveButton("YA", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                insert();
            }
        });
        alertDialog.setNegativeButton("TIDAK",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                Toast.makeText(frmJadwalKuliah.this, "Silahkan Pilih Hari Anda!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
    public int noHariMen(){
        int no = 0;
        if (hari.equals("Senin")){
            no = 1;
        }else if (hari.equals("Selasa")){
           no = 2;
        }else if (hari.equals("Rabu")){
            no = 3;
        }else if (hari.equals("Kamis")){
            no = 4;
        }else if (hari.equals("Jumat")){
            no = 5;
        }else if (hari.equals("Sabtu")){
            no = 6;
        }else if (hari.equals("Minggu")){
            no = 7;
        }else{
            no = 0;
        }
       return no;
    }
    public void kosongField(){
        sp.setSelection(0);
        Ruang.setText("");
        makul.setText("");
        dosen.setText("");
        kelas.setText("");
        Jam.setText("");
    }

    public static void disableSoftInputFromAppearing(EditText editText) {
        if (Build.VERSION.SDK_INT >= 11) {
            editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
            editText.setTextIsSelectable(true);
        } else {
            editText.setRawInputType(InputType.TYPE_NULL);
            editText.setFocusable(true);
        }
    }

}
