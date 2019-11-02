package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;


public class OrderDTO {
    private Long id;
    private Long clientId;
    private Long menuId;
    private Integer amount;

    OrderDTO(Order order) {
        this(
                order.getId(),
                order.getClient().getId(),
                order.getMenu().getId(),
                order.getAmount()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public OrderDTO(Long id, Long clientId, Long menuId, Integer amount) {
        this.id = id;
        this.clientId = clientId;
        this.menuId = menuId;
        this.amount = amount;
    }
}
