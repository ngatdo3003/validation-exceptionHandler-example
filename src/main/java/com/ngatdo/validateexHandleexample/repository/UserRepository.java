package com.ngatdo.validateexHandleexample.repository;

import com.ngatdo.validateexHandleexample.entity.UserEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEnt, Long> {
}
