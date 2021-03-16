package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Genre;
import fr.gino.lsftranslate.model.Mot;
import fr.gino.lsftranslate.repository.MotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MotServiceImpl implements MotService {
    @Autowired
    MotRepository motRepository;

    @Override
    public Optional<Mot> findById(int id) {
        return motRepository.findById(id);
    }

    @Override
    public Mot insert(Mot mot) {
        return motRepository.save(mot);
    }

    @Override
    public Mot delete(int id) {
    Optional<Mot> mot = this.findById(id);
    if(mot.isPresent()){
    motRepository.delete(mot.get());
    }
        return null;
    }

    @Override
    public Mot update(int id, Mot mot) {
        Optional<Mot> optionalMot = this.findById(id);

        if(optionalMot.isPresent()) {
            Mot motToUpdate = optionalMot.get();
            motToUpdate.setOrtho(mot.getOrtho());
            motToUpdate.setLemme(mot.getLemme());
            motToUpdate.setInfover(mot.getInfover());
            motToUpdate.setNblettres(mot.getNblettres());
            motToUpdate.setNbsyll(mot.getNbsyll());
            motToUpdate.setOrthrenv(mot.getOrthrenv());
            motToUpdate.setVideo(mot.getVideo());
            motToUpdate.setCatgram(mot.getCatgram());
            motToUpdate.setGenre(mot.getGenre());
            motToUpdate.setNombre(mot.getNombre());
            return motRepository.save(motToUpdate);
        }
        return null;
    }

    @Override
    public List<Mot> findAllMots(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Mot> pageResult = motRepository.findAll(paging);

        if(pageResult.hasContent()){
            return pageResult.getContent();
        } else {
            return new ArrayList<Mot>();
        }
    }

    @Override
    public List<Mot> findAll() {
        return motRepository.findAll();
    }

    @Override
    public List<Mot> findMotByGenreId(int genre_id) {
        return motRepository.findMotByGenreId(genre_id);
    }

    @Override
    public Page<Mot> findAll(Pageable pageable) {
        return motRepository.findAll(pageable);
    }

}
