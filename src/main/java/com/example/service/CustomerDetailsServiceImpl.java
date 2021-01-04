package com.example.service;

import com.example.model.Customer;
import com.example.model.MyCustomerDetails;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = repository.getCustomerByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyCustomerDetails(customer);
    }
}
