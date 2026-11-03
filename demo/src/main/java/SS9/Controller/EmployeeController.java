package SS9.Controller;

import SS9.Model.Dto.EmployeeCreateDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

  @PostMapping
  public ResponseEntity<EmployeeCreateDTO> getEmployee(@Valid @RequestBody EmployeeCreateDTO employeeCreateDTO){
      return ResponseEntity.ok(employeeCreateDTO);
  }
}
