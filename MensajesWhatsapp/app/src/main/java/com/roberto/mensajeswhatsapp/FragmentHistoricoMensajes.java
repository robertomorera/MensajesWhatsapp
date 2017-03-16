package com.roberto.mensajeswhatsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Usr on 14/03/2017.
 */

public class FragmentHistoricoMensajes extends Fragment {

    private MainActivity mainActivity;

    public FragmentHistoricoMensajes(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listado,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView listadoMensaje=(ListView)getView().findViewById(R.id.listado_mensajes);
        //Creamos el adapter.
        ListadoMensajesAdapter listadoMensajesAdapter= new ListadoMensajesAdapter(mainActivity);
        //Asociamos el adapter al ListView.
        listadoMensaje.setAdapter(listadoMensajesAdapter);

    }
}
