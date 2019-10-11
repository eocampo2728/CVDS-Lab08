/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import java.util.*;
import org.mybatis.guice.transactional.Transactional;

/**
 *
 * @author 2105057
 */
public interface ClienteDAO {
    
    public Cliente load(long id) throws PersistenceException;
	
	@Transactional
	public void addItemRentado(int idC,int idit, Date fechainicio,Date fechafin) throws PersistenceException;

	public List<Cliente> loadAll() throws PersistenceException;

	
	@Transactional
	public void setVetado(long docu, boolean estado) throws PersistenceException;
	
	public void addCliente(Cliente c) throws PersistenceException;
    
}
