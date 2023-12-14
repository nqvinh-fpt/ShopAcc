package Group3.ShopAcc.Controller;

import Group3.ShopAcc.Dto.ProductDto;
import Group3.ShopAcc.Entity.Product;
import Group3.ShopAcc.Service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    public final ProductServiceImpl productService;
    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        final List<ProductDto> listProduct = productService.listAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }
    @GetMapping("/list/{productID}")
    public ResponseEntity<List<ProductDto>> getProductDetails(@PathVariable int productID){
        final List<ProductDto> listProduct = productService.listAllProductByID(productID);
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }
}
