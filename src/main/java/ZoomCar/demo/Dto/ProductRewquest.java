package ZoomCar.demo.Dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class ProductRewquest {

    private int categoryId;

    private int ownerId;

    private String productName;


    private String imageId;

    private int numberOfHours;

    private int costForHour;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date productCreatedTime;
}
