package com.example.mouhamedalysidibe.restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mouhamed aly sidibe on 03/06/2017.
 */
public class Model extends SQLiteOpenHelper {


    public Model(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Plat(C_ID_Plat INTEGER PRIMARY KEY AUTOINCREMENT , C_ID_Categorie INTEGER , C_Nom_Plat TEXT , C_Photo_Plat INTEGER , C_Description_Plat TEXT) ");
        sqLiteDatabase.execSQL("CREATE TABLE Categorie(C_ID INTEGER PRIMARY KEY AUTOINCREMENT , C_Nom TEXT , C_Photo TEXT , C_Description TEXT) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Categorie");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Plat");

        // recreate the tables
        onCreate(sqLiteDatabase);

    }

    public void save(Categorie C) {
        ContentValues v = new ContentValues();
        v.put("C_Nom", C.getNom());
        v.put("C_Photo", C.getPhoto());
        v.put("C_Description", C.getDescription());
        long id = C.getId();
        if (id == 0) {
            id = this.getWritableDatabase().insert("Categorie", null, v);
            C.setId(id);

        } else {

            this.getWritableDatabase().update("Categorie", v, "C_ID = ?", new String[]{String.valueOf(id)});

        }


    }


    public void savePlat(Monplat p , long id_Categorie){

        ContentValues v1 = new ContentValues();
        v1.put("C_Nom_Plat", p.getNom());
        v1.put("C_Photo_Plat", p.getImage());
        v1.put("C_Description_Plat", p.getDescription());
        v1.put("C_ID_Categorie" , id_Categorie);
        long id = p.getId();
        if (id == 0) {
            id = this.getWritableDatabase().insert("Plat", null, v1);
            p.setId(id);

        } else {

            this.getWritableDatabase().update("Plat", v1, "C_ID_Plat = ?", new String[]{String.valueOf(id)});

        }



    }




    public List<String> getAllTableName() {
        List<String> resultat = new ArrayList<String>();
        String selectQeury = "select name from sqlite_master where type= 'table' ";

        Cursor c = this.getReadableDatabase().rawQuery(selectQeury, null);
        if (c.moveToFirst()) {
            do {
                //
                String n = c.getString(c.getColumnIndex("name"));

                resultat.add(n);
            } while (c.moveToNext());
        }
        return resultat;


    }


    public Cursor getAllCategorieAsCursor() {
        return this.getReadableDatabase().rawQuery("select * from Categorie", null);
    }

    public Cursor getAllPlatAsCursor(long id ){
        return this.getReadableDatabase().rawQuery("select * from Plat where C_ID_Categorie = "+id, null);


    }

    public List<Categorie> getAllcategorie() {
        List<Categorie> resultat = new ArrayList<Categorie>();

        Cursor c = this.getAllCategorieAsCursor();
        if (c.moveToFirst()) {
            do {
                //
                Long id = c.getLong(c.getColumnIndex("C_ID"));
                String nom = c.getString(c.getColumnIndex("C_Nom"));
                String description = c.getString(c.getColumnIndex("C_Description"));
                int photo = c.getInt(c.getColumnIndex("C_Photo"));
                Categorie cat = new Categorie(nom, photo, description);
                cat.setId(id);

                resultat.add(cat);
            } while (c.moveToNext());
        }
        return resultat;

    }
    public List<Monplat> getAllPlat(Long id_categorie) {
        List<Monplat> resultat = new ArrayList<Monplat>();

        Cursor c = this.getAllPlatAsCursor(id_categorie);
        if (c.moveToFirst()) {
            do {
                //
                Long id = c.getLong(c.getColumnIndex("C_ID_Plat"));
                String nom = c.getString(c.getColumnIndex("C_Nom_Plat"));
                String description = c.getString(c.getColumnIndex("C_Description_Plat"));
                int photo = c.getInt(c.getColumnIndex("C_Photo_Plat"));
                Long id_cat = c.getLong(c.getColumnIndex("C_ID_Categorie"));
                Monplat cat = new Monplat(nom, description, photo);
                cat.setId(id);
                cat.setId_categorie(id_cat);

                resultat.add(cat);
            } while (c.moveToNext());
        }
        return resultat;

    }






    public void deleteAllCategorie(){

        this.getWritableDatabase().delete("Categorie" ,null , null);
    }


    public void deleteAllPlat(){

        this.getWritableDatabase().delete("Plat" ,null , null);
    }









}