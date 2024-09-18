package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.*;
import ma.entraide.enfance.repository.BeneficiaireRepo;
import ma.entraide.enfance.repository.ClassificationCasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaireService {

    @Autowired
    private BeneficiaireRepo beneficiaireRepo;

    @Autowired
    private CentreService centreService;

    @Autowired
    private ClassificationCasService classificationCasService;

    @Autowired
    private HandicapService handicapService;

    @Autowired
    private MendiciteService mendiciteService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private SituationDeRueService situationDeRueService;

    @Autowired
    private SituationFamilialService situationFamilialService;

    @Autowired
    private SituationFinanciereService situationFinanciereService;

    @Autowired
    private SituationMedicalService situationMedicalService;

    @Autowired
    private ViolenceService violenceService;

    public List<Beneficiaire> getAllBeneficiaire() {
        return beneficiaireRepo.findAll();
    }

    public Beneficiaire getBeneficiaire(Long id) {
        Optional<Beneficiaire> beneficiaire = beneficiaireRepo.findById(id);
        if(beneficiaire.isPresent()) {
            return beneficiaire.get();
        }
        else {
            throw new ResourceNotFoundException("beneficiaire non trouvable");
        }
    }

    public String addBeneficiaire(Beneficiaire ben) {
        Centre centre = centreService.getCentreById(ben.getCentre().getId());
        ben.setCentre(centre);
        Province province = provinceService.getProvinceById(ben.getProvince().getId());
        ben.setProvince(province);
        if(ben.getClassificationCas() != null) {
            ClassificationCas classificationCas = classificationCasService.addClassificationCas(ben.getClassificationCas());
        }
        if(ben.getHandicap() != null) {
            Handicap handicap = handicapService.addHandicap(ben.getHandicap());
        }
        if(ben.getMendicite() != null) {
            Mendicite mendicite = mendiciteService.addMendicite(ben.getMendicite());
        }
        if(ben.getServices() != null) {
            Services services = serviceService.saveService(ben.getServices());
        }
        if(ben.getSituationDeRue() != null) {
            SituationDeRue situationDeRue = situationDeRueService.addSituationDeRue(ben.getSituationDeRue());
        }
        if(ben.getSituationFamilial() != null) {
            SituationFamilial situationFamilial = situationFamilialService.addSituationFamilial(ben.getSituationFamilial());
        }
        if(ben.getSituationFinanciere() != null) {
            SituationFinanciere situationFinanciere = situationFinanciereService.addSituationFinanciere(ben.getSituationFinanciere());
        }
        if(ben.getSituationMedical() != null) {
            SituationMedical situationMedical = situationMedicalService.addSituationMedical(ben.getSituationMedical());
        }
        if(ben.getViolence() != null)
        {
            Violence violence = violenceService.addViolence(ben.getViolence());
        }
        beneficiaireRepo.save(ben);
        return "beneficiaires added successfully";
    }
    public String updateBeneficiaire(Long id, Beneficiaire benDetails) {
        Beneficiaire beneficiaire = getBeneficiaire(id);
        beneficiaire.setNom(benDetails.getNom());
        beneficiaire.setPrenom(benDetails.getPrenom());
        beneficiaire.setSexe(benDetails.getSexe());
        beneficiaire.setGroupeAge(benDetails.getGroupeAge());
        beneficiaire.setScolarite(benDetails.getScolarite());
        beneficiaire.setNiveauScolaire(benDetails.getNiveauScolaire());
        beneficiaire.setSejour(benDetails.getSejour());
        beneficiaire.setTerritoire(benDetails.getTerritoire());
        beneficiaire.setSituationSocial(benDetails.getSituationSocial());

        Centre centre = centreService.getCentreById(benDetails.getCentre().getId());
        beneficiaire.setCentre(centre);
        Province province = provinceService.getProvinceById(benDetails.getProvince().getId());
        beneficiaire.setProvince(province);
        ClassificationCas classificationCas = classificationCasService.getClassificationCasById(benDetails.getClassificationCas().getId());
        beneficiaire.setClassificationCas(classificationCas);
        Handicap handicap = handicapService.getHandicapById(benDetails.getHandicap().getId());
        beneficiaire.setHandicap(handicap);
        Mendicite mendicite = mendiciteService.getMendiciteByID(benDetails.getMendicite().getId());
        beneficiaire.setMendicite(mendicite);
        Services services = serviceService.getServiceById(benDetails.getServices().getId());
        beneficiaire.setServices(services);
        SituationDeRue situationDeRue = situationDeRueService.getById(benDetails.getSituationDeRue().getId());
        beneficiaire.setSituationDeRue(situationDeRue);
        SituationFamilial situationFamilial = situationFamilialService.getById(benDetails.getSituationFamilial().getId());
        beneficiaire.setSituationFamilial(situationFamilial);
        SituationFinanciere situationFinanciere = situationFinanciereService.getSituationFinanciereById(benDetails.getSituationFinanciere().getId());
        beneficiaire.setSituationFinanciere(situationFinanciere);
        SituationMedical situationMedical = situationMedicalService.getSituationMedicalById(benDetails.getSituationMedical().getId());
        beneficiaire.setSituationMedical(situationMedical);
        Violence violence = violenceService.getById(benDetails.getViolence().getId());
        beneficiaire.setViolence(violence);

        beneficiaireRepo.save(beneficiaire);
        return "Bénéficiaire mis à jour avec succès";
    }

    public String deleteBeneficiaire(Long id) {
        Beneficiaire beneficiaire = getBeneficiaire(id);
        ClassificationCas classificationCas = classificationCasService.getClassificationCasById(beneficiaire.getClassificationCas().getId());
        Handicap handicap = handicapService.getHandicapById(beneficiaire.getHandicap().getId());
        Mendicite mendicite = mendiciteService.getMendiciteByID(beneficiaire.getMendicite().getId());
        Services services = serviceService.getServiceById(beneficiaire.getServices().getId());
        SituationDeRue situationDeRue = situationDeRueService.getById(beneficiaire.getSituationDeRue().getId());
        SituationFamilial situationFamilial = situationFamilialService.getById(beneficiaire.getSituationFamilial().getId());
        SituationFinanciere situationFinanciere = situationFinanciereService.getSituationFinanciereById(beneficiaire.getSituationFinanciere().getId());
        SituationMedical situationMedical = situationMedicalService.getSituationMedicalById(beneficiaire.getSituationMedical().getId());
        Violence violence = violenceService.getById(beneficiaire.getViolence().getId());

        // Dissocier les entités liées
        beneficiaire.setCentre(null);
        beneficiaire.setProvince(null);
        beneficiaire.setClassificationCas(null);
        beneficiaire.setHandicap(null);
        beneficiaire.setMendicite(null);
        beneficiaire.setServices(null);
        beneficiaire.setSituationDeRue(null);
        beneficiaire.setSituationFamilial(null);
        beneficiaire.setSituationFinanciere(null);
        beneficiaire.setSituationMedical(null);
        beneficiaire.setViolence(null);

        // Supprimer les relations onetone
        classificationCasService.deleteClassificationCasById(classificationCas.getId());
        handicapService.deleteHandicap(handicap.getId());
        mendiciteService.deleteMendicite(mendicite.getId());
        serviceService.deleteService(services.getId());
        situationDeRueService.deleteSituationDeRue(situationDeRue.getId());
        situationFamilialService.deleteSituationFamilial(situationFamilial.getId());
        situationFinanciereService.deleteSituationFinanciere(situationFinanciere.getId());
        situationMedicalService.deleteSituationMedicalById(situationMedical.getId());
        violenceService.deleteById(violence.getId());

        beneficiaireRepo.delete(beneficiaire);
        return "Bénéficiaire supprimé avec succès";
    }
}
