package com.example.mouhamedalysidibe.restaurant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mouhamed aly sidibe on 07/06/2017.
 */
public class DetailPlat extends AppCompatActivity {

    Model m1 = new Model(this , "DB", null , 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detailplat);
        ImageView img = (ImageView) findViewById(R.id.imageplatdetail);
        TextView nomplat = (TextView) findViewById(R.id.nomplatdetail);
        TextView descplat = (TextView) findViewById( R.id.descplatdetail);
        TextView prix_plat = (TextView) findViewById(R.id.prix);
        Button ajouterpanier = (Button)findViewById(R.id.ajouterpanier) ;
        Intent i = getIntent();

        final String nomp = i.getStringExtra("nom");
        final String descp = i.getStringExtra("description");
        final int image = i.getIntExtra("image" , 0);
        final Double prix = i.getDoubleExtra("prix",0.0);

        img.setImageResource(image);
        nomplat.setText(nomp);
        descplat.setText(descp);
        prix_plat.setText(+prix+ "FCFA");


        ajouterpanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Monplat platpanier = new Monplat(nomp ,descp , image , prix);
                m1.saveDansPanier(platpanier);
                AlertDialog a = new AlertDialog.Builder(DetailPlat.this).create();
                a.setTitle("YUM_YUM");
                a.setMessage("Votre "+nomp +" a bien ete ajouté au panier");
                a.show();



            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.appel){
            final AlertDialog retry = new AlertDialog.Builder( this ).create();
            retry.setTitle(R.string.app_name);
            retry.setMessage("MERCI DE PATIENTER QUELQUES INSTANTS , NOUS VENONS BIENTOT PRENDRE VOTRE COMMANDE");
            retry.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",new  DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    retry.cancel();
                }
            });



            retry.show();


        }else if(item.getItemId() == R.id.note){
            Intent i = new Intent(DetailPlat.this , Note.class);
            startActivity(i);

        }else if(item.getItemId() == R.id.panier){

            Intent panier = new Intent(DetailPlat.this , Panier.class);
            startActivity(panier);


        }


        return super.onOptionsItemSelected(item);
    }

}
