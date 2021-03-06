/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.TipoItem;
import java.util.*;
import org.mybatis.guice.transactional.Transactional;

/**
 *
 * @author 2105057
 */
public interface TipoItemDAO {
    
    public TipoItem load(int id) throws PersistenceException;
    
    @Transactional
    public void save(String des) throws PersistenceException;
    public List<TipoItem> loadAll() throws PersistenceException;
    
}
