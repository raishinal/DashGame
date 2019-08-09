/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.dao;

import com.dgame.models.Upcoming;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface UpcomeDao {
      public boolean insert(Upcoming uc);

    public List<Upcoming> selectAll();

    public Upcoming selectById(int id);

    public boolean update(Upcoming uc);

    public boolean delete(int id);
}
