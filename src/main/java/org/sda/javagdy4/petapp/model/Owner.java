package org.sda.javagdy4.petapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private OwnerSex sex;
    private Integer age;


    //TODO
    private Double petsAgeAverage;
    private Integer petsNumber;
//    private Set<Pet> petSet;

}



