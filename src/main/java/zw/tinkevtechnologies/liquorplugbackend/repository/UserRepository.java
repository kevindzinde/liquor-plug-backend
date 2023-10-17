package zw.tinkevtechnologies.liquorplugbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.utils.enums.Role;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUserRole(@Param("username")String username , @Param("role")Role role);

    boolean existsByUsername(String username);
}
