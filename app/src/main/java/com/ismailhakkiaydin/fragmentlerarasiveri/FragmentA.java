package com.ismailhakkiaydin.fragmentlerarasiveri;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;


public class FragmentA extends Fragment {

    EditText sayi1;
    EditText sayi2;
    Button sayilariGOnder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v= inflater.inflate(R.layout.fragment_a, container, false);

        sayi1= (EditText) v.findViewById(R.id.etSayi1);
        sayi2= (EditText) v.findViewById(R.id.etSayi2);

        sayilariGOnder= (Button) v.findViewById(R.id.btnActivityeSayilariGonder);
        sayilariGOnder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDatatoActivity();
            }
        });

        return v;
    }

    private void sendDatatoActivity() {

        int s1=Integer.parseInt(sayi1.getText().toString()) ;
        int s2=Integer.valueOf(sayi2.getText().toString()) ;

        /*MyListener mylistener = (MyListener) getActivity();
        mylistener.sayilariTopla(s1, s2);*/


       // EventBus.getDefault().post(new DataEvent(s1,s2));
        EventBus.getDefault().post(new DataEvent.SayilariAl(s1,s2));

    }


}