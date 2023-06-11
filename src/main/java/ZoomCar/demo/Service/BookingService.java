package ZoomCar.demo.Service;


import ZoomCar.demo.Dto.BookingRequest;
import ZoomCar.demo.Repository.BookingRepository;
import ZoomCar.demo.Repository.CategoryRespository;
import ZoomCar.demo.Repository.CustomerRepository;
import ZoomCar.demo.Repository.ProductRepository;
import ZoomCar.demo.models.Bookings;
import ZoomCar.demo.models.Category;
import ZoomCar.demo.models.Customer;
import ZoomCar.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public String AddBooking(BookingRequest bookingRequest) {
        Customer customer=customerRepository.findById(bookingRequest.getCustomerId()).get();
        Product product=productRepository.findById(bookingRequest.getProductId()).get();
        Date currentDate = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());

        // Add the specified number of hours
        LocalDateTime resultDateTime = localDateTime.plusHours(bookingRequest.getNumberOfHours());

        // Convert the LocalDateTime back to Date
        Date resultDate = Date.from(resultDateTime.atZone(ZoneId.systemDefault()).toInstant());

        if(product.isAvailable()==true && product.getEndTimeOfProduct().after(resultDate)){
                 product.setAvailable(false);
                 Bookings bookings=new Bookings();
                 int totalcost= bookingRequest.getNumberOfHours()* product.getCostForHour();
                 bookings.setTotalCost(totalcost);
                 bookings.setNumberOfHours(bookingRequest.getNumberOfHours());
                 bookings.setCustomer(customer);
                 bookings.setProduct(product);
                 return "Booking is succesfully placed";
        }
        else{
            return "That product is not available for your requirments";
        }



    }
}
