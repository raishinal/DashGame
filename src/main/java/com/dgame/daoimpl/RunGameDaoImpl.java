/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.daoimpl;

import com.dgame.dao.RunGameDao;
import com.dgame.models.RunningGame;
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
public class RunGameDaoImpl implements RunGameDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(RunningGame rg) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(rg);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public List<RunningGame> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<RunningGame> mcl = session.createQuery("from RunningGame").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public RunningGame selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from RunningGame where id = :code ");
        query.setParameter("code", id);
        List<RunningGame> mcl = query.list();
        RunningGame item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean update(RunningGame cat) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(cat);
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public boolean delete(int id) {

        RunningGame rg = new RunningGame();
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
