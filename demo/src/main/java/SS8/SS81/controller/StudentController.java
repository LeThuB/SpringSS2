package SS8.SS81.controller;

import SS8.SS81.model.dto.StudentResponseDto;
import SS8.SS81.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long id ){
        StudentResponseDto responseDto = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
