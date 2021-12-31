package com.pracownia.spring.services;

import com.pracownia.spring.entities.Subject;
import com.pracownia.spring.repositories.SubjectRepository;
import com.pracownia.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServicelmpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
