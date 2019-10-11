/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.ItemRentado;
import java.util.*;

/**
 *
 * @author 2120046
 */
public interface ItemRentadoDAO {
    
    public int consultarDiasAlquiler(int itemId);
    public List<ItemRentado> loadItemsCliente(long idcliente) throws PersistenceException;
    
}
