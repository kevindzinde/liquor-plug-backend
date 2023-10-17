package zw.tinkevtechnologies.liquorplugbackend.model;


import lombok.Data;
import zw.tinkevtechnologies.liquorplugbackend.utils.enums.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username",unique = true ,nullable = false,length = 100)
    private String username;
    @Column(name="password",unique = true ,nullable = false,length = 100)
    private String password;
    @Column(nullable = false,length = 100)
    private String name ;
    @Column(nullable = false,length = 100)
    private String surname ;
    @Column(nullable = false)
    private LocalDateTime createdTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;
    private String token;
    private String email;
    private String phonenumber;





}
