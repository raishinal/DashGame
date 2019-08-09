/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.service;

import com.dgame.models.RunningGame;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface RunGameService {
    public boolean addRunningGame(RunningGame rg);

    public List<RunningGame> findAllRunning();

    public RunningGame findRunningById(int id);

    public boolean updateRunning(RunningGame cat);

    public boolean deleteRunning(int id);
}
