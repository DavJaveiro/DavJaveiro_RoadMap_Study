package org.example.sqch5ex3;

import org.example.configuration.ProjectConfig;
import org.example.sqch5ex3.comment.services.CommentService;
import org.example.sqch5ex3.user.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService cs1 = c.getBean(CommentService.class);
        CommentService cs2 = c.getBean(CommentService.class);

        boolean b1 = cs1 == cs2;

        System.out.println(b1);


    }
}
