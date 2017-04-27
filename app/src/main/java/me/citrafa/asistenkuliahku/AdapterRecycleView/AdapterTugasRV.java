package me.citrafa.asistenkuliahku.AdapterRecycleView;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import io.realm.OrderedRealmCollection;
import io.realm.RealmList;
import io.realm.RealmRecyclerViewAdapter;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.ModelClass.JadwalLainModel;
import me.citrafa.asistenkuliahku.ModelClass.TugasModel;

/**
 * Created by SENSODYNE on 27/04/2017.
 */

public class AdapterTugasRV extends RealmRecyclerViewAdapter<JadwalKuliahModel, AdapterTugasRV.MyViewHolder> {

    OrderedRealmCollection<JadwalKuliahModel> data;
    RealmList<TugasModel> tugasModels;
    RealmList<JadwalKuliahModel> jadwalKuliahModels;

    public AdapterTugasRV(@Nullable OrderedRealmCollection<JadwalKuliahModel> data
            , RealmList<TugasModel> tugasModels
            ,RealmList<JadwalKuliahModel>jadwalKuliahModels) {

        super(data, true);
        this.data = data;
        this.jadwalKuliahModels = jadwalKuliahModels;
        this.tugasModels = tugasModels;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
