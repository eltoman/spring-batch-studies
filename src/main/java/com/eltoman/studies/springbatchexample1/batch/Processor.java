package com.eltoman.studies.springbatchexample1.batch;

import com.eltoman.studies.springbatchexample1.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPT_NAMES = new HashMap<>();

    public Processor() {
        DEPT_NAMES.put("001", "Engenharia");
        DEPT_NAMES.put("002", "Produto");
        DEPT_NAMES.put("003", "Marketing");
    }

    @Override
    public User process(User user) throws Exception {
        String dept = DEPT_NAMES.get(user.getDept());
        user.setDept(dept);
        System.out.println(String.format("Converted departamente code [%s] to departament [%s]", user.getDept(), dept));
        return user;
    }
}
