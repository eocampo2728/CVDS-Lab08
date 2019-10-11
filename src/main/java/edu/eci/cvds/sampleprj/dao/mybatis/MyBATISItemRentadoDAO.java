/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.ItemRentado;
import java.util.List;

/**
 *
 * @author 2120046
 */
public class MyBATISItemRentadoDAO implements ItemRentadoDAO {

    @Inject
    private ItemRentadoMapper itemRentadoMapper;

    @Override
    public int consultarDiasAlquiler(int itemId) {
        return itemRentadoMapper.consultarDiasAlquiler(itemId);
    }

    @Override
    public List<ItemRentado> loadItemsCliente(long idcliente) throws PersistenceException {
        try {
            return itemRentadoMapper.consultarItemsCliente(idcliente);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar clientes", e);
        }
    }

}
