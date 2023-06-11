package ZoomCar.demo.Service;


import ZoomCar.demo.Repository.OwnerRepository;
import ZoomCar.demo.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
    public String addOwner(Owner owner) {
        ownerRepository.save(owner);
        return "Owner added succesfully";
    }
}
