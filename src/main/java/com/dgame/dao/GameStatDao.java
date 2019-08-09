/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.dao;

import com.dgame.models.GameStatistics;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface GameStatDao {
    public boolean insert(GameStatistics gs);

    public List<GameStatistics> selectAll();

    public GameStatistics selectById(int id);

    public boolean update(GameStatistics gs);

    public boolean delete(int id);
}
