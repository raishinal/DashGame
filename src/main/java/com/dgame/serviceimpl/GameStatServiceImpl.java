/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.serviceimpl;

import com.dgame.dao.GameStatDao;
import com.dgame.models.GameStatistics;
import com.dgame.service.GameStatService;
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
public class GameStatServiceImpl implements GameStatService{
     @Autowired
    GameStatDao gameStat;

    @Override
    public boolean addRunningGame(GameStatistics rg) {
      return gameStat.insert(rg);
    }

    @Override
    public List<GameStatistics> findAllRunning() {
       return gameStat.selectAll();
    }

    @Override
    public GameStatistics findRunningById(int id) {
        return gameStat.selectById(id);
    }

    @Override
    public boolean updateRunning(GameStatistics cat) {
        return gameStat.update(cat);
    }

    @Override
    public boolean deleteRunning(int id) {
        return gameStat.delete(id);
    }
}
