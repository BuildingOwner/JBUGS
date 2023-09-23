package com.jbugs.project.service;

import com.jbugs.project.domain.Community;
import com.jbugs.project.domain.File;
import com.jbugs.project.repository.CommunityRepository;
import com.jbugs.project.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public void saveFile(File file){
        fileRepository.save(file);
    }

    public List<File> findFile(){
        return fileRepository.findAll();
    }

    public File findOne(Long fileId){
        return fileRepository.findOne(fileId);
    }

}
