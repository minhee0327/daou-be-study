package com.design.pattern._02_structure._04_decorator._02_after;

public class SpamFilteringCommentDecorator extends CommentDecorator{

    public SpamFilteringCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        super.addComment(comment);
    }

    private boolean isNotSpam(String comment){
        return !comment.contains("http");
    }
}
