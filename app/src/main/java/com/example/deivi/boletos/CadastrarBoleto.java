package com.example.deivi.boletos;


        import android.Manifest;
        import android.app.Activity;
        import android.app.DatePickerDialog;
        import android.app.Dialog;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.database.Cursor;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.net.Uri;
        import android.provider.MediaStore;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.content.ContextCompat;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Toast;

        import java.util.Calendar;

        import dao.BoletoDAO;
        import model.Boleto;

public class CadastrarBoleto extends Activity {
    private Button data;
    private EditText nome;
    private EditText valor;
    private EditText descricao;
    private String data_calendario;

    ImageView imagem;
    Button galeria;
    private final int PERMISSAO_REQUEST = 2;
    static final int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_boleto);

        data = findViewById(R.id.btnIserirData);
        nome = findViewById(R.id.nome);
        valor = findViewById(R.id.valor);
        descricao = findViewById(R.id.descricao);
        imagem = (ImageView) findViewById(R.id.imagem);
        galeria = findViewById(R.id.selecionar);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }




        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPegaFoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentPegaFoto, 1);
            }
        });
    }


    protected Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();

        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, ano, mes,
                        dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    String dataCalendario = String.valueOf(dayOfMonth) + " /" + String.valueOf(monthOfYear + 1) + " /" + String.valueOf(year);
                     data_calendario = dataCalendario;
                    Toast.makeText(CadastrarBoleto.this,
                            "DATA = " + dataCalendario, Toast.LENGTH_SHORT)
                            .show();
                }
            };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1) {
            Uri selectedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            Bitmap reduzido = Bitmap.createScaledBitmap(thumbnail, 200, 200, true);
            imagem.setImageBitmap(reduzido);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                //  A  permissão  foi  negada.  Precisa  ver  o  que  deve  ser  desabilitado}return;}}
            }
        }


    }





    public void onInsereData(View v) {
        if (v == data)
            showDialog(DATE_DIALOG_ID);
    }


    public void onCadastrar(View view){




        String nome1 = nome.getText().toString();
        double valor1 = Double.parseDouble(valor.getText().toString());
        String descricao1 = descricao.getText().toString();
        String data1 = data_calendario;

        String v = valor.getText().toString();

        String toast = nome1 + "-" + v + "-" + descricao1+ "-"+data1;

        Toast.makeText(CadastrarBoleto.this,
                "INFO = " + toast, Toast.LENGTH_LONG)
                .show();

        Boleto b = new Boleto();
        b.setNome(nome1);
        b.setValor(valor1);
        b.setDescricao(descricao1);
        b.setDataVencimento(data1);


        BoletoDAO boletoDAO = new BoletoDAO(this);

        boletoDAO.salvarBoleto(b);





    }


}


