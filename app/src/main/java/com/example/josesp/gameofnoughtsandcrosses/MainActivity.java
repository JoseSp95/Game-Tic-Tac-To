package com.example.josesp.gameofnoughtsandcrosses;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private int[] casillas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        casillas = new int[9];
        casillas[0] = R.id.a1;
        casillas[1] = R.id.a2;
        casillas[2] = R.id.a3;
        casillas[3] = R.id.b1;
        casillas[4] = R.id.b2;
        casillas[5] = R.id.b3;
        casillas[6] = R.id.c1;
        casillas[7] = R.id.c2;
        casillas[8] = R.id.c3;
    }

    public void aJugar(View view){
        ImageView image;
        int numberOfJugadores;
        int dificultad = 0;

        for(int casilla : casillas){
            image = (ImageView)(findViewById(casilla));
            image.setImageResource(R.drawable.casilla);
        }

        if(view.getId() == R.id.unJugador){
            numberOfJugadores = 1;
        }else{
            numberOfJugadores = 2;
        }

        int id = ((RadioGroup)(findViewById(R.id.configNivel))).getCheckedRadioButtonId();

        if(id == R.id.facil){
            dificultad = 0;
        }
        else if(id == R.id.normal){
            dificultad = 1;
        }
        else if(id == R.id.imposible){
            dificultad = 3;
        }

        ((Button)(findViewById(R.id.unJugador))).setEnabled(false);
        ((Button)(findViewById(R.id.DosJugadoes))).setEnabled(false);
        ((RadioGroup)(findViewById(R.id.configNivel))).setEnabled(false);
        ((RadioButton)(findViewById(R.id.facil))).setEnabled(false);
        ((RadioButton)(findViewById(R.id.normal))).setEnabled(false);
        ((RadioButton)(findViewById(R.id.imposible))).setEnabled(false);

        Partida partida = new Partida(dificultad);

    }


}
