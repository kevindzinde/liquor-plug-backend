package zw.tinkevtechnologies.liquorplugbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.UserCart;

import java.util.List;

public interface UserCartRepository extends JpaRepository<UserCart,Long> {
     List<UserCart> findAllByUser(User user);

}
