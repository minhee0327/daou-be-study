package com.design.pattern._03_behavior._06_memento._02_after;

//memento
//저장된 정보 그대로 immutable 하게 하기 위해 final
public class GameSave {
    private final int blueTeamScore;

    private final int redTeamScore;

    public GameSave(int blueTeamScore, int redTeamScore) {
        this.blueTeamScore = blueTeamScore;
        this.redTeamScore = redTeamScore;
    }

    public int getBlueTeamScore() {
        return blueTeamScore;
    }

    public int getRedTeamScore() {
        return redTeamScore;
    }
}
