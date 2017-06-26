package com.example.josesp.gameofnoughtsandcrosses;

public class Partida {

    private int dificultad;
    private int jugador;

    public Partida(int dificultad){
        this.dificultad = dificultad;
        this.jugador = 1;
    }

    public int getJugador() {
        return jugador;
    }
}
