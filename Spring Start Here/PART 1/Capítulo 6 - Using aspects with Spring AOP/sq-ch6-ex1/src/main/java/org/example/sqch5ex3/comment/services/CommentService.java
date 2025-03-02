package org.example.sqch5ex3.comment.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.logging.Logger;

@Service
@ComponentScan(basePackages = "sqch5ex3")
public class CommentService {
        private Logger logger = Logger.getLogger(CommentService.class.getName());

        public void publishComment(Comment comment) {
            logger.info("Iniciando a publicação do comentário: " + comment.getText());

            System.out.println("Publishing comment " + comment);

            logger.info("Commenter publish with sucess!");
    }

}
