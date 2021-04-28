package com.mygdx.game;

public class Time {

    static int tiempoJuego;
    int alarma;
    int frecuencia;

    Time(int f){
        frecuencia = f;
        alarma = tiempoJuego + f;
    }

    public boolean suena() {
        if(tiempoJuego == alarma){
            alarma = tiempoJuego + frecuencia;
            return true;
        }
        return false;
    }
}
