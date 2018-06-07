package com.example.deivi.boletos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onTelaCadastrar(View view){
        Intent intent = new Intent(this,CadastrarBoleto.class);
        startActivity(intent);
    }


    public void onTelaExcluir(View view){

    }

    public void onTelaCalendario(View view){

    }

}
