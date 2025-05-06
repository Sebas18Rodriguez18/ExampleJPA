/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *Fecha: 25/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Implementar la interface para controlar el modelo Key.
 */
public class KeyController implements IKeyRoomController{
    

    @Override
    public void insertKey(KeyRoom key) throws Exception {
        if(key == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if(key.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es obligatoria");
        }
        
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(key);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void updateKey(KeyRoom key) throws Exception {
        if(key == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("El ambiente es obligatorio");
        }
        
        if(key.getCount() == 0)
        {
            throw new Exception("La cantidad de llaves es obligatoria");
        }
        
        //Consultar si el key existe en la bd.
        KeyRoom keysExists = DAOFactory.getKeyRoomDAO().findById(key.getId());
        if(keysExists == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Merge:
        keysExists.setCount(key.getCount());
        keysExists.setName(key.getName());
        keysExists.setObservation(key.getObservation());
        keysExists.setRoom(key.getRoom());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().update(key);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void deleteKey(Integer id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        //Consultar si el key existe en la bd.
        KeyRoom keysExist = DAOFactory.getKeyRoomDAO().findById(id);
        if(keysExist == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().delete(keysExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<KeyRoom> getAllKeys() throws Exception {
        return DAOFactory.getKeyRoomDAO().findByAll();
    }

    @Override
    public KeyRoom getKeyById(Integer id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        return DAOFactory.getKeyRoomDAO().findById(id);
    }
    
}
