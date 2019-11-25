package ar.edu.unq.dapp.c2a.persistence.menu;

import ar.edu.unq.dapp.c2a.model.category.Category;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.yuequan.jpa.soft.delete.repository.SoftDelete;

import java.util.Calendar;
import java.util.List;

@Repository
@SoftDelete
public interface MenuDAO extends CrudRepository<Menu, Long>, PagingAndSortingRepository<Menu,Long> {
    @Query("select m from #{#entityName} m where m.availability in (select id from Availability where expiration_date < ?1 order by starting_date)")
    Iterable<Menu> getRecent(Calendar now);

    List<Menu> findMenuByNameContains(String nombre, Pageable firstPageWithTwoElements);

    List<Menu> findMenuByCategories(List<Category> categories, Pageable firstPageWithTwoElements);
}
