package org.sda.javagdy4.petapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private OwnerSex sex;
    private Integer age;


    @Formula("(SELECT AVG(p.age) FROM pet p where p.owner_id = id)")
    private Double petsAgeAverage;

    @Formula("(SELECT COUNT(p.name) FROM pet p where p.owner_id = id)")
    private Integer petsNumber;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude

    private Set<Pet> petSet;
}