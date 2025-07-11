package com.example.project_1.api.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "\"User\"")
@Data
public class User {
    @Id
    @Column(name = "ID")
    Integer id;

    @Column(name = "Name")
    String name;

    @Column(name = "Password")
    String password;

    @Column(name = "Accountid")
    String accountid;
}
