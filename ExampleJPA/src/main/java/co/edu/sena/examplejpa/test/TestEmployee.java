/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.controller.EmployeeController;
import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.utils.MessageUtils;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class TestEmployee {

    public void insert(){
        try {
            Employee employee = new Employee(1120L, "ZOILA KELAVA", "Trv 12", "223");
            IEmployeeTypeController controllerType = new EmployeeTypeController();
            IEmployeeController controllerEmployee = new EmployeeController();
            EmployeeType type = controllerType.findById(1);
            employee.setTypeId(type); //FK
            controllerEmployee.insert(employee);
            MessageUtils.showInfoMessage("Empleado creado exitosamente");
        }
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
        
}
    
    public void update(){
        try {
            Employee employee = new Employee(1120L, "ALBERTO CATESTA", "Trv 13", "316");
            IEmployeeTypeController controllerType = new EmployeeTypeController();
            IEmployeeController controllerEmployee = new EmployeeController();
            EmployeeType type = controllerType.findById(1);
            employee.setTypeId(type); //FK
            controllerEmployee.update(employee);
            MessageUtils.showInfoMessage("Empleado actualizado exitosamente");
        }
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
        
}
    
    public void delete(){
        try {
            IEmployeeController controller = new EmployeeController();
            Employee employee = controller.findById(1120L);
            controller.delete(employee.getDocument());
            MessageUtils.showInfoMessage("Empleado eliminado exitosamente");
        }
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
        
}
    
    public void findAll(){
        try {
            IEmployeeController controller = new EmployeeController();
            List<Employee> employees = controller.findAll();
            String message = "";
            
            for (Employee e : employees)
            {    
                message += " Documento: " +e.getDocument()+ " Nombre: "+ e.getFullname()+
                                    "  Dirección: " +e.getDireccion()+ " Teléfono: "+ e.getTelefono()+
                                    " Tipo: "+ e.getTypeId().getDescript()+"\n";
            }
            
            MessageUtils.showInfoMessage(message);
        }
        catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
        
}
    
    public static void main(String[] args) {
        TestEmployee test = new TestEmployee();
//        test.insert();
//        test.update();
//        test.delete();
        test.findAll();
    }
}
