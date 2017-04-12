package xyz.aufa.asistenkuliahku.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import xyz.aufa.asistenkuliahku.ModelClass.jkO;
import xyz.aufa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 12/04/2017.
 */

public class adapterJK extends RecyclerView.Adapter<adapterJK.ViewHolder> {

    private List<jkO> JadwalKuliah;
    protected LayoutInflater inflater;
    private RecyclerView mAttachedRecyclerView;
    private int mClickedPosition = -1;
    private Context mContext;
    private Realm realm;


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtHari,txtMakul,txtJam,txtDosen,txtRuangan,txtKelas;

        public ViewHolder(View view){
            super(view);
            txtHari = (TextView) view.findViewById(R.id.rowhariJK);
            txtJam = (TextView) view.findViewById(R.id.rowJamjk);
            txtMakul = (TextView) view.findViewById(R.id.rowMakul);
            txtDosen = (TextView) view.findViewById(R.id.rowDosen);
            txtRuangan = (TextView) view.findViewById(R.id.rowRuanganjk);
            txtKelas = (TextView) view.findViewById(R.id.rowKelasJK);
        }
    }
    public adapterJK(List<jkO> JadwalKuliah){
        this.JadwalKuliah = JadwalKuliah;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        realm.getDefaultInstance();
        RealmQuery<jkO> query = realm.where(jkO.class);
        RealmResults<jkO> JadwalKuliah = query.findAll();
        final jkO jk = JadwalKuliah.get(position);
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
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_jk, parent, false);
        return new ViewHolder(v);
    }


}
