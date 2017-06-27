package com.example.josesp.gameofnoughtsandcrosses;

import java.util.Random;

public class Partida {

    private int dificultad;
    private int jugador = 1;
    private int [] casillas;
    private int [][] combinaciones = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public Partida(int dificultad){
        this.dificultad = dificultad;
        this.casillas = new int[9];
        for (int i = 0; i < 9 ; i++){
            casillas[i] = 0;
        }
    }

    public int getJugador() {
        return jugador;
    }

    public int ia(){
        int casilla;
        casilla = new Random().nextInt(9);
        return casilla;
    }

    public int turno(){
        int i;
        boolean empate = true;
        for(i = 0; i < combinaciones.length; i++){
            for(int pos : combinaciones[i]){
                if(casillas[pos] == 0){
                    empate = false;
                }
            }
        }

        if(empate){
            return 3;
        }

        jugador++;
        if(jugador > 2){
            jugador = 1;
        }
        return 0;
    }

    public boolean comprobarCasilla(int numberOfCasilla){
        if(casillas[numberOfCasilla] != 0){
            return false;
        }else{
            casillas[numberOfCasilla] = jugador;
            return true;
        }
    }

}
