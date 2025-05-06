/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *Fecha: 25/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Implementar la interface para controlar el modelo Record.
 */
public class RecordController implements IRecordController{
    
    @Override
    public void insert(Record record) throws Exception {
        if (record == null)
        {
            throw  new Exception("El registro es nulo");
        }
        
        if (record.getDateRecord() == null)
        {
            throw  new Exception("La fecha es obligatoria");
        }
        
        if (record.getStartTime() == null)
        {
            throw  new Exception("La hora de inicio es obligatoria");
        }
        
        if (record.getEndTime()== null)
        {
            throw  new Exception("La hora de fin es obligatoria");
        }
        
        if("".equals(record.getStatus()))
        {
            throw  new Exception("El estado es obligatorio");
        }
        
        //FK's
        if(record.getEmployeeId() == null)
        {
            throw  new Exception("El id del empleado es obligatorio");
        }
        
        if(record.getKeyId() == null)
        {
            throw  new Exception("La llave es obligatoria");
        }
        
        DAOFactory.getRecordDAO().insert(record);
    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null)
        {
            throw  new Exception("El registro es nulo");
        }
        
        if(record.getId() == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        if (record.getDateRecord()== null)
        {
            throw  new Exception("La fecha es obligatoria");
        }
        
        if (record.getStartTime() == null)
        {
            throw  new Exception("La hora de inicio es obligatoria");
        }
        
        if (record.getEndTime()== null)
        {
            throw  new Exception("La hora de fin es obligatoria");
        }
        
        //FK's
        if(record.getEmployeeId() == null)
        {
            throw  new Exception("El id del empleado es obligatorio");
        }
        
        if(record.getKeyId() == null)
        {
            throw  new Exception("La llave es obligatoria");
        }
        
        //La FK no es autoincremental, se debe validar existencia del registro.
        Record recordExists = DAOFactory.getRecordDAO().findById(record.getId());
        if (recordExists == null)
        {
            throw new Exception("No existe un registro con ese id");
        }
        
        recordExists.setDateRecord(record.getDateRecord());
        recordExists.setEmployeeId(record.getEmployeeId());
        recordExists.setStartTime(record.getStartTime());
        recordExists.setEndTime(record.getEndTime());
        recordExists.setKeyId(record.getKeyId());
        recordExists.setStatus(record.getStatus());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().update(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Record> findAll() throws Exception {
       return  DAOFactory.getRecordDAO().findByAll();
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        Record recordExists = DAOFactory.getRecordDAO().findById(id);
        if (recordExists == null)
        {
            throw new Exception("No existe un registro con ese id");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().delete(id);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Record findById(Integer id) throws Exception {
        Record recordExists = DAOFactory.getRecordDAO().findById(id);
        if (recordExists == null)
        {
            throw new Exception("No existe un registro con ese id");
        }
        
        return DAOFactory.getRecordDAO().findById(id);
    }
    
}
