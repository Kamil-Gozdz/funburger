package pl.funburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.funburger.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
