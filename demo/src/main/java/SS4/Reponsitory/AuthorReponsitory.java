package SS4.Reponsitory;

import SS4.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorReponsitory extends JpaRepository<Author, Long> {
}
