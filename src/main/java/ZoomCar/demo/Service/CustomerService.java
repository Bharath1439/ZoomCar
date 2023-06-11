package ZoomCar.demo.Service;


import ZoomCar.demo.Repository.CustomerRepository;
import ZoomCar.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public String addUser(Customer customer) {
        customerRepository.save(customer);
        return "customer added succesfully";
    }
}
