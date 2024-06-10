package com.codevthme.HospitalsOnPanel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ElementCollection
    private List<String> specializations;
    private Integer numberOfBeds;
    private String location;
    private Boolean pathologyServices;
    private Boolean physiotherapyServices;

}
