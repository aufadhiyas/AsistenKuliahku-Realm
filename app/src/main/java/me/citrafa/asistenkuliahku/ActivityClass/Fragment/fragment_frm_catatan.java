package me.citrafa.asistenkuliahku.ActivityClass.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import me.citrafa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 17/04/2017.
 */

public class fragment_frm_catatan extends Fragment {
    EditText txtNamaCatatan,txtDeskripsi;
    Button btnAttach, btnSimpan;
    TextView lblFile;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frm_catatan, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }
    private void initView(View view){
        EditText txtNamaCatatan = (EditText) view.findViewById(R.id.txtCatatanNama);
        Button btnAttach = (Button)view.findViewById(R.id.btnCatatanAttach);
        Button btnSimpan = (Button)view.findViewById(R.id.btnCatatanSimpan);
        EditText txtDeskripsi = (EditText)view.findViewById(R.id.txtDeskripsiCatatan);
        TextView lblFile = (TextView)view.findViewById(R.id.lblCatatanFileName);
        btnAttach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFile = new Intent();
                intentFile.setAction(Intent.ACTION_GET_CONTENT);
                intentFile.setType("file/*");
                startActivity(intentFile);
            }
        });
    }


}
