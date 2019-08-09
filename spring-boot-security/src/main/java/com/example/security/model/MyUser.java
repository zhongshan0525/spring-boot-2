package com.example.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Auther: zyl
 * @Date: 2019\7\4 0004 09:16
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "my_user")
public class MyUser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private String role;
}
