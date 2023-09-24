package study.security.this_will_protect_you.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="Users")
public class User {

    protected User() {
    }

    public User(String username, String password, Algorithm algorithm, List<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.algorithm = algorithm;
        this.authorities = authorities;
    }

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Algorithm algorithm;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authority> authorities;

    public void addAuthority(Authority authority) {
        authorities.add(authority);
        authority.setUser(this);
    }

    public void removeAuthority(Authority authority) {
        authorities.remove(authority);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }
}
