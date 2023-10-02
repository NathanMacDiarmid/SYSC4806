package com.example.lab4;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

  BuddyInfo findByName(String name);

  BuddyInfo findById(Integer id);
}