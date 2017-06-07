package com.example.mouhamedalysidibe.restaurant;

import java.util.List;

/**
 * Created by mouhamed aly sidibe on 03/06/2017.
 */
public class Categorie {

    private long id ;
    private String nom;
    private  int photo;
    private String description;




    public Categorie(String nom, int photo, String description) {

        this.nom = nom;
        this.photo = photo;
        this.description = description;


    }

    public Categorie() {

    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", photo=" + photo +
                ", description='" + description + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
