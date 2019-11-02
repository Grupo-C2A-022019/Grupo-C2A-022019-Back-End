package ar.edu.unq.dapp.c2a.persistence.category;

import ar.edu.unq.dapp.c2a.model.category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Long> {
}
