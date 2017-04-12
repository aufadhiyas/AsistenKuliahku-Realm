package xyz.aufa.asistenkuliahku.AdapterRecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;
import xyz.aufa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import xyz.aufa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 12/04/2017.
 */

public class AdapterJadwalKuliahRV extends RealmRecyclerViewAdapter<JadwalKuliahModel, AdapterJadwalKuliahRV.MyViewHolder> {



    public AdapterJadwalKuliahRV(OrderedRealmCollection<JadwalKuliahModel> data){
        super(data, true);
        setHasStableIds(true);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_jk, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        final JadwalKuliahModel jk = getItem(position);
        holder.data= jk;
        holder.txtHari.setText(jk.getHari_jk());
        holder.txtMakul.setText(jk.getMakul_jk());
        holder.txtJam.setText(jk.getWaktu_jk());
        holder.txtDosen.setText(jk.getDosen_jk());
        holder.txtRuangan.setText(jk.getRuangan_jk());
        holder.txtKelas.setText(jk.getKelas_jk());
    }

    //@Override
   // public int getItemCount(){ return data.size(); }


    class MyViewHolder extends RealmViewHolder {

        private TextView txtHari,txtMakul,txtJam,txtDosen,txtRuangan,txtKelas;
        private JadwalKuliahModel data;

        private MyViewHolder(View container){
            super(container);
            txtHari = (TextView) container.findViewById(R.id.rowhariJK);
            txtJam = (TextView) container.findViewById(R.id.rowJamjk);
            txtMakul = (TextView) container.findViewById(R.id.rowMakul);
            txtDosen = (TextView) container.findViewById(R.id.rowDosen);
            txtRuangan = (TextView) container.findViewById(R.id.rowRuanganjk);
            txtKelas = (TextView) container.findViewById(R.id.rowKelasJK);

        }
    }
}