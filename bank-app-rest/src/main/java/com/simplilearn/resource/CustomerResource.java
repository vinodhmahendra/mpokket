package com.simplilearn.resource;

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
        Customer customerOptional = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerOptional, HttpStatus.OK);
        }



    @PostMapping("/customers")
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody Customer theCustomer) {
        customerService.addCustomer(theCustomer);
        // create a location
        URI location =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(theCustomer.getId())
                        .toUri();

        return  ResponseEntity.created(location).build();
    }

//    @PutMapping("/customers/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable  Long id,@RequestBody Customer customerDetails){
//        Optional<Customer> customerOptional
//                = customerService.getCustomerById(id);
//
//        if (!customerOptional.isPresent()){
//            return ResponseEntity.notFound().build();
//        }
//
//        Customer customer = customerOptional.get();
//        customer.setName(customerDetails.getName());
//        customer.setEmail(customerDetails.getEmail());
//        customer.setMembershipStatus(customerDetails.getMembershipStatus());
//        customer.setDateOfBirth(customerDetails.getDateOfBirth());
//
//        customerService.updateCustomer(customer);
//
////        return ResponseEntity.ok(customer);
//        return ResponseEntity.noContent().build();//204
//    }
//
//    @DeleteMapping("/customers/{id}")
//    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
//        Optional<Customer> customerOptional =
//                customerService.getCustomerById(id);
//        if ( !customerOptional.isPresent()){
//            return ResponseEntity.notFound().build();
//        }
//
//        customerService.deleteCustomer(id);
//
//        return ResponseEntity.noContent().build();
//
//    }

}

