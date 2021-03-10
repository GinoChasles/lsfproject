package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Genre;
import fr.gino.lsftranslate.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{
    @Autowired
    GenreRepository genreRepository;

    @Override
    public Optional<Genre> findById(int id) {
        return genreRepository.findById(id);
    }

    @Override
    public Genre insert(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre update(int id, Genre genre) {
        Optional<Genre> optionalGenre = this.findById(id);

        if(optionalGenre.isPresent()){
            Genre genreToUpdate = optionalGenre.get();
            genreToUpdate.setNom(genre.getNom());
            genreToUpdate.setId(genre.getId());
            return genreRepository.save(genreToUpdate);
        }
        return null;
    }

    @Override
    public Genre delete(int id) {
        Optional<Genre> genre = this.findById(id);
        if(genre.isPresent()){
            genreRepository.delete(genre.get());
        }
        return null;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
