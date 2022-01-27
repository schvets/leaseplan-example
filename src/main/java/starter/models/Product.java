package starter.models;

import lombok.Data;

@Data
public class Product {
    private String provider;
    private String title;
    private String url;
    private String brand;
    private Double price;
    private String unit;
    private Boolean isPromo;
    private String promoDetails;
    private String image;
}
