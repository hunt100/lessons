package org.example.homework2;

import java.nio.charset.StandardCharsets;

public class Student {
    private String surname;
    private String mark;
    private String subject;

    public Student() {
    }

    public Student(String surname, String mark, String subject) {
        this.surname = surname;
        this.mark = mark;
        this.subject = subject;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append(toUtf8Str("Студент "))
                .append(surname)
                .append(toUtf8Str(" получил "))
                .append(mark)
                .append(toUtf8Str(" по предмету "))
                .append(subject)
                .append(".")
                .toString();
    }

    private String toUtf8Str(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
