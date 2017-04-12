package xyz.aufa.asistenkuliahku.ActivityClass;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import xyz.aufa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import xyz.aufa.asistenkuliahku.R;
import xyz.aufa.asistenkuliahku.adapter.adapterJK;
import xyz.aufa.asistenkuliahku.OperationRealm.RealmBaseActivity;
import xyz.aufa.asistenkuliahku.OperationRealm.JadwalKuliahOperation;

public class menuJadwalKuliah extends AppCompatActivity {

    private FloatingActionButton Tambah;
    private Realm realm;
    private Button Edit;
    private AlertDialog alertDialog;
    private ListView listJK;
    private String EmailView;
    private RecyclerView recyclerView;
    private adapterJK adapterJK;
    private RealmBaseActivity rba;
    private JadwalKuliahOperation jkk;
    //private List<JadwalKuliahModel> jadwalKuliah = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menujk);
        Tambah = (FloatingActionButton) findViewById(R.id.addjk);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerjk);
        //realm.getDefaultInstance();
        setupRecycler();

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


    private void setupRecycler() {

        //realm.getConfiguration();
        RealmResults<JadwalKuliahModel> jk = realm.where(JadwalKuliahModel.class).findAll();
        adapterJK = new adapterJK(jk);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterJK);
        recyclerView.setHasFixedSize(true);

    }

    protected void onDestroy() {
        super.onDestroy();
        recyclerView.setAdapter(null);
        realm.close();
    }

}
