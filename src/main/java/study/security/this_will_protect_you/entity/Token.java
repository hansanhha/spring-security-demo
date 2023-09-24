package study.security.this_will_protect_you.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Token {

    @Id @GeneratedValue
    @Column(name = "token_id")
    Long id;

    String identifier;

    String token;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getToken() {
        return token;
    }
}
