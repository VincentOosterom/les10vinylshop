package nl.les10vinyl.les10vinylshop.repositories;

import nl.les10vinyl.les10vinylshop.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}
