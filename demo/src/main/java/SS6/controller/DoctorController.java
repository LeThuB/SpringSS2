package SS6.controller;

import SS6.model.dto.request.DoctorRequestDto;
import SS6.model.dto.response.DoctorResponseDTo;
import SS6.model.entity.Doctor;
import SS6.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<?> addDoctor(@RequestBody DoctorRequestDto doctorRequestDto){
        doctorService.addDoctor(doctorRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Them bac si thanh cong");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")

    public ResponseEntity<DoctorResponseDTo> updateDoctor(@PathVariable Long id, @RequestBody DoctorRequestDto doctorRequestDto){
       DoctorResponseDTo responseDTo= doctorService.upDateDoctor(id,doctorRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTo);
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTo>> getAllDoctor(){
        List<DoctorResponseDTo> doctors = doctorService.getAllDoctor();
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }
}
