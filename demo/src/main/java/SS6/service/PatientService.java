package SS6.service;

import SS6.exception.PatientNotFoundExcetion;
import SS6.model.dto.request.PatientRequestDto;
import SS6.model.dto.response.PaginationResponse;
import SS6.model.entity.Patient;
import SS6.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Patient> findAllAndSearch(Pageable pageable, String patientName){
        if (patientName == null || patientName.trim().isEmpty()) {
            return patientRepository.findAll(pageable);
        }
        return patientRepository.findByPatientNameContainingIgnoreCase(patientName.trim(),pageable);

        }

        public PaginationResponse searchPatients(String patientName, int page, int size){
         Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,"patientName"));

         Page<Patient> patientPage = findAllAndSearch(pageable,patientName);

         return new PaginationResponse(
                 patientPage.getContent(),
                 patientPage.getTotalPages(),
                 patientPage.getTotalElements(),
                 patientPage.getNumber()

         );
        }
    }

