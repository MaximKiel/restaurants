package ru.election.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant extends NamedEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    private String address;

    @NotBlank
    @Size(min = 2, max = 200)
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Meal> meals;

    public Restaurant(Integer id, String name, String address, String description, List<Meal> meals) {
        super(id, name);
        this.address = address;
        this.description = description;
        this.meals = meals;
    }
}
