package xyz.aufa.asistenkuliahku.ActivityClass;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import xyz.aufa.asistenkuliahku.ActivityClass.Fragment.fragment_frm_catatan;
import xyz.aufa.asistenkuliahku.R;

public class menuCatatan extends AppCompatActivity {
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_catatan);
        fab = (FloatingActionButton)findViewById(R.id.fabAddCatatan);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
                fab.hide();
            }
        });


    }
    private void changeFragment(){
        getFragmentManager().beginTransaction().replace(R.id.activity_menu_catatan, new fragment_frm_catatan()).addToBackStack(null).commit();
    }
}
