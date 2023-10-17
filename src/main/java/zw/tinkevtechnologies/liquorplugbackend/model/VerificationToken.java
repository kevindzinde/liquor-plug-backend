package zw.tinkevtechnologies.liquorplugbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken {
    private static final int EXPIRATION = 60 *24;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    @Column(name="token")
    private  String token ;
    @Column(name="created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name="expiry_date")
    private LocalDateTime  expiryDate;
}
