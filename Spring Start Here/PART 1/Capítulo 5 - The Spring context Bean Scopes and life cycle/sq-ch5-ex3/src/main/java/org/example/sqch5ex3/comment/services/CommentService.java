package org.example.sqch5ex3.comment.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class CommentService {

    public CommentService() {
        System.out.println("Comment instance created!");
    }
}
