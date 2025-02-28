package org.example.sqch5ex3.comment.processor;

import javax.xml.stream.events.Comment;

public class CommentProcessor {
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return this.comment;
    }

    public void processComment() {
        // changing the comment attribute
    }

    public void validateComment() {
        // validating and changing the comment attribute
    }

}
