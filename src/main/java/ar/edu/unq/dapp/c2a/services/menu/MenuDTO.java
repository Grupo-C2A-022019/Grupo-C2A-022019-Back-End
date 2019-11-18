package ar.edu.unq.dapp.c2a.services.menu;

import ar.edu.unq.dapp.c2a.model.category.Category;
import ar.edu.unq.dapp.c2a.model.menu.Menu;

import javax.money.MonetaryAmount;
import java.util.Calendar;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.validation.constraints.*;



public class MenuDTO {
    private Long id;
    private Long businessId;
    @NotEmpty(message = "Nombre es obligatorio")
    private String name;
    @NotEmpty(message = "Descripcion es obligatorio")
    private String description;
    private Collection<Long> categoryIds;
    @NotNull(message="Se debe ingresar una fecha de inicio")
    private Calendar startingDate;
    @NotNull(message="Se debe ingresar una fecha de fin")
    private Calendar expirationDate;
    private MonetaryAmount listPrice;
    private Integer bulkSize;
    private MonetaryAmount discountedPrice;
    @NotEmpty(message="Se debe ingresar una imagen")
    private String img;

    public MenuDTO(Long id, Long businessId, String name, String description, Collection<Long> categoryIds, Calendar startingDate, Calendar expirationDate, MonetaryAmount listPrice, Integer bulkSize, MonetaryAmount discountedPrice,String img) {
        this.id = id;
        this.businessId = businessId;
        this.name = name;
        this.description = description;
        this.categoryIds = categoryIds;
        this.startingDate = startingDate;
        this.expirationDate = expirationDate;
        this.listPrice = listPrice;
        this.bulkSize = bulkSize;
        this.discountedPrice = discountedPrice;
        this.img=img;
    }
    public MenuDTO(){}

    public MenuDTO(Menu menu) {
        this(
                menu.getId(),
                menu.getBusiness().getId(),
                menu.getName(),
                menu.getDescription(),
                menu.getCategories().stream().map(Category::getId).collect(Collectors.toList()),
                menu.getStartingDate(),
                menu.getExpirationDate(),
                menu.getListPrice(),
                menu.getBulkSize(),
                menu.getDiscountPrice(),
                menu.getImg()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Collection<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Calendar getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Calendar startingDate) {
        this.startingDate = startingDate;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public MonetaryAmount getListPrice() {
        return listPrice;
    }

    public void setListPrice(MonetaryAmount listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getBulkSize() {
        return bulkSize;
    }

    public void setBulkSize(Integer bulkSize) {
        this.bulkSize = bulkSize;
    }

    public MonetaryAmount getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(MonetaryAmount discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
