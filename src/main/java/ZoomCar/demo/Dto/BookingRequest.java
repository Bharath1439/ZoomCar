package ZoomCar.demo.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    private int productId;

    private int customerId;

    private int numberOfHours;

    private int totalCost;
}
