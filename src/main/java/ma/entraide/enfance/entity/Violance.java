package ma.entraide.enfance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Violance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "violance_id")
    private Long id;

    private String descViolance;

    private String agresseur;

    private String lieuViolance;

}
