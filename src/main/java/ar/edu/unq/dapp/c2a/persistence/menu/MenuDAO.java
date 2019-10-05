package ar.edu.unq.dapp.c2a.persistence.menu;

import ar.edu.unq.dapp.c2a.model.menu.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@Repository
public interface MenuDAO extends CrudRepository<Menu, Long> {
    @Query("select m from #{#entityName} m where m.availability in (select id from Availability where expiration_date < ?1 order by starting_date)")
    Iterable<Menu> getRecent(Calendar now);
}
