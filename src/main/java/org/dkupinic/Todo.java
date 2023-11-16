package org.dkupinic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Todo {
    private String title;
    private String content;
    private boolean isFinished;

    public Todo(String title, String content, boolean isFinished) {
        this.title = title;
        this.content = content;
        this.isFinished = isFinished;
    }
}
