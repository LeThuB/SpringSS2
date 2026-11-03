package SS10.Respository;

import SS10.Model.entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee2Repository extends JpaRepository<Employee2,Long> {
}
