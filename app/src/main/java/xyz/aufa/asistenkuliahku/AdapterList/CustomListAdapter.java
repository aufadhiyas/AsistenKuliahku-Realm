package xyz.aufa.asistenkuliahku.AdapterList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import xyz.aufa.asistenkuliahku.AdapterRecycleView.AdapterJadwalKuliahRV;
import xyz.aufa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import xyz.aufa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 14/04/2017.
 */

public class CustomListAdapter extends BaseAdapter{

    private ArrayList <JadwalKuliahModel> data;
    private Context mContex;
    
    public CustomListAdapter(ArrayList<JadwalKuliahModel> data, Context context){
        this.data = data;
        this.mContex = context;
    }
    
    
    
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public JadwalKuliahModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_jk, parent, false);

        JadwalKuliahModel jk = getItem(position);
        RelativeLayout relativeLayout = new RelativeLayout(mContex);

        TextView txtHari = (TextView) itemView.findViewById(R.id.rowhariJK);
        TextView txtJam = (TextView) itemView.findViewById(R.id.rowJamjk);
        TextView txtMakul = (TextView) itemView.findViewById(R.id.rowMakul);
        TextView txtDosen = (TextView) itemView.findViewById(R.id.rowDosen);
        TextView txtRuangan = (TextView) itemView.findViewById(R.id.rowRuanganjk);
        TextView txtKelas = (TextView) itemView.findViewById(R.id.rowKelasJK);

        txtHari.setText(jk.getHari_jk());
        txtMakul.setText(jk.getMakul_jk());
        txtJam.setText(jk.getWaktu_jk());
        txtDosen.setText(jk.getDosen_jk());
        txtRuangan.setText(jk.getRuangan_jk());
        txtKelas.setText(jk.getKelas_jk());
        relativeLayout.setTag(jk);
        return itemView;
    }
}
