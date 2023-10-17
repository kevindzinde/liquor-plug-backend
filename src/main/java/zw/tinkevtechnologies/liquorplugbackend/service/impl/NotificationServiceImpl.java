package zw.tinkevtechnologies.liquorplugbackend.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.VerificationToken;
import zw.tinkevtechnologies.liquorplugbackend.repository.UserRepository;
import zw.tinkevtechnologies.liquorplugbackend.repository.VerificationTokenRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.NotificationService;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@AllArgsConstructor
@Service
public class NotificationServiceImpl  implements NotificationService {

    private JavaMailSender mailSender;

    private final UserRepository userRepository;

    private final VerificationTokenRepository verificationTokenRepository;

    @Override
    public void sendVerificationEmail(User user, String siteURL, VerificationToken verificationToken) throws MessagingException, UnsupportedEncodingException {

         String toAddress = user.getEmail();
        String fromAddress = "kevindzinde2@gmail.com";
        String senderName = "LiquorPlug Account Registration";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your Account  registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "LiquorPlug Admin.";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[name]]", user.getUsername());

        String verifyURL =  siteURL + "/api/v1/auth" +"/confirmRegistration?token=" + verificationToken.getToken();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }
    public boolean verify(String verificationCode) {

        VerificationToken token = verificationTokenRepository.findVerificationTokenByToken(verificationCode);
        if (token == null ) {
            return false;
        } else {
            User user =token.getUser();
            userRepository.save(user);

            return true;
        }

    }

}
