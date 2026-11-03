package SS9.Respository;

import SS9.Model.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee,Long> {

    boolean existsByEmail(String email);
}
