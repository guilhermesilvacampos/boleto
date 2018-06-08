package com.example.deivi.boletos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExcluirBoleto extends Activity {

    private EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_boleto);
        id = findViewById(R.id.idExcluir);
    }

    public void onExcluir(View view){
        int idExcluir = Integer.parseInt(id.getText().toString());

    }



}
