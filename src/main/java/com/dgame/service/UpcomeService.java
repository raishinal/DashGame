/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.service;

import com.dgame.models.Upcoming;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface UpcomeService {
     public boolean addUpcomeGame(Upcoming uc);

    public List<Upcoming> findAllUpcome();

    public Upcoming findUpcommingById(int id);

    public boolean updateUpcoming(Upcoming uc);

    public boolean deleteUpcoming(int id);
}
