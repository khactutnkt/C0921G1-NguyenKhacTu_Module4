package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService{
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
