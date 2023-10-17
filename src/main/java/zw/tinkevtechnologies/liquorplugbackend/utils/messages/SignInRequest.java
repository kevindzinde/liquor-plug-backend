package zw.tinkevtechnologies.liquorplugbackend.utils.messages;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
