package ma.entraide.enfance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mendicite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mendicite_id")
    private Long id;

    private String lieuMendicite;

    private String personneExploitante;

}
