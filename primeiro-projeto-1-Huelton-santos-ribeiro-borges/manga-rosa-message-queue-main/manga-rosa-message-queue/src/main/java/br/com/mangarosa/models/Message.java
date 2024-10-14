package br.com.mangarosa.models;

public class Message implements Comparable<Message> {
    private String content;
    private long expirationTime;

    public Message(String content, long expirationTime) {
        this.content = content;
        this.expirationTime = expirationTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expirationTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public int compareTo(Message other) {
        return Long.compare(this.expirationTime, other.expirationTime);
    }
}