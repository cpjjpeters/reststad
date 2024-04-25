package be.ipeters.stad.controller;

import be.ipeters.stad.entities.Stad;
import be.ipeters.stad.repositories.StadRepository;
import be.ipeters.stad.services.StadService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/steden")//, produces = MediaType.APPLICATION_JSON_VALUE)
public class StadController {

    private static final Logger log = LoggerFactory.getLogger(StadController.class);
    private final StadService stadService;
    private final StadRepository stadRepository;


    public StadController(StadService stadService, StadRepository stadRepository) {
        this.stadService = stadService;
        this.stadRepository = stadRepository;
    }

    @PostMapping
    public ResponseEntity<Stad> createStad(@RequestBody Stad stad){
        Stad savedStad = stadService.createStad(stad);
        return new ResponseEntity<>(savedStad, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Stad> getStadById(@PathVariable Long id){
        log.debug("getStad");
        Stad stad = stadService.findById(id);
        return new ResponseEntity<>(stad, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Stad>> getAllSteden(){
        List<Stad> steden = stadService.findAll();
        return new ResponseEntity<>(steden, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Stad> updateStad(@PathVariable("id") Long id, @RequestBody Stad stad) {
        stad.setId(id);
        Stad updatedStad = stadService.updateStad(stad);
        return new ResponseEntity<>(updatedStad, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStad(@PathVariable("id") Long id){
        stadService.deleteStad(id);
        return new ResponseEntity<>("Stad successfully deleted!", HttpStatus.OK);
    }
//    @GetMapping
//    public String displaySteden(Model model) {
//        log.debug("displaySteden");
//        List<Stad> steden = stadRepository.findAll();
//        model.addAttribute("steden", steden);
//        return "steden/list-steden";
//    }

//    @GetMapping("/new")
//    public String displayCityForm(Model model) {
//        log.debug("displayCityForm");
//        Stad aStad = new Stad();
//        model.addAttribute("stad", aStad);
//        return "steden/new-stad";
//    }

//    @PostMapping("/save")
//    public String createStad(be.ipeters.crudapplication.entities.Stad stad, Model model) {
//        log.debug("handle saving to DB");
////        cityJpaRepository.save(cityJpaDaoMapper.modelToJpaEntity(city));
//        stadRepository.save(stad);
//
////        stadService.save(stad);
//        return "redirect:/steden";  // going up to GetMapping slash new
//    }
}
