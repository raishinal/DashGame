/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.serviceimpl;

import com.dgame.dao.UpcomeDao;
import com.dgame.models.Upcoming;
import com.dgame.service.UpcomeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roslm
 */
@Service
@Transactional
public class UpcomeServiceImpl implements UpcomeService {

    @Autowired
    UpcomeDao upcomeDao;

    @Override
    public boolean addUpcomeGame(Upcoming uc) {
        return  upcomeDao.insert(uc);
    }

    @Override
    public List<Upcoming> findAllUpcome() {
      return upcomeDao.selectAll();
    }

    @Override
    public Upcoming findUpcommingById(int id) {
       return upcomeDao.selectById(id);
    }

    @Override
    public boolean updateUpcoming(Upcoming uc) {
      return upcomeDao.update(uc);
    }

    @Override
    public boolean deleteUpcoming(int id) {
      return upcomeDao.delete(id);
    }

}
