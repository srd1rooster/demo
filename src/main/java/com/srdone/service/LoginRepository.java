package com.srdone.service;

import com.srdone.domain.LoginEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lszakacs on 0008, June 08, 2016.
 */
public interface LoginRepository extends JpaRepository<LoginEntity, Integer>{ //CrudRepository<LoginEntity, Integer>{

    LoginEntity findByUserId(String userId);
}
