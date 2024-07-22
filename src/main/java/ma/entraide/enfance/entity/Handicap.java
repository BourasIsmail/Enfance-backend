package ma.entraide.enfance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Handicap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "handicap_id")
    private Long id;

    private String choix;

    //if choix is other than presented
    private String autre;

}
