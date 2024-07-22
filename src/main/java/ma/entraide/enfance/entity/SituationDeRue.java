package ma.entraide.enfance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SituationDeRue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rue_id")
    private Long id;

    private String raisonSortieRue;

    private String origineEnfant;

    private int durreDansRue;

    private String frequenceRue;

}
