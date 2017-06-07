package com.example.mouhamedalysidibe.restaurant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mouhamed aly sidibe on 07/06/2017.
 */
public class DetailPlat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detailplat);
        ImageView img = (ImageView) findViewById(R.id.imageplatdetail);
        TextView nomplat = (TextView) findViewById(R.id.nomplatdetail);
        TextView descplat = (TextView) findViewById( R.id.descplatdetail);

        Intent i = getIntent();

        String nomp = i.getStringExtra("nom");
        String descp = i.getStringExtra("description");
        int image = i.getIntExtra("image" , 0);

        img.setImageResource(image);
        nomplat.setText(nomp);
        descplat.setText(descp);



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

        }


        return super.onOptionsItemSelected(item);
    }

}
