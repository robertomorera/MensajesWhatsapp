package com.roberto.mensajeswhatsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Usr on 14/03/2017.
 */

public class PageAdapter extends FragmentPagerAdapter
{
    /**
     * Número de tabs en la app.
     */
    public static final int NUM_TABS=2;

    private MainActivity mainActivity;

    public PageAdapter(FragmentManager fragmentManager,MainActivity mainActivity){
        super(fragmentManager);
        this.mainActivity=mainActivity;
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch(position){
            case 0: fragment=new FragmentEnvioMensajes(mainActivity);
                break;
            case 1: fragment=new FragmentHistoricoMensajes(mainActivity);
        }

        return fragment;
    }
}
