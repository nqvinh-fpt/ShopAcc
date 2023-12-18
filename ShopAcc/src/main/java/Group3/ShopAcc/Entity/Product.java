package Group3.ShopAcc.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    @Column(name = "img")
    private String img;
    @Column(name = "'rank'")
    private String rank;
    @Column(name = "skin")
    private int skin;
    @Column(name = "legend")
    private int legend;
    @Column(name = "spiritAnimal")
    private int spiritAnimal;
    @Column(name = "arena")
    private int arena;
    @Column(name = "price")
    private float price;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "accountGameID", referencedColumnName = "accountGameID")
    private AccountGame accountGame;
    @Column(name = "accountID")
    private int accountID;
}
