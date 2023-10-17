package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.VerificationToken;
import zw.tinkevtechnologies.liquorplugbackend.utils.messages.CommonResponse;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface NotificationService {


    void sendVerificationEmail(User user, String siteURL, VerificationToken verificationToken) throws MessagingException, UnsupportedEncodingException;
}
