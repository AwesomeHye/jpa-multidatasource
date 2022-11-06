package dev.hyein.jpamultidatasource.entity.book;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "science")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Science {
    @Id
    private Integer id;
    private String name;
    private String author;
}

