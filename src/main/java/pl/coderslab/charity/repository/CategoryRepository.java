package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.domain.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT category_name FROM categories", nativeQuery = true)
    List<String> getAllNames();
}
