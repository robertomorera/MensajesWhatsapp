package com.roberto.mensajeswhatsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Usr on 14/03/2017.
 */

public class FragmentEnvioMensajes extends Fragment {

    private MainActivity mainActivity;

    public FragmentEnvioMensajes(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_envio_mensajes,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Recuperamos el floating button.
        FloatingActionButton fabEnviar=(FloatingActionButton)getView().findViewById(R.id.fabEnviar);
        //Creamos el listener del mensaje.
        fabEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperamos el texto escrito en el EditView.
                EditText edtMensaje=(EditText)getView().findViewById(R.id.editTextMensajes);
                String mensaje=edtMensaje.getText().toString();
                //Enviamos el mensaje.
                mainActivity.enviarMensaje(mensaje);
            }
        });


    }
}
