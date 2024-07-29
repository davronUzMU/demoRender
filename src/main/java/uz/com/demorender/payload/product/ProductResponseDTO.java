package uz.com.demorender.payload.product;

import lombok.*;
import uz.com.demorender.model.Color;
import uz.com.demorender.model.ImgUrl;
import uz.com.demorender.model.Product;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductResponseDTO {

    private Integer id;

    private String productName;

    private Set<ImgUrl> imgId;

    private Double prise;

    private Boolean availability;

    private Integer numberOfProducts;

    private String aboutProduct;

    private Color name;

    public ProductResponseDTO(Product product) {
                this.id = product.getId();
                this.productName = product.getName();
                this.imgId = product.getImgUrlSet();
                this.prise = product.getPrise();
                this.availability=product.isAvailability();
                this.numberOfProducts=product.getNumberOfProducts();
                this.aboutProduct=product.getAboutProduct();
                this.name=product.getColor();
    }
}
