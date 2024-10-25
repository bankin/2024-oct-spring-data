package bg.softuni.entities.betting.geo;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Enumerated(EnumType.STRING)
    private CountryISOCodes id;

    @Basic(optional = false)
    private String name;

    @ManyToMany
    private Set<Continent> continents;

    public Country() {
        this.continents = new HashSet<>();
    }
}
