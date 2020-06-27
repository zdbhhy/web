package org.student.instructor;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.student.dao.AssistantMapper;
import org.student.entity.Admin;
import org.student.entity.Assistants;
import org.student.service.AssisatantService;
import org.student.service.AssistantServiceImpl;

import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {

    public static void main(String[] args) {
        AssisatantService assisatantService  = new AssistantServiceImpl();
        AssistantMapper assistantService = null;
        assisatantService.listByAll();
    }

}
