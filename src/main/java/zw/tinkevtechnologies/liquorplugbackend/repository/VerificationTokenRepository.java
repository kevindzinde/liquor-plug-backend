package zw.tinkevtechnologies.liquorplugbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.tinkevtechnologies.liquorplugbackend.model.VerificationToken;

public interface VerificationTokenRepository  extends JpaRepository<VerificationToken,Long> {
    VerificationToken findVerificationTokenByToken(String verificationCode);
}
