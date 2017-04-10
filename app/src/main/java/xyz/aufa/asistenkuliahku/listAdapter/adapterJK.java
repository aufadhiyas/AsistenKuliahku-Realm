package xyz.aufa.asistenkuliahku.listAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import xyz.aufa.asistenkuliahku.ModelClass.jkO;
import xyz.aufa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 10/04/2017.
 */

public class adapterJK extends ArrayAdapter<jkO> implements View.OnClickListener{


    private ArrayList<jkO> dataSet;
    Context contex;

    private static class ViewHolder{
        TextView txtHari, txtWaktu, txtMakul, txtDosen, txtRuangan, txtKelas;
    }
    public adapterJK(ArrayList<jkO> data, Context context){
        super(context, R.layout.row_jk, data);
        this.dataSet = data;
        this.contex = context;
    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object = getItem(position);

    }
    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        jkO jk=getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_jk, parent, false);
            viewHolder.txtHari = (TextView) convertView.findViewById(R.id.rowhariJK);
            viewHolder.txtMakul = (TextView) convertView.findViewById(R.id.rowMakul);
            viewHolder.txtWaktu = (TextView) convertView.findViewById(R.id.rowJamjk);
            viewHolder.txtDosen = (TextView) convertView.findViewById(R.id.rowDosen);
            viewHolder.txtKelas = (TextView) convertView.findViewById(R.id.rowKelasJK);
            viewHolder.txtRuangan = (TextView) convertView.findViewById(R.id.rowRuanganjk);
            result = convertView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        //TAMBAH ANIMASI
        //SETTEXT
        //Tambah Listener
        // Return the completed view to render on screen
        return convertView;

    }

}
