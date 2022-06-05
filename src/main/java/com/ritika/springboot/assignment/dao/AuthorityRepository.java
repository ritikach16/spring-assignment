package com.ritika.springboot.assignment.dao;

import com.ritika.springboot.assignment.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,String> {

}
