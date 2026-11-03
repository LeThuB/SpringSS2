package SS10.Controller;

import SS10.Model.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @GetMapping
public ResponseEntity<List<Employee>> getAllEmployee(){
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(1L,"Nguyen A",5000));
    employees.add(new Employee(2L,"Nguyen C",6000));
    employees.add(new Employee(3L,"Nguyen D",6000));
return ResponseEntity.ok(employees);
}
}
