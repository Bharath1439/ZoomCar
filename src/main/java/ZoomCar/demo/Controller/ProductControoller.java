package ZoomCar.demo.Controller;


import ZoomCar.demo.Dto.ProductResponse;
import ZoomCar.demo.Dto.ProductRewquest;
import ZoomCar.demo.Service.ProductService;
import ZoomCar.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControoller {

    @Autowired
    private ProductService productService;

    @PostMapping("createproduct")
    public ResponseEntity<String> AddProduct(@RequestBody ProductRewquest productRewquest){
        String ans=productService.AddProduct(productRewquest);
                return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("getavailableproducts")
    public ResponseEntity<List<ProductResponse>> Getproduct(){
        List<ProductResponse> responseList=productService.Getproduct();

        return new ResponseEntity<>(responseList,HttpStatus.OK);
    }

}
