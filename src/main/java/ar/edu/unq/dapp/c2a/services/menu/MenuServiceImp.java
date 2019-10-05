package ar.edu.unq.dapp.c2a.services.menu;

import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MenuServiceImp implements MenuService {

    private final MenuDAO menuDAO;

    @Autowired
    public MenuServiceImp(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Override
    @Transactional
    public List<MenuDTO> getRecentMenus() {
        // TODO: change dao message
        Iterable<Menu> iterable = menuDAO.findAll();

        return StreamSupport.stream(iterable.spliterator(), false).map(MenuDTO::new).collect(Collectors.toList());
    }
}
