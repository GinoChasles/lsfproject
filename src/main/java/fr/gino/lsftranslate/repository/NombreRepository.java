package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Nombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NombreRepository extends JpaRepository<Nombre, Long> {
}
