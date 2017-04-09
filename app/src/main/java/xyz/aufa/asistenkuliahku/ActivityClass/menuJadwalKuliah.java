package xyz.aufa.asistenkuliahku.ActivityClass;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import xyz.aufa.asistenkuliahku.R;

public class menuJadwalKuliah extends AppCompatActivity {

    Button Tambah,Edit;
    AlertDialog alertDialog;
    String EmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jadwal_kuliah);
        Tambah = (Button) findViewById(R.id.btnTambahJL);
        Edit = (Button) findViewById(R.id.btnEditJK);

        Tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menuJadwalKuliah.this, frmJadwalKuliah.class));
            }
        });

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });

    }
}