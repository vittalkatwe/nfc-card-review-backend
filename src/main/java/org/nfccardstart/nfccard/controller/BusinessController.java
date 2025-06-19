package org.nfccardstart.nfccard.controller;

import org.nfccardstart.nfccard.entity.Business;
import org.nfccardstart.nfccard.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping("/add")
    public ResponseEntity<String> addBusiness(@Validated @RequestBody Business business) {
        businessService.addBusiness(business);
        return ResponseEntity.ok("Business added successfully");
    }
    

}
