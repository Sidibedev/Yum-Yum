package com.example.mouhamedalysidibe.restaurant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by mouhamed aly sidibe on 04/06/2017.
 */
public class boissonActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boissons);
        Intent i = getIntent();
        String nomdrink = i.getStringExtra("nomdrink");
        String desc = i.getStringExtra("descriptiondrink");


        TextView nomdrinkmenu = (TextView) findViewById(R.id.nomdrink);
        nomdrinkmenu.setText("Notre Menu : " + nomdrink);
        TextView descdrink = (TextView) findViewById(R.id.descdrink);
        descdrink.setText(desc);

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


        }
        return super.onOptionsItemSelected(item);
    }
}