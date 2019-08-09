/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.dao;

import com.dgame.models.RunningGame;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface RunGameDao {

    public boolean insert(RunningGame rg);

    public List<RunningGame> selectAll();

    public RunningGame selectById(int id);

    public boolean update(RunningGame cat);

    public boolean delete(int id);

}
