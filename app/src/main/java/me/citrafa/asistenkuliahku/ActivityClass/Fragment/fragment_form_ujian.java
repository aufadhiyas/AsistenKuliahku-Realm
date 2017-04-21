package me.citrafa.asistenkuliahku.ActivityClass.Fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import me.citrafa.asistenkuliahku.ActivityClass.menuJadwalUjian;
import me.citrafa.asistenkuliahku.ModelClass.JadwalUjianModel;
import me.citrafa.asistenkuliahku.OperationRealm.JadwalUjianOperation;
import me.citrafa.asistenkuliahku.R;


public class fragment_form_ujian extends Fragment {
    menuJadwalUjian mju;
    private Spinner spJenis;
    private EditText txtMakul, txtWaktu, txtDeskripsi, txtRuangan;
    private Button simpan;
    private JadwalUjianModel jum;
    JadwalUjianOperation JUO;
    int id;
    Date dates;
    private int mYear, mMonth, mDay, mHour, mMinute;

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

    private void initView(View view) {
        spJenis = (Spinner) view.findViewById(R.id.spJenisUjian);
        txtMakul = (EditText) view.findViewById(R.id.txtNamaJU);
        txtWaktu = (EditText) view.findViewById(R.id.txtWaktuJU);
        txtDeskripsi = (EditText) view.findViewById(R.id.txtDeskripsiJU);
        txtRuangan = (EditText) view.findViewById(R.id.txtRuanganJU);
        simpan = (Button) view.findViewById(R.id.btnSimpanJu);
    }

    public void SimpanData() {
        int ids = id(10000);
        String Jenis = spJenis.getSelectedItem().toString();
        String Makul = txtMakul.getText().toString().trim();
        Date Waktu = dates;
        String Deskripsi = txtDeskripsi.getText().toString();
        String Ruangan = txtRuangan.getText().toString().trim();
        String Author = "User";
        String created_at = getCurrentTimeStamp();
        String updated_at = getCurrentTimeStamp();
        int Status = 1;
        //jum = new JadwalUjianModel(ids,Jenis,Makul,Waktu,Deskripsi,Ruangan,Status,Author,created_at,updated_at);
        JUO.tambahJadwalUjian(jum);
    }

    public int id(int status) {
        if (status == 10000) {
            id = JUO.getNextId();
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

    public void DateTimePicker() {

            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, final int year,
                                              final int monthOfYear, final int dayOfMonth) {

                            //.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            //DateS = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;

                            final Calendar c = Calendar.getInstance();
                            mHour = c.get(Calendar.HOUR_OF_DAY);
                            mMinute = c.get(Calendar.MINUTE);

                            // Launch Time Picker Dialog
                            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                                    new TimePickerDialog.OnTimeSetListener() {

                                        @Override
                                        public void onTimeSet(TimePicker view, int hourOfDay,
                                                              int minute) {

                                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm");
                                            String formatedDate = sdf.format(new Date(year, monthOfYear, dayOfMonth, hourOfDay, minute));
                                            try {
                                                Date dates = sdf.parse(formatedDate);
                                                SimpleDateFormat Dates = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
                                                String Jadi = Dates.format(dates);
                                                txtWaktu.setText(Jadi);

                                            } catch (ParseException e) {

                                            }
                                        }
                                    }, mHour, mMinute, true);
                            timePickerDialog.show();

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }


}
