package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.model.User;

public interface AuthenticationService {
    User signInAndReturnJwt(User signInRequest);
}
