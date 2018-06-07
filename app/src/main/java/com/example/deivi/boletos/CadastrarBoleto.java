package com.example.deivi.boletos;


        import android.Manifest;
        import android.app.Activity;
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
        import android.widget.ImageView;

public class CadastrarBoleto extends Activity {

    ImageView imagem;
    Button galeria;
    private final int PERMISSAO_REQUEST = 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_boleto);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!=  PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }




        imagem = (ImageView) findViewById(R.id.imagem);
        galeria = findViewById(R.id.selecionar);

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPegaFoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentPegaFoto, 1);
            }
        });




    }


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
            Bitmap reduzido = Bitmap.createScaledBitmap(thumbnail,300,300,true);
            imagem.setImageBitmap(reduzido);
        }
    }

    @Override
    public void onRequestPermissionsResult (int requestCode,String permissions[],  int[]  grantResults)  {
        if(requestCode==  PERMISSAO_REQUEST)  {
            if(grantResults.length>  0&&  grantResults[0]  ==  PackageManager.PERMISSION_GRANTED)  {

            }  else{
                //  A  permissão  foi  negada.  Precisa  ver  o  que  deve  ser  desabilitado}return;}}
            }
        }




    }
}