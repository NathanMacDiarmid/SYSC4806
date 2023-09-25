package com.example.lab3;

import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

  AddressBook findById(Integer id);
}