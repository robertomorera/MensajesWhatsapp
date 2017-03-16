package com.roberto.mensajeswhatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Usr on 14/03/2017.
 */

public class ListadoMensajesAdapter extends BaseAdapter {

    private Context context;

    public ListadoMensajesAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        //Guardamos en un SharedPreferences el mensaje enviado al WhatsApp.
        SharedPreferences sp=context.getSharedPreferences("historicoMensajes", Context.MODE_PRIVATE);
        //Recuperamos el numero de mensajes enviados.
        int numMensajes=sp.getInt("numMensajes",0);
        return numMensajes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View filaInflada=null;
        Log.d(getClass().getCanonicalName(),"Entrada al método getView() se añade el elemento en la posición "+position);
        if(convertView==null){
            Activity activity=(Activity)context;
            LayoutInflater layoutInflater=activity.getLayoutInflater();
            Log.d(getClass().getCanonicalName(),"Creamos la vista de nuevo");
            filaInflada=layoutInflater.inflate(R.layout.fila,parent,false);
        }else{
            Log.d(getClass().getCanonicalName(),"Reciclamos la vista");
            filaInflada=convertView;
        }
        //Obtenemos el TextView de la fila inflada.
        TextView tvMensaje=(TextView)filaInflada.findViewById(R.id.mensaje_recuperado);
        SharedPreferences sp=context.getSharedPreferences("historicoMensajes", Context.MODE_PRIVATE);
        //Recuperamos el numero de mensaje enviado.
        int contador=position+1;
        String mensajeRecuperado=sp.getString("mensaje"+contador,"");
        Log.d(getClass().getCanonicalName(),"Se ha recuperado del SP el mensaje: "+mensajeRecuperado);
        //Seteamos el mensaje recuperado.
        tvMensaje.setText(mensajeRecuperado);

        return filaInflada;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
