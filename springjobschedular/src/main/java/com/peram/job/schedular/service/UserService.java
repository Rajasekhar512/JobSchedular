package com.peram.job.schedular.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.peram.job.schedular.domain.User;
import com.peram.job.schedular.repository.UserRepository;

@Service
public class UserService {
	
	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repo;

    @Scheduled(fixedRate = 5000)
	public void add() {
		User user = new User();
		user.setName("user" + new Random().nextInt(369));
		repo.save(user);
		System.out.println("adds every 5 secs " + new Date().toString());
	}
    
    @Scheduled(cron = "0/20 * * * * * ")
    public void fetch() {
    	List<User> users = repo.findAll();
    	System.out.println("fetch service every  20 secs "+ new Date().toString());
    	System.out.println(" no.of records "+users.size());
    	log.debug("users ",users);
    }
}
