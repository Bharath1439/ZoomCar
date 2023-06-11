package ZoomCar.demo.Repository;


import ZoomCar.demo.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Integer> {
}
