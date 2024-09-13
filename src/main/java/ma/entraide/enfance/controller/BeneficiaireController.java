package ma.entraide.enfance.controller;

import ma.entraide.enfance.entity.Beneficiaire;
import ma.entraide.enfance.service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/beneficiaires")
public class BeneficiaireController {

    @Autowired
    private BeneficiaireService beneficiaireService;

    @GetMapping
    public ResponseEntity<List<Beneficiaire>> getAllBeneficiaires() {
        List<Beneficiaire> beneficiaires = beneficiaireService.getAllBeneficiaire();
        return new ResponseEntity<>(beneficiaires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiaire> getBeneficiaireById(@PathVariable Long id) {
        Beneficiaire beneficiaire = beneficiaireService.getBeneficiaire(id);
        return new ResponseEntity<>(beneficiaire, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        try {
            String result = beneficiaireService.addBeneficiaire(beneficiaire);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBeneficiaire(@PathVariable Long id, @RequestBody Beneficiaire beneficiaireDetails) {
        try {
            String result = beneficiaireService.updateBeneficiaire(id, beneficiaireDetails);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBeneficiaire(@PathVariable Long id) {
        try {
            String result = beneficiaireService.deleteBeneficiaire(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
