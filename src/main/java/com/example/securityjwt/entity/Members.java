package com.example.securityjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Members {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name="member_id")
    private Long memberId;

    @Column(name="username", length=50, unique=true)
    private String username;

    @JsonIgnore
    @Column(name="password", length=100)
    private String password;

    @Column(name="nickname", length=50)
    private String nickname;

    @JsonIgnore
    private boolean activated;

    //@OneToMany(mappedBy = "user")
    @ManyToMany
    @JoinTable(
            name="user_authority",
            joinColumns = {@JoinColumn(name="member_id", referencedColumnName = "member_id")},
            inverseJoinColumns = {@JoinColumn(name="authority_name", referencedColumnName = "authority_name")}
    )
    private Set<Authority> authorities;

}
