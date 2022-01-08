package com.pracownia.spring.services;

import com.pracownia.spring.entities.DeliveryOption;
import com.pracownia.spring.repositories.DeliveryOptionRepository;
import com.pracownia.spring.repositories.SubjectRepository;
import com.pracownia.spring.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SubjectServicelmpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private DeliveryOptionRepository deliveryOptionRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject findSubjectByNumber(Integer number) {
        return subjectRepository.findSubjectByNumber(number);
    }

    @Override
    public Iterable<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Iterable<Subject> AllSubjectsPaging(Integer pageNr, Integer howManyOnPage) {
        return subjectRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }

    @Override
    public void deleteSubject(Integer number) {
        subjectRepository.deleteById(number);
    }

    @Override
    public List<DeliveryOption> getDeliveryOptionBySubjects(Integer number) {
        return subjectRepository.getDeliveryOptionsBySubjectId(number);
    }
}
