package com.design.pattern._02_structure._04_decorator._01_before;

public class SpamFilterCommentService extends CommentService{
    @Override
    public void addComment(String comment){
        boolean isSpam = isSpam(comment);
        if(!isSpam){
            super.addComment(comment);
        }
    }

    private boolean isSpam(String comment){
        return comment.contains("http");
    }
}
