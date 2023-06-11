package ZoomCar.demo.Service;


import ZoomCar.demo.Dto.ProductResponse;
import ZoomCar.demo.Dto.ProductRewquest;
import ZoomCar.demo.Repository.CategoryRespository;
import ZoomCar.demo.Repository.OwnerRepository;
import ZoomCar.demo.Repository.ProductRepository;
import ZoomCar.demo.models.Category;
import ZoomCar.demo.models.Owner;
import ZoomCar.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRespository categoryRespository;

    @Autowired
    private OwnerRepository ownerRepository;


    public String AddProduct(ProductRewquest productRewquest) {
        Category category=categoryRespository.findById(productRewquest.getCategoryId()).get();

        Owner owner=ownerRepository.findById(productRewquest.getOwnerId()).get();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(productRewquest.getProductCreatedTime().toInstant(), ZoneId.systemDefault());

        // Add the specified number of hours
        LocalDateTime resultDateTime = localDateTime.plusHours(productRewquest.getNumberOfHours());

        // Convert the LocalDateTime back to Date
        Date resultDate = Date.from(resultDateTime.atZone(ZoneId.systemDefault()).toInstant());

        Product product=Product.builder().available(true).endTimeOfProduct(resultDate).productCreatedTime(productRewquest.getProductCreatedTime()).productName(productRewquest.getProductName()).imageId(productRewquest.getImageId()).numberOfHours(productRewquest.getNumberOfHours()).costForHour(productRewquest.getCostForHour()).build();
        product.setCategory(category);

        product.setOwner(owner);

        productRepository.save(product);
        return "Product added succesfully";
    }

    public List<ProductResponse> Getproduct() {
        List<Product> productList=productRepository.findAll();
        List<ProductResponse> productResponseList=new ArrayList<>();
        Date currentDate = new Date();
        for(Product product:productList){
            ProductResponse productResponse=new ProductResponse();
            if(product.isAvailable()==true && currentDate.before(product.getEndTimeOfProduct())){
                productResponse.setCost(product.getCostForHour());
                productResponse.setName(product.getProductName());
                productResponse.setImage(product.getImageId());
                productResponseList.add(productResponse);
            }
        }
        return productResponseList;
    }
}
