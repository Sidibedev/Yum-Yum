package com.example.mouhamedalysidibe.restaurant;

/**
 * Created by mouhamed aly sidibe on 05/06/2017.
 */
public class Monplat {
    public long id;
    public String nom;
    public String description;
    public int image;
    public double prix;


    public Long getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Long id_categorie) {
        this.id_categorie = id_categorie;
    }

    public Long id_categorie;


    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Monplat() {

    }


    @Override
    public String toString() {
        return "Monplat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Monplat(String nom, String description, int image , double prix) {
        this.nom = nom;
        this.image = image;

        this.description = description;
        this.prix = prix;

    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


