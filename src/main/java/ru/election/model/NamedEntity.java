package ru.election.model;

import lombok.*;
import jakarta.validation.constraints.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Getter
//@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class NamedEntity extends BasedEntity {

    @NotBlank
    @Size(min = 2, max = 20)
    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '[' + name + ']';
    }
}
