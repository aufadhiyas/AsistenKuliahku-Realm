package xyz.aufa.asistenkuliahku.ActivityClass.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import xyz.aufa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 17/04/2017.
 */

public class fragment_frm_catatan extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jadwal_ujian_form, container, false);
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

    }


}
