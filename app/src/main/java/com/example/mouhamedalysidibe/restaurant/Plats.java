package com.example.mouhamedalysidibe.restaurant;

import android.app.Activity;
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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by mouhamed aly sidibe on 03/06/2017.
 */
public class Plats extends AppCompatActivity{




    Model m1 = new Model(this , "DB", null , 5);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plats);
         Intent i = getIntent();

         String nomfood = i.getStringExtra("nom");
         String descriptionfood = i.getStringExtra("description");
         int imagefood = i.getIntExtra("image",0);
        final Long id_categorie =i.getLongExtra("id_categorie" , 0);








        TextView nomMenu = (TextView)findViewById(R.id.nom);
        nomMenu.setText("Notre Menu : "+nomfood);


        TextView descMenu = (TextView)findViewById(R.id.desc);
        descMenu.setText(descriptionfood);
        ImageView image = (ImageView)findViewById(R.id.imageView);
        //ImageView img = (ImageView)findViewById(R.id.imageView);
        image.setImageResource(imagefood);

        ListView listView = (ListView)findViewById(R.id.listView_plat);


        CustomAdapterFood customAdapterFood = new CustomAdapterFood(id_categorie);
        listView.setAdapter(customAdapterFood);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Plats.this , DetailPlat.class);
                intent.putExtra("nom", m1.getAllPlat(id_categorie).get(i).getNom());
                intent.putExtra("description", m1.getAllPlat(id_categorie).get(i).getDescription());
                intent.putExtra("image" ,m1.getAllPlat(id_categorie).get(i).getImage());
                intent.putExtra("prix" , m1.getAllPlat(id_categorie).get(i).getPrix());
                startActivity(intent);



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
        Intent i = new Intent(Plats.this , Note.class);
        startActivity(i);

       }else if(item.getItemId() == R.id.panier){

        Intent panier = new Intent(Plats.this , Panier.class);
        startActivity(panier);


    }

    return super.onOptionsItemSelected(item);
    }


    public class CustomAdapterFood extends BaseAdapter {
        public  Long id ;

        public CustomAdapterFood(Long id){
            this.id = id;

        }




        @Override
        public int getCount() {
            return m1.getAllPlat(id).size();
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

            Log.i("Categorie_plat" ,"id : "+id);




            view = getLayoutInflater().inflate(R.layout.customplat,null);
            ImageView imageView = (ImageView)view.findViewById(R.id.image_plat);
            TextView nom = (TextView)view.findViewById(R.id.nom_plat);
            TextView descrip =(TextView)view.findViewById(R.id.description_plat);
            imageView.setImageResource(m1.getAllPlat(id).get(i).getImage());

            nom.setText(m1.getAllPlat(id).get(i).getNom());
            descrip.setText(m1.getAllPlat(id).get(i).getDescription());

            return view;
        }
    }





}
