package be.ipeters.stad.repositories;

import be.ipeters.stad.entities.Stad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadRepository extends JpaRepository<Stad, Long> {
    void deleteById(Long id);
}
