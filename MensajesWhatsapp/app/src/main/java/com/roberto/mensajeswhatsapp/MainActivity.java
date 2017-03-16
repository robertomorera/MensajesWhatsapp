package com.roberto.mensajeswhatsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //ViewPager que permite la animación entre los dos tabs de la app.
    private ViewPager viewPager;
    //Suministra las vistas al ViewPager.
    private PageAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Recuperamos la referencia del ViewPager.
        viewPager=(ViewPager)findViewById(R.id.miViewPager);
        //Creamos el pagerAdapter.
        pageAdapter=new PageAdapter(getSupportFragmentManager(),this);
        //Asociamos el pageAdapter al viewPager.
        viewPager.setAdapter(pageAdapter);
        //Recuperamos la referencia del TabLayout.
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        //Creamos los tabs.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //Sincronizamos con el ViewPager.
        tabLayout.setupWithViewPager(viewPager);
        //Ponemos titulos a los tabs.
        tabLayout.getTabAt(0).setText(R.string.titulo_tab1);
        tabLayout.getTabAt(1).setText(R.string.titulo_tab2);
        //Ponems los icnos a los tabs.
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_mail_outline_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_poll_black_24dp);

    }

    public void enviarMensaje(String mensaje){

        //Guardamos en un SharedPreferences el mensaje enviado al WhatsApp.
        SharedPreferences sp=getSharedPreferences("historicoMensajes", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        int contador=sp.getInt("numMensajes",0);
        //Incrementamos el valor del número de mensajes enviados.
        contador++;
        //Guardamos el contador en el sharedPreferences.
        editor.putInt("numMensajes",contador);
        //Guardamos el mensaje.
        editor.putString("mensaje"+contador,mensaje);
        editor.commit();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,mensaje);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);


    }

    @Override
    public void onBackPressed() {

        if(viewPager.getCurrentItem()==0){
            super.onBackPressed(); //finish
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);

        }

    }

}
