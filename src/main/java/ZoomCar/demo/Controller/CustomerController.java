package ZoomCar.demo.Controller;


import ZoomCar.demo.Service.CustomerService;
import ZoomCar.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("creatuser")
    public ResponseEntity<String> addUser(@RequestBody Customer customer){
       String ans=customerService.addUser(customer);

        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

}
