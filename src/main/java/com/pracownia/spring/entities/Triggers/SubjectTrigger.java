package com.pracownia.spring.entities.Triggers;


import com.pracownia.spring.entities.Bidding;
import com.pracownia.spring.entities.Subject;
import com.pracownia.spring.services.BiddingService;
import com.pracownia.spring.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import javax.persistence.Column;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

@Component
public class SubjectTrigger {

    @Autowired
    private BiddingService biddingService;

    @Autowired
    private SubjectService subjectService;

    @PostPersist
    private void beforeAnyUpdate(Subject subject) {
        subject = subjectService.findSubjectByNumber(1);
        System.out.println(subject.getSubject_name());
        Bidding bidding = new Bidding(subject);
        biddingService.saveBidding(bidding);
    }
}
