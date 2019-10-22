package ro.ubb.movieapp.core.model;

import lombok.*;

import javax.persistence.*;

/**
 * author: radu
 */

@Entity
@NamedEntityGraph(name = "movieProductionHouse",
        attributeNodes = @NamedAttributeNode(value = "productionHouse"))
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseEntity<Long> {
    private String title;

    private String description;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productionHouse_id", nullable = false)
    private ProductionHouse productionHouse;

}


