package be.ipeters.stad.entities;

import jakarta.persistence.*;
import lombok.Data;



@Table(name = "STAD")
@Entity
@Data
//@EntityListeners(AuditingEntityListener.class)
public class Stad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name="POPULATION")
    private int population;

    public Stad(Long id, String name, int population) {
        super();
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Stad(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public Stad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
