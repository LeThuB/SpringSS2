package SS9.Service;

import SS9.Exception.CustomException.DuplicateResourceException;
import SS9.Exception.CustomException.ResourceNotFoundException;
import SS9.Model.Dto.EmployeeCreateDTO;
import SS9.Model.Entity.Department;
import SS9.Model.Entity.Employee;
import SS9.Respository.DepartmentRespository;
import SS9.Respository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRespository employeeRespository;
@Autowired
private DepartmentRespository departmentRespository;
public ResponseEntity<?>addEmployee( Long id , EmployeeCreateDTO employeeCreateDTO ){
    Department department = departmentRespository.findById(id).orElseThrow(()->
            new ResourceNotFoundException("Khong tim thay phong ban co ID :"+ id));
if(employeeRespository.existsByEmail(employeeCreateDTO.getEmail())){
    throw new DuplicateResourceException("Email da ton tai : "+ employeeCreateDTO.getEmail());
}
 Employee employee = new Employee();
   employee.setFullName(employeeCreateDTO.getFullName());
   employee.setEmail(employeeCreateDTO.getEmail());
   employee.setPhone(employeeCreateDTO.getPhone());
   employee.setSalary(employeeCreateDTO.getSalary());
   employee.setDepartment(department);

   Employee saved = employeeRespository.save(employee);
   return ResponseEntity.ok(saved);

}

}
