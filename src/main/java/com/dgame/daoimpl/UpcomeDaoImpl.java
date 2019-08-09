/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.daoimpl;

import com.dgame.dao.UpcomeDao;
import com.dgame.models.Upcoming;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roslm
 */
@Repository
public class UpcomeDaoImpl implements UpcomeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(Upcoming uc) {
          boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(uc);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public List<Upcoming> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Upcoming> mcl = session.createQuery("from Upcoming").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public Upcoming selectById(int id) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Upcoming where id = :code ");
        query.setParameter("code", id);
        List<Upcoming> mcl = query.list();
        Upcoming item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean update(Upcoming uc) {
       boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(uc);
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public boolean delete(int id) {
        
        Upcoming rg = new Upcoming();
        rg.setId(id);
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(rg);
            session.getTransaction().commit();
            session.close();
            status = true;

        }
        return status;
    }

}
