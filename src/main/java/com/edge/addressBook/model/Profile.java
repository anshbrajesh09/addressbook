package com.edge.addressBook.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;
}

