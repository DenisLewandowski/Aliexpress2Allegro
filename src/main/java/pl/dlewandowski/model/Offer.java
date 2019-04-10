package pl.dlewandowski.model;

import java.math.BigDecimal;
import java.util.Set;

public class Offer {

    private String aliexpressURL;
    private String title;
    private String description;
    private Set<String> imageURLs;
    private BigDecimal price;
    private String currency;
    private int quantity;

    public String getAliexpressURL() {
        return aliexpressURL;
    }

    public void setAliexpressURL(String aliexpressURL) {
        this.aliexpressURL = aliexpressURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(Set<String> imageURLs) {
        this.imageURLs = imageURLs;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
