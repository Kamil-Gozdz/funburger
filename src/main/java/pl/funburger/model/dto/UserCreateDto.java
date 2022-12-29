package pl.funburger.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.funburger.model.entity.Role;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto {

    private Long Id;
    @Column(unique = true)
    private String username;

    private String password;
    @Column(unique = true)
    private String email;

    private List<Role> roles;
}
