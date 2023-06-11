package ZoomCar.demo.Service;

import ZoomCar.demo.Repository.CategoryRespository;
import ZoomCar.demo.models.Category;
import ZoomCar.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;
    public String addCategory(Category category) {
        categoryRespository.save(category);
        return "Category created succesfully";

    }
}
