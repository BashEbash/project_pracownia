package com.auction.entities.Triggers;


import com.auction.entities.Bidding;
import com.auction.services.BiddingService;
import com.auction.services.SubjectService;
import com.auction.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.persistence.PostPersist;

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
