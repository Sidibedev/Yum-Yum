package com.example.mouhamedalysidibe.restaurant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by mouhamed aly sidibe on 08/06/2017.
 */
public class Panier extends AppCompatActivity {

    Model m1 = new Model(this , "DB", null , 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panier);
        TextView panierVide = (TextView)findViewById(R.id.paniervide);
        Button commande = (Button) findViewById(R.id.commande);

        if(m1.PanierVide()){
            panierVide.setText(" Votre panier est vide , Ajoutez des elements dans votre panier");
            commande.setVisibility(View.INVISIBLE);

        }


        commande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AlertDialog b = new AlertDialog.Builder(Panier.this).create();
                b.setTitle("YUM_YUM");
                b.setMessage("Votre Commande est bien prise en compte !");
                b.show();
                m1.deleteAllPlatDansPanier();

                // puis on envoi la commande !
//
//
                 finish();

            }
        });

        ListView listepanier = (ListView)findViewById(R.id.listpanier);
        CustomAdapterpanier customAdapterpanier = new CustomAdapterpanier();
        listepanier.setAdapter(customAdapterpanier);





    }


    public class CustomAdapterpanier extends BaseAdapter {
        public  Long id ;





        @Override
        public int getCount() {
            return m1.getAllPlatDansPanier().size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {






            view = getLayoutInflater().inflate(R.layout.custompanier,null);

            TextView nom = (TextView)view.findViewById(R.id.nomplatpanier);
            TextView descrip =(TextView)view.findViewById(R.id.descplatpanier);
            TextView prix = (TextView)view.findViewById(R.id.prixplatpanier);


            nom.setText(m1.getAllPlatDansPanier().get(i).getNom());
            descrip.setText(m1.getAllPlatDansPanier().get(i).getDescription());
            prix.setText(+m1.getAllPlatDansPanier().get(i).getPrix()+ "FCFA");
            return view;
        }
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
            Intent i = new Intent(Panier.this , Note.class);
            startActivity(i);

        }else if(item.getItemId() == R.id.panier){

            Intent panier = new Intent(Panier.this , Panier.class);
            startActivity(panier);


        }


        return super.onOptionsItemSelected(item);
    }


}
