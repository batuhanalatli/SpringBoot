package com.example.springex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="t_user")
public class ApiUser {

    @Id
    private Integer id;
    private String login;
    private String node_id;

}