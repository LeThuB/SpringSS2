package SS4.Reponsitory;

import SS4.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReponsitory extends JpaRepository<Book, Long> {
}
