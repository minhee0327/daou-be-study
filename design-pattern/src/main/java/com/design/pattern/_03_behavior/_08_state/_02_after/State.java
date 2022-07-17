package com.design.pattern._03_behavior._08_state._02_after;

public interface State {
    void addReview(String review, Student student);

    void addStudent(Student student);
}
