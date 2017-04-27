package me.citrafa.asistenkuliahku;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class fragment_dashboard extends Fragment {

    TextView txt2,txt1;
    Context mContext;
    DateForAlarmService DFA;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content_dashboard, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DFA = new DateForAlarmService();
        txt1 = (TextView)view.findViewById(R.id.TimeRemainingDahsboard);
        txt2 = (TextView)view.findViewById(R.id.namaKegiatan);
        //DFA.getDateEarly(mContext,txt1,txt2);



    }



    //        new CountDownTimer(30000,1000){
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//                txt1.setText("Second Remaining : "+millisUntilFinished);
//            }
//
//            @Override
//            public void onFinish() {
//                txt1.setText("done!");
//            }
//        }.start();
}
