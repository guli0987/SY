package com.hkd.sy.Window;

import java.util.Date;

public class WindowEvaluationList {
    private int windowODId;
    private String username;
    private Date commentTime;
    private int favorability;
    private String comment;

    public int getWindowODId() {
        return windowODId;
    }

    public void setWindowODId(int windowODId) {
        this.windowODId = windowODId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public int getFavorability() {
        return favorability;
    }

    public void setFavorability(int favorability) {
        this.favorability = favorability;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public WindowEvaluationList(int windowODId, String username, Date commentTime, int favorability, String comment) {
        this.windowODId = windowODId;
        this.username = username;
        this.commentTime = commentTime;
        this.favorability = favorability;
        this.comment = comment;
    }
}
