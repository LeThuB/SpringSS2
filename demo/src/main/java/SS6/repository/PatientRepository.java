package SS6.repository;
import org.springframework.data.domain.Pageable;
import SS6.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient>findByPatientNameContainingIgnoreCase(
            String patientName,
            Pageable pageable
    );
}
