package SS9.Respository;

import SS9.Model.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRespository extends JpaRepository<Department,Long> {

}
