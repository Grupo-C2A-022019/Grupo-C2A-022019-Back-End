package ar.edu.unq.dapp.c2a.persistence.menu;

import ar.edu.unq.dapp.c2a.model.menu.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuDAO extends CrudRepository<Menu, Long> {
}
