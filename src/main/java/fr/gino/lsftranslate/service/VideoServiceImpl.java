package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    VideoRepository videoRepository;
}
