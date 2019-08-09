/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.serviceimpl;

import com.dgame.dao.RunGameDao;
import com.dgame.models.RunningGame;
import com.dgame.service.RunGameService;
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
public class RunGameServiceImpl implements RunGameService{
 @Autowired
    RunGameDao runGameDao;
    @Override
    public boolean addRunningGame(RunningGame rg) {
       return runGameDao.insert(rg);
    }

    @Override
    public List<RunningGame> findAllRunning() {
       return runGameDao.selectAll();
    }

    @Override
    public RunningGame findRunningById(int id) {
       return runGameDao.selectById(id);
    }

    @Override
    public boolean updateRunning(RunningGame cat) {
        return runGameDao.update(cat);
    }

    @Override
    public boolean deleteRunning(int id) {
        return runGameDao.delete(id);
    }
    
}
