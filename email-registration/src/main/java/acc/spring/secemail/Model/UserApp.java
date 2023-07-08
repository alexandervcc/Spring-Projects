package acc.spring.secemail.Model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class UserApp implements UserDetails {
    @Id
    @SequenceGenerator(
        name = "user_sequence", 
        sequenceName = "user_id_sequence", 
        allocationSize = 1)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "user_id_sequence")
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userole;

    private Boolean locked;

    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
