package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.entities.Address;
import com.example.thirdtask.entities.Customer;
import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.repositories.AddressRepository;
import com.example.thirdtask.repositories.CustomerRepository;
import com.example.thirdtask.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        var existingUser = customerRepository.findById(customer.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        customerRepository.save(customer);
    }

    public void removeCustomerById(Integer id) {
        var existingUser = customerRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        customerRepository.deleteById(id);
    }

}
