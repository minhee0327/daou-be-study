package com.design.pattern._02_structure._04_decorator._01_before;

public class Client {

    private CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment){
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
        //컴파일 타임에 이미 어떤 클래스를 사용하는지 정해져버려서 유연하지가 않다.
        Client client = new Client(new TrimmingCommentService());
        client.writeComment("오징어 게임");
        client.writeComment("보는게 하는거보다 재밌을 수가 없지...");
        client.writeComment("https://whiteship.me");
    }
}
