package ma.entraide.enfance.controller;

import ma.entraide.enfance.entity.Centre;
import ma.entraide.enfance.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Centre")
@CrossOrigin("*")
public class CentreController {
    @Autowired
    private CentreService centreService;

    @GetMapping
    public ResponseEntity<List<Centre>> getAllCentres() {
        List<Centre> centreList = centreService.getAllCentres();
        return ResponseEntity.ok(centreList);
    }

}
