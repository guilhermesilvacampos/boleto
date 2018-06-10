package com.example.deivi.boletos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import adapter.UsuarioAdapter;
import dao.UsuarioDAO;
import model.Usuario;
import util.Mensagem;

public class Usuarios extends Activity implements
        AdapterView.OnItemClickListener, DialogInterface.OnClickListener{

    private ListView lista;
    private List<Usuario> usuarioList;
    private UsuarioAdapter usuarioAdapter;
    private UsuarioDAO usuarioDAO;

    private int idposicao;

    private AlertDialog alertDialog, alertConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        alertDialog      = Mensagem.criarAlertDialog(this);
        alertConfirmacao = Mensagem.criarDialogConfirmacao(this);

        usuarioDAO     = new UsuarioDAO(this);
        usuarioList    = usuarioDAO.listUsuarios();
        usuarioAdapter = new UsuarioAdapter(this, usuarioList);

        lista = (ListView) findViewById(R.id.lv_usuarios);
        lista.setAdapter(usuarioAdapter);

        lista.setOnItemClickListener(this);
    }





    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = usuarioList.get(idposicao).get_id();

        switch (which){
            case 0:
                Intent intent = new Intent(this, CadUsuarioActivity.class);
                intent.putExtra("USUARIO_ID", id);
                startActivity(intent);
                break;
            case 1:
                alertConfirmacao.show();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                usuarioList.remove(idposicao);
                usuarioDAO.removerUsuario(id);
                lista.invalidateViews();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                alertConfirmacao.dismiss();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idposicao = position;
        alertDialog.show();
    }
}

