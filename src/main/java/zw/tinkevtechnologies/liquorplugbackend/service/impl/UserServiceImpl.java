package zw.tinkevtechnologies.liquorplugbackend.service.impl;

import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zw.tinkevtechnologies.liquorplugbackend.model.DeliveryDetail;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.VerificationToken;
import zw.tinkevtechnologies.liquorplugbackend.repository.DeliveryDetailRepository;
import zw.tinkevtechnologies.liquorplugbackend.repository.UserRepository;
import zw.tinkevtechnologies.liquorplugbackend.repository.VerificationTokenRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.NotificationService;
import zw.tinkevtechnologies.liquorplugbackend.service.api.UserService;
import zw.tinkevtechnologies.liquorplugbackend.utils.enums.Role;
import zw.tinkevtechnologies.liquorplugbackend.utils.messages.CommonResponse;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private DeliveryDetailRepository deliveryDetailRepository;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public CommonResponse saveUser(User user ,HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        logger.info("<<<<<<<<<<<<<< Signing up  new user >>>>>>>>>>>>>>>>>>>>> ");
        CommonResponse commonResponse = new CommonResponse();
       if(userRepository.existsByUsername(user.getUsername())){
           commonResponse.setMessage("Username already registered in system");
           commonResponse.setSuccess(false);
           commonResponse.setStatusCode(100);

       }else{
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           user.setRole(Role.ADMIN);
           user.setCreatedTime(LocalDateTime.now());
           userRepository.save(user);
//           Delivery Details
           DeliveryDetail deliveryDetail= new DeliveryDetail();
           deliveryDetail.setUserid(user.getId());
           deliveryDetailRepository.save(deliveryDetail);

           VerificationToken verificationToken = new VerificationToken();
           String randomCode = RandomString.make(64);
           verificationToken.setToken(randomCode);
           verificationToken.setUser(user);
           verificationToken.setExpiryDate(Timestamp.valueOf(LocalDateTime.now().plusMinutes(30)).toLocalDateTime());
           verificationTokenRepository.save(verificationToken);
//           Send verification email
           notificationService.sendVerificationEmail(user,getSiteURL(request),verificationToken);

           commonResponse.setSuccess(true);
           commonResponse.setStatusCode(102);
           commonResponse.setMessage("User " + user.getUsername()+ " created successifully");
       }

        return commonResponse;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    @Transactional // required when executing an update/delte query
    public void makeAdmin(String username){
        userRepository.updateUserRole(username,Role.ADMIN);

    }
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }


}
