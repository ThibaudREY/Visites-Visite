package com.visites.visite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "visite")
@JsonIgnoreProperties
public class Visite implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_agent")
    private int id_agent;

    @Column(name = "id_visiteur")
    private int id_visiteur;

    @Column(name = "date_visite")
    private String date_visite;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "signature_visiteur", nullable = true)
    private String signature_visiteur;

    @Column(name = "signature_agent", nullable = true)
    private String signature_agent;

    public int getId_agent() {
        return id_agent;
    }

    public void setId_agent(int id_agent) {
        this.id_agent = id_agent;
    }

    public int getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(int id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public String getDate_visite() {
        return date_visite;
    }

    public void setDate_visite(String date_visite) {
        this.date_visite = date_visite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSignature_visiteur() {
        return signature_visiteur;
    }

    public void setSignature_visiteur(String signature_visiteur) {
        this.signature_visiteur = signature_visiteur;
    }

    public String getSignature_agent() {
        return signature_agent;
    }

    public void setSignature_agent(String signature_agent) {
        this.signature_agent = signature_agent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{id_agent:'"+this.getId_agent()+"'," +
                "id_visiteur:'"+this.getId_visiteur()+"'," +
                "date_visite:'"+this.getDate_visite()+"'," +
                "adresse:'"+this.getAdresse()+"'," +
                "signature_visiteur:'"+this.getSignature_visiteur()+"'," +
                "signature_agent:'"+this.getSignature_agent()+"'}";
    }

}
