package repository;

import model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositoryInter extends JpaRepository<Persona, Long> {
}
