/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.service;

import com.dgame.models.GameStatistics;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface GameStatService {

    public boolean addRunningGame(GameStatistics rg);

    public List<GameStatistics> findAllRunning();

    public GameStatistics findRunningById(int id);

    public boolean updateRunning(GameStatistics cat);

    public boolean deleteRunning(int id);
}
