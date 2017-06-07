package com.example.mouhamedalysidibe.restaurant;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Currency;
import java.util.List;

/**
 * Created by mouhamed aly sidibe on 03/06/2017.
 */
public class Menus extends AppCompatActivity {



      Model m1 = new Model(this , "DB", null , 4); // i instaciate my model





    Categorie pizza = new Categorie("Pizza" , R.drawable.pizza , "Les meilleurs pizza de Dakar ");

    Categorie baguettes = new Categorie("Baguettes" , R.drawable.baguette , "Explosion de saveurs a prix mini");
    Categorie pastas = new Categorie("Pastas" , R.drawable.pastas , "Laissez vous tenter ");
    Categorie donuts = new Categorie("Donuts" , R.drawable.donuts , "Al dente et tellement genereuses");
    Categorie snacks = new Categorie("Snacks" , R.drawable.snacks , "Un delice a chaque bouchée");
    Categorie Boisson_gaz = new Categorie("Boissons Gazeuses" , R.drawable.gazeuse , "Pensez a vous desalterer");
    Categorie Alcool = new Categorie("Alcool" , R.drawable.alcool , "De la bonne qualite");
    Categorie Cocktail = new Categorie("Cocktail" , R.drawable.cocktail , "Decouvrez nos cocktails");
    Categorie Boisson_chaude = new Categorie("Boissons chaudes" , R.drawable.chaude , "Un bon cafe ne fait jamais de mal");


    // Plats pizza
    Monplat  t_rex = new Monplat("T-Rex" , "sauce tomate, pepperoni, boulettes de bœuf, jambon, double mozzarella" , R.drawable.trex);
    Monplat supreme_pizza = new Monplat("Suprem","sauce tomate, mozzarella, boulettes de bœuf, jambon, champignons, poivrons verts, oignons, saucisse piquante" , R.drawable.supreme);
    Monplat  Samouraï = new Monplat("Samouraï" , "sauce tomate, mozzarella, poulet rôti, merguez, oignons, sauce samouraï" , R.drawable.samourai);
    Monplat   Montagnarde = new Monplat(" Montagnarde" , "crème fraîche, mozzarella, jambon, oignons, reblochon, cornichons" , R.drawable.montagnarde);
    Monplat  Chickenita = new Monplat("Chickenita" , "sauce tomate, emmental, mozzarella, poulet rôti, tomates, saucisse piquante" , R.drawable.chickenita);


    // Plats Baguettes
    Monplat  Divinepepper = new Monplat("Divine pepper" , "sauce tomate, mozzarella, boulettes de bœuf, tomates fraîches, herbe de Provence, sauce poivre" , R.drawable.divinepepper);
    Monplat  Americain = new Monplat("Americain" , "Boulettes de bœuf, tomates, mozzarella, mayonnaise, frites, ketchup" , R.drawable.lamericain);
    Monplat  YumBurger = new Monplat("YumBurger" , "sauce burger, boulettes de bœuf, tomates, oignons, cornichons, emmental" , R.drawable.yumburger);
    Monplat   Reggae = new Monplat(" Reggae" , "sauce tomate, mozzarella, poulet rôti, ananas, poivrons verts, oignons, sauce salsa" , R.drawable.reggae);
    Monplat  Breakfast = new Monplat("Breakfast" , "crème fraîche, emmental, jambon, tomates, œufs brouillés" , R.drawable.breakfast);
    Monplat  ChickenLover = new Monplat("Chicken Lover" , "sauce barbecue, mozzarella, poulet rôti, poivrons verts, oignons" , R.drawable.chickenlover);
    Monplat  MeatLover = new Monplat("Meat Lover" , "sauce tomate, mozzarella, poulet rôti, boulettes de bœuf, merguez, oignons, tomates" , R.drawable.meatlover);




    // Plats Pastas

    Monplat  Pennepoulet = new Monplat("Penne poulet" , "penne, mozzarella, poulet, moutarde, crème fraîche" , R.drawable.pennepoulet);
    Monplat  Pennebolognaise = new Monplat("Penne bolognaise" , "penne, sauce tomate, boulettes de bœuf, mozzarella, sauce basilic" , R.drawable.pennepoulet);
    Monplat  PenneCarbonara = new Monplat("Penne Carbonara" , "penne, crème fraîche, jambon, emmental" , R.drawable.pennepoulet);
    Monplat  Penne3fromages = new Monplat("Penne 3 fromages" , "penne, crème fraîche, mozzarella, chèvre, reblochon" , R.drawable.pennepoulet);


    // Plats Donuts

    Monplat  Donutnature = new Monplat("Donut nature" , "" , R.drawable.donutnature);
    Monplat  Donutnappe = new Monplat("Donut nappé" , "" , R.drawable.donutnappe);
    Monplat  DonutCandy = new Monplat("Donut  Candy" , "" , R.drawable.donutcandy);
    Monplat  DonutFourre = new Monplat("Donut Fourré" , "" , R.drawable.donutfourre);




