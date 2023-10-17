package zw.tinkevtechnologies.liquorplugbackend.service.api;

import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.utils.messages.CommonResponse;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Optional;


public interface UserService  {
    CommonResponse saveUser(User user, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException;
    Optional<User> findUserByUsername(String username);

    void makeAdmin(String username);
}
