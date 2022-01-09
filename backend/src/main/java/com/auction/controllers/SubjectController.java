package com.auction.controllers;

import com.auction.services.SubjectService;
import com.auction.entities.User;
import com.auction.services.BiddingService;
import com.auction.entities.Subject;
import com.auction.services.DeliveryOptionService;
import com.auction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private BiddingService biddingService;

    @Autowired
    private DeliveryOptionService deliveryOptionService;

    @GetMapping(value = "subject/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Subject getSubject(@PathVariable Integer number) {
        return subjectService.findSubjectByNumber(number);

    }

    @GetMapping(value = "subjects", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();

    }

    @GetMapping(value = "subjects/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Subject> getSubjectsPage(@PathVariable Integer page) {
        return subjectService.AllSubjectsPaging(page, 5);

    }

    @PostMapping(value = "createSubject", produces = MediaType.APPLICATION_JSON_VALUE)
    public Subject createSubject(@RequestParam HashMap<String, String> subject_data) {

        User user = userService.findUserByLogin(subject_data.get("user_login"));
        String subject_name = subject_data.get("subject_name");
        String category = subject_data.get("category");
        BigDecimal start_price = new BigDecimal(subject_data.get("start_price"));

        Subject subject = new Subject(user, subject_name, category, start_price);
        subjectService.saveSubject(subject);

        //Bidding bidding = new Bidding(subject);
        //biddingService.saveBidding(bidding);
        return subject;
    }

    @DeleteMapping(value = "subject/{id}")
    public ResponseEntity deleteSubject(@PathVariable Integer id) {
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(value = "/subject/edit")
    public ResponseEntity editUser(@RequestBody Subject subject) {

        if(subjectService.findSubjectByNumber(subject.getNumber()) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        subjectService.saveSubject(subject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping(value = "subjects/delivery_options/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<DeliveryOption> getDeliveryOptions(@PathVariable Integer number) {
//        return subjectService.getDeliveryOptionBySubjects(number);
//
//    }
}

