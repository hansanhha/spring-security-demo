package study.security.this_will_protect_you.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Authorities {

    @Id @GeneratedValue
    private int id;

    private String name;

    private String authority;
}
