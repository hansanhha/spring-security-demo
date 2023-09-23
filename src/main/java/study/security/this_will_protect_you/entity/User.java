package study.security.this_will_protect_you.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="Users")
public class User {

    protected User() {
    }

    public User(Long id, String username, String password, int enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authority = "user";
    }

    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private int enabled;
    @Transient
    private String authority;

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public int getEnabled() {
        return enabled;
    }

    public String getAuthority() {
        return authority;
    }

}