    // Plats Snacks

    Monplat  WingsNatures = new Monplat("Wings Natures" , "6 pièces - sans sauce" , R.drawable.wingsnatures);
    Monplat  WingsHot = new Monplat("Wings Hot" , "6 pièces - sauce pimentée" , R.drawable.wingsnatures);
    Monplat   WingsBarbecue = new Monplat(" Wings Barbecue" , "6 pièces - sauce barbecue" , R.drawable.wingsnatures);
    Monplat  WingsSweetChili = new Monplat("Wings Sweet Chili" , "6 pièces - sauce Sweet Chili" , R.drawable.wingsnatures);
    Monplat  WingsMiel = new Monplat("Wings Miel" , "Wings Miel" , R.drawable.wingsnatures);
    Monplat  Fritesaufour = new Monplat(" Frites au four" , "200 grammes" , R.drawable.fritesaufour);
    Monplat  ChickenNuggets = new Monplat("Chicken Nuggets" , "8 pieces" , R.drawable.chickennuggets);
    Monplat  CheesyBread = new Monplat(" Cheesy Bread" , "8 batonnets" , R.drawable.cheesybread);




    // Plats Boissons gaz
    Monplat  CocaCola = new Monplat("Coca-Cola" , "Canette 33cl" , R.drawable.coca);
    Monplat  Sprite = new Monplat("Sprite" , "Canette 33cl" , R.drawable.sprite);
    Monplat  Fanta = new Monplat("Fanta" , "Canette 33cl" , R.drawable.fanta);
    Monplat  Vimto = new Monplat("Vimto" , "Canette 33cl" , R.drawable.vimto);
    Monplat  CocaZero = new Monplat("Coca Zero" , "Canette 33cl" , R.drawable.donutfourre);
    Monplat Schweppescitron = new Monplat("Schweppes citron" ,"Canette 33cl",R.drawable.schweppescitron);
    Monplat  Schweppestonic = new Monplat("Schweppes tonic" ,"Canette 33cl", R.drawable.schweppestonic );
    Monplat Schweppesagrum = new Monplat("Schweppes agrum'" ,"Canette 33cl", R.drawable.schweppesagrume );
    Monplat Monster = new Monplat("Monster" ,"Canette 50cl", R.drawable.monster );









    //Plats Alcool
    Monplat vin = new Monplat("Vins" , "" ,R.drawable.vin);
    Monplat Biere = new Monplat("Bieres" , "" ,R.drawable.biere );





    // Plats Cocktail

    Monplat Mojito = new Monplat("Mojito" , "" ,R.drawable.mojito );
    Monplat ngor = new Monplat("Soleil de ngor" , "" ,R.drawable.soleilngor );
    Monplat cock1 = new Monplat("Cocktail SIDIBE" , "" ,R.drawable.cock1 );
    Monplat cock2 = new Monplat("Cocktail FONKOUE" , "" ,R.drawable.cock2 );
    Monplat cock3 = new Monplat("Cocktail DEAS" , "" ,R.drawable.cock3 );






    //Plats Boisson Chaude

