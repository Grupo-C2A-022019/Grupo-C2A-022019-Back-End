package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;


public class OrderDTO {
    private Long id;
    private Long clientId;
    private MenuDTO menu;
    private Integer amount;
    private Double lat;
    private Double lng;

    public OrderDTO(Long id, Long clientId, MenuDTO menu, Integer amount, Double lat,Double lng){
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.menu = menu;
        this.lat = lat;
        this.lng = lng;
    }
    public OrderDTO(){

    }

    public OrderDTO(Order order) {
        this(
                order.getId(),
                order.getClient().getId(),
                new MenuDTO(order.getMenu()),
                order.getAmount(),
                order.getDeliveryAppointment().getLocation().getLat(),
                order.getDeliveryAppointment().getLocation().getLng()
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
        return menu.getId();
    }

    public MenuDTO getMenu() {
        return menu;
    }


    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
