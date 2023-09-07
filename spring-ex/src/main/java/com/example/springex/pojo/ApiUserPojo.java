package com.example.springex.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiUserPojo {
    private Integer id;
    private String login;
    private String node_id;
}