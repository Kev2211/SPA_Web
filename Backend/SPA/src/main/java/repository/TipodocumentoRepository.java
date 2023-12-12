package repository;

import model.Tipodocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipodocumentoRepository extends JpaRepository<Tipodocumento, Long> {
}
