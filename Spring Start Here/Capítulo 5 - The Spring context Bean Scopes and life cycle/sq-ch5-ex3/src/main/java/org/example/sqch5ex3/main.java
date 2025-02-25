package org.example.sqch5ex3;

import org.example.configuration.ProjectConfig;
import org.example.sqch5ex3.comment.services.CommentService;
import org.example.sqch5ex3.user.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Before retrieving the CommentService");
        CommentService commentService = c.getBean(CommentService.class);
        System.out.println("After retrieving the CommentService");

    }
}
