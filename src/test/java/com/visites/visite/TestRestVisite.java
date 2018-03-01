package com.visites.visite;

import com.visites.visite.repository.VisiteRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRestVisite {

    @Test()
    public void AtestCreate() {

        VisiteRepository ir = new VisiteRepository();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ini_PU");
        EntityManager emf = entityManagerFactory.createEntityManager();

        ir.Create(1,1,"01/03/2018","iciiiiiiiii", Byte.MAX_VALUE,Byte.MAX_VALUE);

        Query query = emf.createQuery("SELECT max(i.id) FROM Visite i");
        int last = (int) query.getSingleResult();
        emf.close();

        int id = ir.Create(2,2,"01/03/2018","01/03/2018", Byte.MAX_VALUE,Byte.MAX_VALUE);

        org.junit.Assert.assertEquals(last + 1, id);

    }

    @Test
    public void BtestGet() {

        VisiteRepository ir = new VisiteRepository();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ini_PU");
        EntityManager emf = entityManagerFactory.createEntityManager();
        Query query = emf.createQuery("SELECT max(i.id) FROM Visite i");
        int last = (int) query.getSingleResult();
        emf.close();

        String yml = ir.Read(last);

        org.junit.Assert.assertEquals(yml, "{first_name:Bob, last_name:Letton, telephone:90982818}");
    }

    @Test
    public void CtestUpdate() {

        VisiteRepository ir = new VisiteRepository();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ini_PU");
        EntityManager emf = entityManagerFactory.createEntityManager();
        Query query = emf.createQuery("SELECT max(i.id) FROM Visite i");
        int last = (int) query.getSingleResult();
        emf.close();

        int res = ir.Update(last, 3, 3,"{TestUpdate: aze}","{TestUpdate: ici");

        org.junit.Assert.assertEquals(res, 1);

        String yml = ir.Read(last);

        org.junit.Assert.assertEquals(yml, "{TestUpdate: aze}");

    }

    @Test
    public void DtestDelete() {
        VisiteRepository ir = new VisiteRepository();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ini_PU");
        EntityManager emf = entityManagerFactory.createEntityManager();
        Query query = emf.createQuery("SELECT max(i.id) FROM Visite i");
        int last = (int) query.getSingleResult();
        emf.close();

        int res = ir.Delete(last);

        org.junit.Assert.assertEquals(res, 1);
    }
}
