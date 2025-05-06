/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *Fecha: 25/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Implementar la interface para controlar el modelo EmployeeType.
 */
public class EmployeeController implements IEmployeeController{

    
    @Override
    public void insert(Employee employee) throws Exception {
        if (employee == null)
        {
            throw  new Exception("El empleado es nulo");
        }
        
        if (employee.getDocument() == 0)
        {
            throw  new Exception("El documento es obligatorio");
        }
        
        if ("".equals(employee.getFullname()))
        {
            throw  new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(employee.getDireccion()))
        {
            throw  new Exception("La direccion es obligatoria");
        }
        
        if ("".equals(employee.getTelefono()))
        {
            throw  new Exception("El telefóno es obligatorio");
        }
        
        //FK
        if (employee.getTypeId() == null)
        {
            throw  new Exception("El tipo de empleado es obligatorio");
        }
        
        //La FK no es autoincremental, se debe validar existencia del empleado
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(employee.getDocument());
        if (employeeExists != null)
        {
            throw new Exception("Ya existe un empleado con ese documento");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().insert(employee);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Employee employee) throws Exception {
        if (employee == null)
        {
            throw  new Exception("El empleado es nulo");
        }
        
        if (employee.getDocument() == 0)
        {
            throw  new Exception("El documento es obligatorio");
        }
        
        if ("".equals(employee.getFullname()))
        {
            throw  new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(employee.getDireccion()))
        {
            throw  new Exception("La direccion es obligatoria");
        }
        
        if ("".equals(employee.getTelefono()))
        {
            throw  new Exception("El telefóno es obligatorio");
        }
        
        //FK
        if (employee.getTypeId() == null)
        {
            throw  new Exception("El tipo de empleado es obligatorio");
        }
       
        Employee employeeExists =  DAOFactory.getEmployeeDAO().findById(employee.getDocument());
        if (employeeExists == null)
        {
            throw new Exception("No existe un empleado con ese documento");
        }
        
        //Merge
        employeeExists.setDireccion(employee.getDireccion());
        employeeExists.setFullname(employee.getFullname());
        employeeExists.setTelefono(employee.getTelefono());
        employeeExists.setTypeId(employee.getTypeId());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().update(employeeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long document) throws Exception {
        if (document == 0)
        {
            throw  new Exception("El documento es obligatorio");
        }
        
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(document);
        if (employeeExists == null)
        {
            throw new Exception("No existe un empleado con ese documento");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().delete(employeeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return DAOFactory.getEmployeeDAO().findByAll();
    }

    @Override
    public Employee findById(Long document) throws Exception {
        if (document == 0)
        {
            throw  new Exception("El documento es obligatorio");
        }
        
        return DAOFactory.getEmployeeDAO().findById(document);
    }
    
}
