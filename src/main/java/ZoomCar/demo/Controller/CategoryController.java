package ZoomCar.demo.Controller;


import ZoomCar.demo.Service.CategoryService;
import ZoomCar.demo.models.Category;
import ZoomCar.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("createcategory")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        String ans=categoryService.addCategory(category);

        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
}
