package nl.les10vinyl.les10vinylshop.controllers;

import nl.les10vinyl.les10vinylshop.entities.Genre;
import nl.les10vinyl.les10vinylshop.services.GenreService;
import org.springframework.web.bind.annotation.*;

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
    public Genre getGenreById(@PathVariable Long id) {
        return genreService.findGenreById(id);
    }

    // GET all
    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.findAllGenres();
    }

    // POST
    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    // PUT
    @PutMapping("/{id}")
    public Genre updateGenre(
            @PathVariable Long id,
            @RequestBody Genre genre
    ) {
        return genreService.updateGenre(id, genre);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}

