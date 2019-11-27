package ar.edu.unq.dapp.c2a.services.rating;

import ar.edu.unq.dapp.c2a.model.client.rating.Rating;

public class RatingDTO {
    private Long id;
    private Long clientId;
    private Long menuId;
    private Integer rate;

    public RatingDTO(){}

    public RatingDTO(Rating rating) {
        setClientId(rating.getClient().getId());
        setMenuId(rating.getMenu().getId());
        setRate(rating.getRate().toInteger());
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
