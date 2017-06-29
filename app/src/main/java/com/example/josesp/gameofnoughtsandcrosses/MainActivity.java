package com.example.josesp.gameofnoughtsandcrosses;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int[] casillas;
    private static Partida partida;

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
        int numberOfJugadores;
        int dificultad = 0;
        limpiarCasillas();

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
            dificultad = 2;
        }

        deshabilitarBotones();
        partida = new Partida(dificultad);
    }

    public void toque(View view){
        if(partida == null){
            return;
        }

        int id = view.getId();
        int i;
        int casillaElegida = 0;
        int resultado;

        for(i = 0; i < casillas.length ; i++){
            if(casillas[i] == id){
                casillaElegida = i;
                break;
            }
        }

        if(!partida.comprobarCasilla(casillaElegida)){
            return;
        }
        marca(casillaElegida);
        resultado = partida.turno();
        if(resultado > 0){
            finDelJuego(resultado);
            return;
        }
        casillaElegida = partida.ia();
        while(!partida.comprobarCasilla(casillaElegida)){
            casillaElegida = partida.ia();
        }

        marca(casillaElegida);
        resultado = partida.turno();
        if(resultado > 0){
            finDelJuego(resultado);
        }
    }

    public void marca(int casillaElegida){
        ImageView imagen = (ImageView)findViewById(casillas[casillaElegida]);
        if(partida.getJugador() == 1){
            imagen.setImageResource(R.drawable.aspa);
        }else{
            imagen.setImageResource(R.drawable.circulo);
        }
    }

    public void reiniciar(View view){
        partida = null;
        habilitarBotones();
        limpiarCasillas();
    }

    public void limpiarCasillas(){
        ImageView image;
        for(int casilla : casillas){
            image = (ImageView)(findViewById(casilla));
            image.setImageResource(R.drawable.casilla);
        }
    }

    public void deshabilitarBotones(){
        findViewById(R.id.unJugador).setEnabled(false);
        findViewById(R.id.DosJugadoes).setEnabled(false);
        findViewById(R.id.configNivel).setEnabled(false);
        findViewById(R.id.facil).setEnabled(false);
        findViewById(R.id.normal).setEnabled(false);
        findViewById(R.id.imposible).setEnabled(false);
    }

    public void habilitarBotones(){
        findViewById(R.id.unJugador).setEnabled(true);
        findViewById(R.id.DosJugadoes).setEnabled(true);
        findViewById(R.id.configNivel).setEnabled(true);
        findViewById(R.id.facil).setEnabled(true);
        findViewById(R.id.normal).setEnabled(true);
        findViewById(R.id.imposible).setEnabled(true);
    }

    public void finDelJuego(int resultado){
        String mensaje;
        Toast toast;
        if(resultado == 1){
            mensaje = "Ganan las Aspas";
            toast = Toast.makeText(this,mensaje,Toast.LENGTH_LONG);
        }else if(resultado == 2){
            mensaje = "Ganan los Circulos";
            toast = Toast.makeText(this,mensaje,Toast.LENGTH_LONG);
        }else{
            mensaje = "Empate";
            toast = Toast.makeText(this,mensaje,Toast.LENGTH_LONG);
        }

        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        //limpiarCasillas();
        habilitarBotones();
        partida = null;
    }

}
