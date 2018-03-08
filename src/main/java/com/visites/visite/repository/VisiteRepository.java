package com.visites.visite.repository;

import com.visites.visite.model.Visite;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;

public class VisiteRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ini_PU");


    public int Create(int id_agent, int id_visiteur, String date_visite, String adresse, String signature_visiteur, String signature_agent) {

        EntityManager emf = entityManagerFactory.createEntityManager();
        Session session = (Session) emf.getDelegate();

        session.getTransaction().begin();

        Visite visite = new Visite();
        visite.setIdAgent(id_agent);
        visite.setIdVisiteur(id_visiteur);
        visite.setDateVisite(date_visite);
        visite.setAdresse(adresse);
        visite.setSignatureVisiteur(signature_visiteur);
        visite.setSignatureAgent(signature_agent);

        int id = (Integer) session.save(visite);

        session.getTransaction().commit();

        emf.close();

        return id;
    }

    public String Read(int id) {

        EntityManager emf = entityManagerFactory.createEntityManager();

        Query query = emf.createQuery("SELECT i FROM Visite i WHERE i.id = :id");

        query.setParameter("id", id);

        Visite res = (Visite) query.getSingleResult();

        emf.close();

        return res.toString();
    }

    public int Update(int id,int id_agent, int id_visiteur, String date_visite, String adresse) {

        EntityManager emf = entityManagerFactory.createEntityManager();
        Session session = (Session) emf.getDelegate();

        session.getTransaction().begin();

        Query query = emf.createQuery("UPDATE Visite i SET i.id_agent = :id_agent, i.id_visiteur = :id_visiteur, i.date_visite = :date_visite,  i.adresse = :adresse WHERE i.id = :id");

        query.setParameter("id_agent", id_agent);
        query.setParameter("id_visiteur", id_visiteur);
        query.setParameter("date_visite", date_visite);
        query.setParameter("adresse", adresse);
        query.setParameter("id", id);

        int res = query.executeUpdate();

        session.getTransaction().commit();

        emf.close();

        return res;
    }

    public int Delete(int id) {

        EntityManager emf = entityManagerFactory.createEntityManager();
        Session session = (Session) emf.getDelegate();

        session.getTransaction().begin();

        Query query = emf.createQuery("DELETE FROM Visite i WHERE i.id = :id");
        query.setParameter("id", id);

        int res = query.executeUpdate();

        session.getTransaction().commit();

        emf.close();

        return res;
    }

    public List All() {
        EntityManager emf = entityManagerFactory.createEntityManager();
        Session session = (Session) emf.getDelegate();

        session.getTransaction().begin();

        Query query = emf.createQuery("FROM Visite i");

        List res = query.getResultList();

        session.getTransaction().commit();

        emf.close();

        return res;
    }
}
