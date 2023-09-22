package com.jbugs.project.service;

import com.jbugs.project.domain.Professor;
import com.jbugs.project.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public void saveProfessor(Professor professor){
        professorRepository.save(professor);
    }

    public List<Professor> findProfessor(){
        return professorRepository.findAll();
    }

    public Professor findOne(Long professorId){
        return professorRepository.findOne(professorId);
    }
}