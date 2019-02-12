package model;

import java.io.Serializable;

public class MQMessage implements Serializable {
    private final long id;
    private final String content;

    public MQMessage(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
