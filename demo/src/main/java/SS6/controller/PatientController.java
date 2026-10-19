package SS6.controller;

import SS6.model.dto.request.PatientRequestDto;
import SS6.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<?>addPatient(@RequestBody PatientRequestDto patientRequestDto){
        patientService.addPatient(patientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("THem benh nhan thanh cong");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletePatient(@PathVariable Long id ){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
