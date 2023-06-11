package ZoomCar.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    private String customerName;

    private String customerEmail;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Bookings> bookingsList;
}
