package SS8.SS81.service;

import SS8.SS81.exception.StudentNotFoundException;
import SS8.SS81.model.dto.StudentResponseDto;
import SS8.SS81.model.entity.Student;
import SS8.SS81.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public StudentResponseDto getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()->
                new StudentNotFoundException("Khong tim thay sinh vien co ID :" + id));
        return new StudentResponseDto(
                student.getFullName(),
                student.getMajor(),
                student.getAge(),
                student.getGpa(),
                student.getStudentCode()
        );
    }

}
