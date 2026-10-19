package SS6.service;

import SS6.exception.PatientNotFoundExcetion;
import SS6.model.dto.request.PatientRequestDto;
import SS6.model.entity.Patient;
import SS6.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(PatientRequestDto patientRequestDto){
        Patient patient = new Patient();
        patient.setPatientCode(patientRequestDto.getPatientCode());
        patient.setFullName(patientRequestDto.getFullName());
        patient.setPhone(patientRequestDto.getPhone());
        patient.setAddress(patientRequestDto.getAddress());
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id){
        Patient patient = patientRepository.findById(id).orElseThrow(()
                -> new PatientNotFoundExcetion("Khong tim thay benh nhan co ID "+ id));
        patientRepository.delete(patient);
    }
}
