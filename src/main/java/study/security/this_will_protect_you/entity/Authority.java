package study.security.this_will_protect_you.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority{

    protected Authority() {
    }

    public Authority(String name, User user) {
        this.name = name;
        this.user = user;
    }

    @Id @GeneratedValue
    @Column(name = "authority_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
