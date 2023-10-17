package zw.tinkevtechnologies.liquorplugbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.tinkevtechnologies.liquorplugbackend.service.api.UserService;

@RestController
@RequestMapping("/api/internal")
public class InternalApiResource {
    @Autowired
    private UserService userService;
    @PutMapping("/make-admin/{username}")
    public ResponseEntity<?> makeAdmin(@PathVariable String username){
        userService.makeAdmin(username);
        return  new ResponseEntity<>(HttpStatus.OK);

    }
}
