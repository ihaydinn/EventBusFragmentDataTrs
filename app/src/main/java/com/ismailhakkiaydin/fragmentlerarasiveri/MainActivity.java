package com.ismailhakkiaydin.fragmentlerarasiveri;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
//implements MyListener sildik
public class MainActivity extends AppCompatActivity  {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getFragmentManager();

        addFragmentA();
        addFragmentB();

    }



    private void addFragmentA() {

        FragmentA fragmentA=new FragmentA();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.containerA, fragmentA, "fragA");
        transaction.commit();

    }

    private void addFragmentB() {

        FragmentB fragmentB=new FragmentB();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.containerB, fragmentB, "fragB");
        transaction.commit();
    }

   /* @Override
    public void sayilariTopla(int sayi1, int sayi2) {

        FragmentB fragmentb= (FragmentB) manager.findFragmentByTag("fragB");
        fragmentb.sayilariTopla(sayi1, sayi2);

    }*/

    @Subscribe
    public void onDataEvent(DataEvent.SayilariAl event){

        int sayi1 = event.getSayi1();
        int sayi2 = event.getSayi2();
        int toplam = sayi1+sayi2;

        EventBus.getDefault().post(new DataEvent.SayilariTopla(toplam));

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}