package ZoomCar.demo.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Table(name = "products")
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;


    private String imageId;

    private int numberOfHours;

    private int costForHour;

    private Date productCreatedTime;

    private boolean available;

    private Date endTimeOfProduct;

    @JoinColumn
    @ManyToOne
    private Category category;

    @JoinColumn
    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Bookings> bookingsList;

}
