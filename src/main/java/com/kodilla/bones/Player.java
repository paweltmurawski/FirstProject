package com.kodilla.bones;

public class Player {

    public int scorePoints() {
        int totalScore = 0;
        boolean one = true;
        boolean two = true;
        boolean three = true;
        boolean four = true;
        boolean five = true;
        boolean six = true;
        if (one) {
            totalScore =+ 1;
        } else if (two) {
            totalScore =+ 2;
        } else if (three) {
            totalScore =+ 3;
        } else if (four) {
            totalScore =+ 4;
        } else if (five) {
            totalScore =+ 5;
        } else if (six) {
            totalScore =+ 6;
        }
        return totalScore;
    }

    public int countingNumberOfMoves() {
        int sum = 0;
        for (int i = 0; i <10; i++) {
            sum =+ sum;
        }
        return sum;
    }
}
