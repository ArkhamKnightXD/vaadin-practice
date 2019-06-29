package knight.arkham.spring.services;

import knight.arkham.spring.model.Customer;
import knight.arkham.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer){

        customerRepository.save(customer);
    }

    public List<Customer> listAllCustomers(){

        return customerRepository.findAll();
    }


    public Customer findCustomerById(long id){

        return customerRepository.findCustomerById(id);
    }

    public void deleteCustomer(Customer customer){

        customerRepository.delete(customer);
    }

}
