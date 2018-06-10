package com.example.deivi.boletos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import dao.UsuarioDAO;
import util.Mensagem;

public class LoginActivity extends Activity {
    private EditText edtUsuario, edtSenha;
    private UsuarioDAO helper;
    private CheckBox ckbConectado;

    private static final String MANTER_CONECTADO = "manter_conectado";
    private static final String PREFERENCE_NAME= "LoginActivityPreferences";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario =  (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        ckbConectado = (CheckBox) findViewById(R.id.login_ckbConectado);

        helper = new UsuarioDAO(this);
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        boolean conectado = preferences.getBoolean(MANTER_CONECTADO, false);

        if (conectado){
            chamarMainActivity();
        }
    }

    public void logar(View view){
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        boolean validacao =true;
        if(usuario == null || usuario.equals("")) {
            validacao = false;
            edtUsuario.setError(getString(R.string.login_valUsuario));
        }

        if (senha == null || senha.equals("")) {
            validacao = false;
            edtSenha.setError(getText(R.string.login_valSenha));
        }

        if (validacao){
            //fazer login
            if (helper.logar(usuario,senha)){
                if (ckbConectado.isChecked()){
                    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(MANTER_CONECTADO, true);
                    editor.commit();
                }
                chamarMainActivity();
            }else{
                //mensagem de erro
                Mensagem.msg(this ,getString(R.string.msg_login_incorreto));
            }

        }
    }

    private void chamarMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    };
}
