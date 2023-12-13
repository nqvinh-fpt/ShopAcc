package Group3.ShopAcc.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int productID;
    private String img;
    private String rank;
    private int skin;
    private int legend;
    private int spiritAnimal;
    private int arena;
    private float price;
    private String status;
    private int categoryID;
    private int accountGameID;
    private int accountID;
    private String categoryName;
    private String accountGameName;
    private String accountPassword;
}
