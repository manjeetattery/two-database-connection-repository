package com.javatpoint.Repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model2.Principal;
@Repository
public interface PrincipalRepository extends JpaRepository<Principal, Long> {

}
