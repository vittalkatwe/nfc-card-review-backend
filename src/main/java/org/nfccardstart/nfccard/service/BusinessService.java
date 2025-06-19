package org.nfccardstart.nfccard.service;

import org.nfccardstart.nfccard.dto.BusinessDto;
import org.nfccardstart.nfccard.entity.Business;
import org.nfccardstart.nfccard.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BusinessService {

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public void addBusiness(Business business) {
        businessRepository.save(business);
    }

    @Transactional(readOnly = true)
    public List<BusinessDto> getAllBusinesses() {
        return businessRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private BusinessDto convertToDto(Business business) {
        return new BusinessDto(
                business.getId(),
                business.getName(),
                business.getContactEmail(),
                business.getReviewLink()
        );
    }
}
