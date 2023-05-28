package com.simplilearn.resource;

import com.simplilearn.exception.CustomerNotFoundException;
import com.simplilearn.model.Customer;
import com.simplilearn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.ws.Response;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        Optional<Customer> customerOptional = customerService.getCustomerById(customerId);
        if ( customerOptional.isPresent()) {
            return ResponseEntity.ok(customerOptional.get());
        }else {
            throw new CustomerNotFoundException(customerId);
        }


    }

    @PatchMapping("/customers/{id}")
    public ResponseEntity<Object> patchCustomer(@RequestBody Map<String,String> updates,@PathVariable Long id){
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if ( !customerOptional.isPresent()) {
            throw new CustomerNotFoundException(id);
        }

        Customer customer = customerOptional.get();
        if ( updates.containsKey("email")){
            customer.setEmail(updates.get("email"));
        }
        customerService.updateCustomer(customer);
        return  ResponseEntity.noContent().build();
    }


    @PostMapping("/customers")
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody Customer theCustomer) {
        Customer savedCustomer = customerService.addCustomer(theCustomer);
        // create a location
        URI location =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedCustomer.getId())
                        .toUri();

        return  ResponseEntity.created(location).build();
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable  Long id,@RequestBody Customer customerDetails){
        Optional<Customer> customerOptional
                = customerService.getCustomerById(id);

        if (!customerOptional.isPresent()){
//            return ResponseEntity.notFound().build();
//           return customerOptional.orElseThrow(()-> new CustomerNotFoundException(id));
            throw new CustomerNotFoundException(id);
        }

        Customer customer = customerOptional.get();
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setMembershipStatus(customerDetails.getMembershipStatus());
        customer.setDateOfBirth(customerDetails.getDateOfBirth());

        customerService.updateCustomer(customer);

//        return ResponseEntity.ok(customer);
        return ResponseEntity.noContent().build();//204
    }
//
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        Optional<Customer> customerOptional =
                customerService.getCustomerById(id);
        if ( !customerOptional.isPresent()){
//            return ResponseEntity.notFound().build();
            throw new CustomerNotFoundException(id);
        }

        customerService.deleteCustomer(id);

        return ResponseEntity.noContent().build();

    }

}

