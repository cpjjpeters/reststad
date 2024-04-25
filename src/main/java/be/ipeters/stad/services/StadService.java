package be.ipeters.stad.services;



import be.ipeters.stad.entities.Stad;
import be.ipeters.stad.repositories.StadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Slf4j
@Service
public class StadService {
    private static final Logger log = LoggerFactory.getLogger(StadService.class);
    private final StadRepository stadRepository;

    public StadService(StadRepository stadRepository) {
        this.stadRepository = stadRepository;
    }

    public List<Stad> findAll(){
        log.debug("stad findall");
        return this.stadRepository.findAll();
    }

    public Stad createStad(Stad stad) {

        log.debug("createStad {}", stad);
        return this.stadRepository.save(stad);
    }

    public Stad findById(Long id) {
        Optional<Stad> optionalStad= this.stadRepository.findById(id);
        return optionalStad.get();
    }

    public Stad updateStad(Stad stad) {
        Stad existingStad = this.stadRepository.findById(stad.getId()).get();
        existingStad.setName(stad.getName());
        existingStad.setPopulation(stad.getPopulation());
        Stad updatedStad = this.stadRepository.save(existingStad);
        return updatedStad;
    }

    public void deleteStad(Long id){
        this.stadRepository.deleteById(id);
    }
}
