package com.example.deivi.boletos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
// Feito por Miguel 08/06/18
public class ListarBoletos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boleto);
    }


    public void onClickBoletosAPagar(View view){
        Intent intent = new Intent(this,ListarBoletosAPagar.class);
        startActivity(intent);
    }


    public void onClickBoletosPagos(View view){
        //Intent inte = new Intent(this,ExcluirBoleto.class);
        //startActivity(inte);
    }

    public void onClickBoletosVencidos(View view){
        //Intent intent1 = new Intent (this, ListarBoletos.class );
        //startActivity(intent1);
    }


}
