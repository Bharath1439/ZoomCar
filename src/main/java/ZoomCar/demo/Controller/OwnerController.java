package ZoomCar.demo.Controller;


import ZoomCar.demo.Service.OwnerService;
import ZoomCar.demo.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("createowner")
    public ResponseEntity<String> addOwner(@RequestBody Owner owner){
        String ans=ownerService.addOwner(owner);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

}
