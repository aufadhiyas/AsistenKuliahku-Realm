package me.citrafa.asistenkuliahku.AdapterList;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.citrafa.asistenkuliahku.ActivityClass.frmTugas;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;
import me.citrafa.asistenkuliahku.R;

/**
 * Created by SENSODYNE on 14/04/2017.
 */

public class CustomListAdapter extends BaseAdapter{

    private ArrayList <JadwalKuliahModel> data;
    private Context mContex;
    private int ids;
    
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_jk, parent, false);

        String ColorHijau = "#27ae60";
        String ColorRed = "#c0392b";

        JadwalKuliahModel jk = getItem(position);
        RelativeLayout relativeLayout = new RelativeLayout(mContex);

        TextView txtHari = (TextView) itemView.findViewById(R.id.rowhariJK);
        TextView txtJam = (TextView) itemView.findViewById(R.id.rowJamjk);
        TextView txtMakul = (TextView) itemView.findViewById(R.id.rowMakul);
        TextView txtDosen = (TextView) itemView.findViewById(R.id.rowDosen);
        TextView txtRuangan = (TextView) itemView.findViewById(R.id.rowRuanganjk);

        ImageView imgTugas = (ImageView)itemView.findViewById(R.id.iconTugasRowJK);
        TextView statusTugas = (TextView)itemView.findViewById(R.id.rowstatusTugasJK);
        final ImageButton imgButtonJK = (ImageButton)itemView.findViewById(R.id.menuOptionJK);

        txtHari.setText(jk.getHari_jk());
        txtMakul.setText(jk.getMakul_jk());
        txtJam.setText(jk.getWaktu_jk());
        txtDosen.setText(jk.getDosen_jk());
        txtRuangan.setText(jk.getKelas_jk()+" / "+jk.getRuangan_jk());
        relativeLayout.setTag(jk);
        ids = jk.getNo_jk();

        imgButtonJK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(imgButtonJK,position,ids);
            }
        });
        return itemView;
    }
    private void showPopupMenu(View view, int position, int id){
        PopupMenu popup = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popupmenu_jk, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(position,id));
        popup.show();
    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener{

        private int position;
        private int id;
        public MyMenuItemClickListener(int position, int id){
            this.position = position;
            this.id = id;
        }
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.MenuJKTugas:
                    return true;
                case R.id.MenuJKPengganti:
                    Toast.makeText(mContex, "ID NYA :"+id, Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.MenuJKUbah:
                    return true;
                case R.id.MenuJLHapus:
                    return true;
            }
            return false;
        }
    }

}
