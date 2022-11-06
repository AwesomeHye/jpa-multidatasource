package dev.hyein.jpamultidatasource.entity.member;

import lombok.*;
import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Student {
    @Id
    private Integer id;
    private String name;
    private String school;
}
