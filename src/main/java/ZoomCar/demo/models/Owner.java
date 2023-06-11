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
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ownerId;

    private String ownerName;

    private String ownerEmail;

    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private List<Product> productList;
}
