package xyz.aufa.asistenkuliahku.ActivityClass;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import xyz.aufa.asistenkuliahku.R;

public class menuJadwalKuliah extends AppCompatActivity {

    FloatingActionButton Tambah;
    Button Edit;
    AlertDialog alertDialog;
    ListView listJK;
    String EmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menujk);
        Tambah = (FloatingActionButton) findViewById(R.id.addjk);
        listJK = (ListView) findViewById(R.id.listJadwalKuliah);
        //Edit = (Button) findViewById(R.id.btnEditJK);

        Tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menuJadwalKuliah.this, frmJadwalKuliah.class));
            }
        });

        /*Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });*/

    }
}
