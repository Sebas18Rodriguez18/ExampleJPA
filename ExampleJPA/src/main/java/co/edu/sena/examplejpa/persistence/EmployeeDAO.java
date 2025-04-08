/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import co.edu.sena.examplejpa.persistence.IEmployeeDAO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class EmployeeDAO implements IEmployeeDAO{

    @Override
    public void insert(Employee employee) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(employee);
        }
        catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Employee employee) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(employee);
        }
        catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Employee employee) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(employee);
        }
        catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Employee findById(Long document) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Employee.class, document);
        }
        catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Employee> findByAll() throws Exception {
        try {
                    Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Employee.findAll");

                    return query.getResultList();
                }
                catch (RuntimeException e) {
                    throw e;
                }   
    }
    
}
