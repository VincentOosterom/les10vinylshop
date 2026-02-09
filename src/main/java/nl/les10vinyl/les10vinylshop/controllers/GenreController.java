package nl.les10vinyl.les10vinylshop.controllers;

import nl.les10vinyl.les10vinylshop.entities.Genre;
import nl.les10vinyl.les10vinylshop.services.GenreService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    // GET one
    @GetMapping("/{id}")
    public ResponseEntity<Genre>getGenreById(@PathVariable Long id) {
        Genre genre = genreService.findGenreById(id);
        return ResponseEntity.ok(genre);
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.findAllGenres());
    }

    // POST
    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        Genre created = genreService.createGenre(genre);

        URI location = URI.create("/genres/" + created.getId());

        return ResponseEntity
                .created(location)
                .body(created);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        Genre updated = genreService.updateGenre(id, genre);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}

