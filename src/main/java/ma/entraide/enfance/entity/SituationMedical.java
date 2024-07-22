package ma.entraide.enfance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SituationMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sit_medicale_id")
    private Long id;

    private String choix;

    //if choix is other than presented
    private String autre;


}
