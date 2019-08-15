package com.example.rafaells.reversi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Public_reversi extends AppCompatActivity {
    LinearLayout l;
    int cont = 0;
    String [] posicaoPecas = new String [65];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_reversi);
        criaTabuleiro();
    }
    public void criaTabuleiro(){
        int x = getResources().getIdentifier("meulayout","id",getPackageName());
        int y, d = 2, cont=1, z = 1;
        for (int j=1;j<=8;j++) {
                int idLayout = getResources().getIdentifier("meulayout"+j,"id",getPackageName());
                LinearLayout l = (LinearLayout) findViewById(idLayout);
            for (int i = 0; i < 8; i++) {
                    ImageView img1 = (ImageView)getLayoutInflater().inflate(R.layout.imageviewtemplate, null);
                    img1.setTag(cont);
                    img1.setLayoutParams(new LinearLayout.LayoutParams(
                            (int) getResources().getDimension(R.dimen.imagemaltura),
                            (int) getResources().getDimension(R.dimen.imagemlargura)));
                    l.addView(img1);
                    posicaoPecas[z] = img1.getTag().toString();
                    z++;
                    cont++;
                    if (img1.getTag() == 28){
                        img1.setImageResource(R.drawable.botao1);
                        img1.setTag(img1.getTag() + " B");
                        posicaoPecas[28] = img1.getTag().toString();
                    }
                    else if (img1.getTag() == 29){
                        img1.setTag(img1.getTag()+" P");
                        img1.setImageResource(R.drawable.botao2);
                        posicaoPecas[29] = img1.getTag().toString();
                    }
                    else if (img1.getTag() == 36){
                        img1.setTag(img1.getTag() + " P");
                        img1.setImageResource(R.drawable.botao2);
                        posicaoPecas[36] = img1.getTag().toString();
                    }
                    else if (img1.getTag() == 37){
                        img1.setTag(img1.getTag()+" B");
                        img1.setImageResource(R.drawable.botao1);
                        posicaoPecas[37] = img1.getTag().toString();
                    }
                }
        }


    }
    public void movimentarPecas (View v){
        ImageView imagem = (ImageView) v;
        String [] x;
        String var[] = imagem.getTag().toString().split(" ");
        ImageView image2;

        if(var[var.length-1].equals("P") || var[var.length-1].equals("B")){
            //nada
            Toast.makeText(this,var[var.length-1], Toast.LENGTH_SHORT).show();
        }

        else if(cont == 1) {
            imagem.setImageResource(R.drawable.botao1);
            imagem.setTag(imagem.getTag() + " B");
            x = imagem.getTag().toString().split(" ");
            posicaoPecas[Integer.parseInt(x[0])] = imagem.getTag().toString();
            cont = 0;
        }
        else if(cont == 0){
            imagem.setImageResource(R.drawable.botao2);
            imagem.setTag(imagem.getTag() + " P");
            x = imagem.getTag().toString().split(" ");
            posicaoPecas[Integer.parseInt(x[0])] = imagem.getTag().toString();
            cont = 1;
        }
        x = imagem.getTag().toString().split(" ");
        Toast.makeText(this, String.valueOf("TAG= "+ v.getTag()+" Vetor = "+ posicaoPecas[Integer.parseInt(x[0])]), Toast.LENGTH_LONG).show();
    }


}
