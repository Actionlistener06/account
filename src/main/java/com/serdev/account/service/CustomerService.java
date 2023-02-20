package com.serdev.account.service;

import com.serdev.account.dto.CustomerDto;
import com.serdev.account.dto.CustomerDtoConverter;
import com.serdev.account.exception.CustomerNotFoundException;
import com.serdev.account.model.Customer;
import com.serdev.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }
    protected Customer findCustomerById(String id){

        return customerRepository.findById(id)
                .orElseThrow(
                ()->new CustomerNotFoundException("Customer not find by id "+id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto(findCustomerById(customerId));
    }
    public List<CustomerDto> getAllCustomer() {

        return customerRepository.findAll()
                .stream()
                .map(customerDtoConverter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
