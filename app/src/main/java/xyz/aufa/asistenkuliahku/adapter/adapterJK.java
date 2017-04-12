package xyz.aufa.asistenkuliahku.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;
import xyz.aufa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import xyz.aufa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 12/04/2017.
 */

public class adapterJK extends RealmRecyclerViewAdapter<JadwalKuliahModel, adapterJK.MyViewHolder> {

    private RealmResults<JadwalKuliahModel> JadwalKuliah;

    public adapterJK(OrderedRealmCollection<JadwalKuliahModel> JadwalKuliah){
        super(JadwalKuliah, true);
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
        JadwalKuliahModel jk = JadwalKuliah.get(position);
        holder.JadwalKuliah= jk;
        holder.txtHari.setText(jk.getHari_jk());
        holder.txtMakul.setText(jk.getMakul_jk());
        holder.txtJam.setText(jk.getWaktu_jk());
        holder.txtDosen.setText(jk.getDosen_jk());
        holder.txtRuangan.setText(jk.getRuangan_jk());
        holder.txtKelas.setText(jk.getKelas_jk());
    }

    @Override
    public int getItemCount(){
        return JadwalKuliah.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtHari,txtMakul,txtJam,txtDosen,txtRuangan,txtKelas;
        public JadwalKuliahModel JadwalKuliah;

        public MyViewHolder(View view){
            super(view);
            txtHari = (TextView) view.findViewById(R.id.rowhariJK);
            txtJam = (TextView) view.findViewById(R.id.rowJamjk);
            txtMakul = (TextView) view.findViewById(R.id.rowMakul);
            txtDosen = (TextView) view.findViewById(R.id.rowDosen);
            txtRuangan = (TextView) view.findViewById(R.id.rowRuanganjk);
            txtKelas = (TextView) view.findViewById(R.id.rowKelasJK);

        }
    }
}