    Monplat  Expressocourt = new Monplat(" Expresso court" ,"", R.drawable.expressocourt );
    Monplat  Expressolong = new Monplat(" Expresso long" ,"", R.drawable.expressocourt );
    Monplat  Cappuccino = new Monplat("Cappuccino" ,"", R.drawable.cappuccino );
    Monplat   Chocolatchaud = new Monplat(" Chocolat chaud " ,"", R.drawable.chocolatchaud );











    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menus);

        pizza.setId(1);
        baguettes.setId(2);
        pastas.setId(3);
        donuts.setId(4);
        snacks.setId(5);
        Boisson_gaz.setId(6);
        Alcool.setId(9);
        Cocktail.setId(8);
        Boisson_chaude.setId(7);








        List<String> listetable = m1.getAllTableName(); // i check here if my all table are being created but only the first table i createe yesterday is created
        Log.i("Liste" , "listeTable :"+listetable);


        m1.deleteAllPlat();
        m1.savePlat(supreme_pizza , pizza.getId());
        m1.savePlat(t_rex,pizza.getId());
        m1.savePlat(Samouraï,pizza.getId());
        m1.savePlat(Montagnarde,pizza.getId());
        m1.savePlat(Chickenita,pizza.getId());
        //
        m1.savePlat(Divinepepper , baguettes.getId());
        m1.savePlat(Americain , baguettes.getId());
        m1.savePlat(YumBurger , baguettes.getId());
        m1.savePlat(Reggae , baguettes.getId());
        m1.savePlat(Breakfast , baguettes.getId());
        m1.savePlat(ChickenLover , baguettes.getId());
        m1.savePlat(MeatLover , baguettes.getId());
        //
        m1.savePlat(Pennepoulet,pastas.getId());
        m1.savePlat(Pennebolognaise,pastas.getId());
        m1.savePlat(PenneCarbonara,pastas.getId());
        m1.savePlat(Penne3fromages,pastas.getId());
        //
        m1.savePlat(Donutnature,donuts.getId());
        m1.savePlat(Donutnappe,donuts.getId());
        m1.savePlat(DonutCandy,donuts.getId());
        m1.savePlat(DonutFourre,donuts.getId());
        //
        m1.savePlat(WingsNatures,snacks.getId());
        m1.savePlat(WingsHot,snacks.getId());
        m1.savePlat(WingsBarbecue,snacks.getId());
        m1.savePlat(WingsSweetChili,snacks.getId());
        m1.savePlat(WingsMiel,snacks.getId());
        m1.savePlat(Fritesaufour,snacks.getId());
        m1.savePlat(ChickenNuggets,snacks.getId());
        m1.savePlat(CheesyBread,snacks.getId());
        //
        m1.savePlat(CocaCola,Boisson_gaz.getId());
        m1.savePlat(Sprite,Boisson_gaz.getId());
        m1.savePlat(Fanta,Boisson_gaz.getId());
        m1.savePlat(Vimto,Boisson_gaz.getId());
        m1.savePlat(CocaZero,Boisson_gaz.getId());
        m1.savePlat(Schweppescitron,Boisson_gaz.getId());
        m1.savePlat(Schweppestonic,Boisson_gaz.getId());
        m1.savePlat(Schweppesagrum,Boisson_gaz.getId());
        m1.savePlat(Monster,Boisson_gaz.getId());
        //
        m1.savePlat(vin,Alcool.getId());
        m1.savePlat(Biere,Alcool.getId());
        //
        m1.savePlat(Mojito,Cocktail.getId());
        m1.savePlat(ngor,Cocktail.getId());
        m1.savePlat(cock1,Cocktail.getId());
        m1.savePlat(cock2,Cocktail.getId());
        m1.savePlat(cock3,Cocktail.getId());
        //
        m1.savePlat(Expressocourt,Boisson_chaude.getId());
        m1.savePlat(Expressolong,Boisson_chaude.getId());
        m1.savePlat(Cappuccino,Boisson_chaude.getId());
        m1.savePlat(Chocolatchaud,Boisson_chaude.getId());


















        //m.deleteAllCategorie();
//         m1.save(pizza);
//        m1.save(baguettes);
//        m1.save(pastas);
//       m1.save(donuts);
//       m1.save(snacks);
////
//        m1.save(Boisson_gaz);
//       m1.save(Boisson_chaude);
//       m1.save(Cocktail);
//      m1.save(Alcool);

//
        List<Categorie> cat = m1.getAllcategorie();
       Log.i("categorie" , "listeCategorie : "+cat);

       /* List<Monplat> plat = m.getAllPlat();
        Log.i("plat" , "liste : "+plat)*/;







        TextView tablefood = (TextView)findViewById(R.id.table);

        Intent intent = getIntent();


        String tabletextfood = intent.getStringExtra("table");
        tablefood.setText(""+tabletextfood);





        //Listview Food

        ListView listmenufood = (ListView)findViewById(R.id.listView_food);
        CustomAdapterFood customAdapterFood = new CustomAdapterFood();
        listmenufood.setAdapter(customAdapterFood);
        listmenufood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Menus.this , Plats.class);
                intent.putExtra("nom", m1.getAllcategorie().get(i).getNom());
                intent.putExtra("description", m1.getAllcategorie().get(i).getDescription());
                intent.putExtra("image" ,m1.getAllcategorie().get(i).getPhoto());
                intent.putExtra("id_categorie" ,m1.getAllcategorie().get(i).getId());
                Log.i("ID_CATEGORIE" , "id ="+m1.getAllcategorie().get(i).getId());
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
             Intent i = new Intent(Menus.this , Note.class);
             startActivity(i);

        }


        return super.onOptionsItemSelected(item);
    }


    // Foods

    public class CustomAdapterFood extends BaseAdapter{


        @Override
        public int getCount() {
            return m1.getAllcategorie().size();
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
            view = getLayoutInflater().inflate(R.layout.customlayout ,null);
            ImageView imageView = (ImageView)view.findViewById(R.id.img);
            TextView nom = (TextView)view.findViewById(R.id.TextView_nom);
            TextView descrip =(TextView)view.findViewById(R.id.TextView_description);
            imageView.setImageResource(m1.getAllcategorie().get(i).getPhoto());

            nom.setText(m1.getAllcategorie().get(i).getNom());
            descrip.setText(m1.getAllcategorie().get(i).getDescription());

            return view;
        }
    }



    //Drinks






}
