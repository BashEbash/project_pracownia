package com.auction.services;

import com.auction.entities.Subject;

public interface SubjectService {
    Subject saveSubject(Subject subject);
    Subject findSubjectByNumber(Integer number);
    Iterable<Subject> getAllSubjects();
    Iterable<Subject> AllSubjectsPaging(Integer pageNr, Integer howManyOnPage);
    void deleteSubject(Integer number);
    //List<DeliveryOption> getDeliveryOptionBySubjects(Integer number);
}
