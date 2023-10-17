package zw.tinkevtechnologies.liquorplugbackend.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.service.api.AuthenticationService;
import zw.tinkevtechnologies.liquorplugbackend.service.api.UserService;
import zw.tinkevtechnologies.liquorplugbackend.utils.messages.CommonResponse;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationResource {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(AuthenticationResource.class);

    @PostMapping("/sign-up")
    public ResponseEntity<CommonResponse> signUp(@RequestBody User user , HttpServletRequest request) {
        CommonResponse registerUserResponse = new CommonResponse();
        logger.info("<<<<<<< Request to register new user >>>>>>>");
        try{

           CommonResponse response = userService.saveUser(user,request);
            if(response.getStatusCode()==100){
                registerUserResponse.setMessage(response.getMessage());
                registerUserResponse.setSuccess(response.isSuccess());
                registerUserResponse.setStatusCode(response.getStatusCode());
                return ResponseEntity.status(HttpStatus.CONFLICT).body(registerUserResponse);
            }else {
                registerUserResponse.setMessage(response.getMessage());
                registerUserResponse.setSuccess(response.isSuccess());
                registerUserResponse.setStatusCode(response.getStatusCode());
                return ResponseEntity.status(HttpStatus.OK).body(registerUserResponse);

            }




        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }



    }
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        try {
            User user1 = authenticationService.signInAndReturnJwt(user);
            return ResponseEntity.ok(user1);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
