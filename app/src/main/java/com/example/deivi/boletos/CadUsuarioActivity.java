package com.example.deivi.boletos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import dao.UsuarioDAO;
import model.Usuario;
import util.Mensagem;

public class CadUsuarioActivity extends Activity {

    private EditText edtNome, edtLogin, edtSenha;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private  int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_usuario);

        usuarioDAO = new UsuarioDAO(this);

        edtNome = (EditText) findViewById(R.id.usuario_edtNome);
        edtLogin = (EditText) findViewById(R.id.usuario_edtLogin);
        edtSenha = (EditText) findViewById(R.id.usuario_edtSenha);

        idUsuario = getIntent().getIntExtra("USUARIO_ID", 0);
        if(idUsuario > 0){
            Usuario model = usuarioDAO.buscarUsuario(idUsuario);
            edtNome.setText(model.getNome());
            edtLogin.setText(model.getLogin());
            edtSenha.setText(model.getSenha());
            setTitle("Atualizar usuário");
        }
    }

    @Override
    protected void onDestroy() {
        usuarioDAO.fecharConexao();
        super.onDestroy();
    }
    private void cadastrar(){
        boolean validacao = true;
        String nome = edtNome.getText().toString();
        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();

        if(nome == null || nome.equals("")){
            validacao = false;
            edtNome.setError(getString(R.string.campo_Obrigatorio));
        }

        if(login == null || login.equals("")){
            validacao = false;
            edtLogin.setError(getString(R.string.campo_Obrigatorio));
        }
        if(senha == null || senha.equals("")){
            validacao = false;
            edtSenha.setError(getString(R.string.campo_Obrigatorio));
        }

        if(validacao){
            usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(senha);

            //se for preciso atualizar
            if(idUsuario>0){
                usuario.set_id(idUsuario);
            }

            long resultado = usuarioDAO.salvarUsuario(usuario);
            if (resultado!=-1){
                if (idUsuario>0){
                    Mensagem.msg(this, getString(R.string.mensagem_atualizado));

                }else {
                    Mensagem.msg(this, getString(R.string.mensagem_cadastrado));
                }
                finish();
                startActivity(new Intent(this, MainActivity.class));
            }else{
                Mensagem.msg(this, getString(R.string.mensagem_erro));
            }

        }

    }




}