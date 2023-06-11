package ZoomCar.demo.Controller;


import ZoomCar.demo.Dto.BookingRequest;
import ZoomCar.demo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {


    @Autowired
    private BookingService bookingService;


    @PostMapping("createbooking")
    public ResponseEntity<String> AddBooking(@RequestBody BookingRequest bookingRequest){
        String ans=bookingService.AddBooking(bookingRequest);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
}
