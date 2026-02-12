package nl.les10vinyl.les10vinylshop.services;
import nl.les10vinyl.les10vinylshop.entities.GenreEntity;
import nl.les10vinyl.les10vinylshop.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Deze GenreService is een tijdelijke oplossing om een echte GenreService na te bootsen.
 * In de volgende les zul je deze GenreService moeten aanpassen of een nieuwe GenreService maken,
 * zodat het gebruik maakt van een database in plaats van een ArrayList.
 * De beschikbare methodes in deze Service zijn:
 * - findAllGenres
 * - findGenreById
 * - createGenre
 * - updateGenre
 * - deleteGenre
 */
@Service
public class GenreService {
    
   private final GenreRepository genreRepository;
   
   public GenreService(GenreRepository genreRepository) {
       this.genreRepository = genreRepository;
   }

//   FIND ALL
   public List<GenreEntity> findAllGenres() {
       return genreRepository.findAll();
   }

//   FIND BY ID
   public GenreEntity findGenreById(Long id) {
       return getGenreById(id);
   }

//   CREATE
   public GenreEntity createGenre(GenreEntity input) {
       return genreRepository.save(input);
   }

   public GenreEntity updateGenre(Long id, GenreEntity input) {
       GenreEntity existingGenre = getGenreById(id);

       if (existingGenre == null) {
           return null;
       }

       existingGenre.setName(input.getName());
       existingGenre.setDescription(input.getDescription());

       return genreRepository.save(existingGenre);
   }

   public void deleteGenre(Long id) {
       GenreEntity existingGenre = getGenreById(id);

       if (existingGenre != null) {
           genreRepository.delete(existingGenre);
       }
   }

   private GenreEntity getGenreById(Long id) {
       Optional<GenreEntity> optionalGenre = genreRepository.findById(id);
       return optionalGenre.orElse(null);
   }



}