package org.example.sqch5ex3.comment.services;

import org.example.sqch5ex3.comment.processor.CommentProcessor;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;

@Service
public class CommentService {
    public void sendComment(Comment c) {
        CommentProcessor p = new CommentProcessor();
    


        c = p.getComment();


    }

}
