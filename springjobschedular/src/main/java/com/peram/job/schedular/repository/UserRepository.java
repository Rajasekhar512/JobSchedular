package com.peram.job.schedular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peram.job.schedular.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
