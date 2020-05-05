package engine.repositories;

import engine.models.Quiz;
import engine.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    @Query(value = "SELECT id FROM Quiz ORDER BY id")
    Page<Quiz> findAllQuizzesWithPagination(Pageable pageable);
}