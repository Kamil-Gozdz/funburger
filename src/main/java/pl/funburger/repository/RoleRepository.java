package pl.funburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.funburger.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
