package ma.entraide.enfance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "benef_id")
    private Long id;

    private String nom;

    private String prenom;

    private String sexe;

    private String groupeAge;

    private String scolarite;

    private String niveauScolaire;

    private String sejour;

    private String territoire;

    private String situationSocial;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "centre_id")
    private Centre centre;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cas_id")
    private ClassificationCas classificationCas;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "handicap_id")
    private Handicap handicap;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "mendicite_id")
    private Mendicite mendicite;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "service_id")
    private Services services;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "rue_id")
    private SituationDeRue situationDeRue;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sit_familiale_id")
    private SituationFamilial situationFamilial;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sit_financiere_id")
    private SituationFinanciere situationFinanciere;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sit_medicale_id")
    private SituationMedical situationMedical;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "violance_id")
    private Violence violence;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "province_id")
    private Province province;

}
