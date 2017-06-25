package com.example.josesp.gameofnoughtsandcrosses;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
        for(int casilla : casillas){
            image = (ImageView)(findViewById(casilla));
            image.setImageResource(R.drawable.casilla);
        }
    }


}
