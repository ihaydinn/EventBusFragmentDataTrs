package com.ismailhakkiaydin.fragmentlerarasiveri;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FragmentB extends Fragment {

    TextView sonuc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_b, container, false);
        sonuc= (TextView) v.findViewById(R.id.tvSonucFragment);
        return v;
    }


    /*public void sayilariTopla(int sayi1, int sayi2) {

        int toplam=sayi1+sayi2;
        sonuc.setText("TOPLAM = "+ toplam);

    }*/

    @Subscribe
    public void onToplamEvent(DataEvent.SayilariTopla event){
        int toplam = event.getToplam();
        sonuc.setText("Sonuc : "+ toplam);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }
}