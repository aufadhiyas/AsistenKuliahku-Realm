package xyz.aufa.asistenkuliahku.ActivityClass;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import xyz.aufa.asistenkuliahku.ModelClass.jkO;
import xyz.aufa.asistenkuliahku.R;
import xyz.aufa.asistenkuliahku.adapter.adapterJK;
import xyz.aufa.asistenkuliahku.opRealm.RealmBaseActivity;

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
    //private List<jkO> jadwalKuliah = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menujk);
        Tambah = (FloatingActionButton) findViewById(R.id.addjk);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerjk);
        //Realm.setDefaultConfiguration(rba.getRealmConfiguration());
        realm = Realm.getDefaultInstance();



       // setupRecycler();
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
        RealmResults<jkO> jk = realm.where(jkO.class).findAll();
        adapterJK = new adapterJK(jk);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterJK);
        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        /*TouchHelperCallback touchHelperCallback = new TouchHelperCallback();
        ItemTouchHelper touchHelper = new ItemTouchHelper(touchHelperCallback);
        touchHelper.attachToRecyclerView(recyclerView);*/
    }
    private RealmConfiguration getRealmConfig() {
        return new RealmConfiguration
                .Builder()
                .modules(Realm.getDefaultModule(), new jkO())
                .build();
    }
    protected void onDestroy() {
        super.onDestroy();
        recyclerView.setAdapter(null);
        realm.close();
    }

}
