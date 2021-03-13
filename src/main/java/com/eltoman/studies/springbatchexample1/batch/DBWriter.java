package com.eltoman.studies.springbatchexample1.batch;

import com.eltoman.studies.springbatchexample1.model.User;
import com.eltoman.studies.springbatchexample1.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {
        for (User user : users) {
            System.out.println("Users: " + user);
            userRepository.save(user);
        }
    }
}
