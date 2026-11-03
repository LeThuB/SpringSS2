package SS9.Controller;

import SS9.Model.Dto.DepartmentDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {

    @PostMapping
    public ResponseEntity<DepartmentDTO> getDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentDTO);
    }
}
