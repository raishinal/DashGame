/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.daoimpl;

import com.dgame.dao.GameStatDao;
import com.dgame.models.GameStatistics;
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
public class GameStatDaoImpl implements GameStatDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(GameStatistics gs) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(gs);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public List<GameStatistics> selectAll() {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GameStatistics> mcl = session.createQuery("from GameStatistics").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public GameStatistics selectById(int id) {
           Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from GameStatistics where id = :code ");
        query.setParameter("code", id);
        List<GameStatistics> mcl = query.list();
        GameStatistics item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean update(GameStatistics gs) {
           boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(gs);
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public boolean delete(int id) {
          GameStatistics rg = new GameStatistics();
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
