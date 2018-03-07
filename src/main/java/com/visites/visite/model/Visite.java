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
    private Byte signature_visiteur;

    @Column(name = "signature_agent", nullable = true)
    private Byte signature_agent;

    public int getId_agent() {
        return id_agent;
    }

    public void setIdAgent(int id_agent) {
        this.id_agent = id_agent;
    }

    public int getIdVisiteur() {
        return id_visiteur;
    }

    public void setIdVisiteur(int id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public String getDateVisite() {
        return date_visite;
    }

    public void setDateVisite(String date_visite) {
        this.date_visite = date_visite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Byte getSignatureVisiteur() {
        return signature_visiteur;
    }

    public void setSignatureVisiteur(Byte signature_visiteur) {
        this.signature_visiteur = signature_visiteur;
    }

    public Byte getSignatureAgent() {
        return signature_agent;
    }

    public void setSignatureAgent(Byte signature_agent) {
        this.signature_agent = signature_agent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
