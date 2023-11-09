package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_GENRE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GENRE")
    @SequenceGenerator(name = "SQ_GENRE", sequenceName = "SQ_GENRE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_GENRE")
    private Long id;

    @Column(name = "NAME_GENRE")
    private String name;

    public Genre() {
    }

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Genre setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Genre setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}