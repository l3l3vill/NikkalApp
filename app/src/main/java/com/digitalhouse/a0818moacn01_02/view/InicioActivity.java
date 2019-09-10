package com.digitalhouse.a0818moacn01_02.view;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalhouse.a0818moacn01_02.R;

public class InicioActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        Animation animationRotate;
        Animation animationBlink;

        animationRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        animationBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

        ImageView imageViewLogo = findViewById(R.id.nikkal);
        TextView textViewLetra = findViewById(R.id.nikkalLetra);

        final Button button = findViewById(R.id.botonoffline);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.cordinator);

        //Animacion de Logo y Letra
        imageViewLogo.setAnimation(animationRotate);
        textViewLetra.setAnimation(animationBlink);

        final Intent intent = new Intent(InicioActivity.this, MainActivity.class);

        if (verificarConexion()) {
            int MILISEGUNDOS_ESPERA = 4000;
            esperarYCerrar(MILISEGUNDOS_ESPERA);
        } else {
            button.setVisibility(View.VISIBLE);
            Snackbar.make(coordinatorLayout, "Verificar la conexion a internet", Snackbar.LENGTH_LONG).show();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });

        }
    }

    private boolean verificarConexion() {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo actNetInfo = connectivityManager.getActiveNetworkInfo();

        return (actNetInfo != null && actNetInfo.isConnected());
    }

    public void esperarYCerrar(Integer milisegundos) {
        final Intent intent = new Intent(InicioActivity.this, MainActivity.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(intent);

            }
        }, milisegundos);
    }
}
