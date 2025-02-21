package org.pg4200.ex03;

import java.util.Objects;

public class GameUser {

    private String userId;

    private int points;

    public GameUser(String userId, int points) {
        this.userId = Objects.requireNonNull(userId);
        this.points = points;
    }

    public String getUserId() {
        return userId;
    }

    public int getPoints() {
        return points;
    }

    public boolean equals(GameUser otherUser) {
        if (this.userId == otherUser.getUserId() && this.points == otherUser.points) {
            return true;
        } else {
            return false;
        }
    }
}
