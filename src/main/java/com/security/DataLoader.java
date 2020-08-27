package com.security;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.security.entity.User;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
 
    private final UserRepository repository;
     
     
    public DataLoader(UserRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
		User u=new User("anoop","1994",true,"USER");
		
		User u1=new User("manoj","1992",true,"ADMIN");
		User u2=new User("alok","1991",true,"USER");
		User u3=new User("kishan","1993",true,"ADMIN");
		  
		  repository.save(u);
		  repository.save(u1);
		  repository.save(u2);
		  repository.save(u3);
         
    }
}