package com.pracownia.spring.services;

import com.pracownia.spring.entities.DeliveryOption;
import com.pracownia.spring.entities.Subject;

import java.util.List;
import java.util.Set;

public interface SubjectService {
    Subject saveSubject(Subject subject);
    Subject findSubjectByNumber(Integer number);
    Iterable<Subject> getAllSubjects();
    Iterable<Subject> AllSubjectsPaging(Integer pageNr, Integer howManyOnPage);
    void deleteSubject(Integer number);
    List<DeliveryOption> getDeliveryOptionBySubjects(Integer number);
}
