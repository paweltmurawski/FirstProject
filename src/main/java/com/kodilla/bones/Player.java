package com.kodilla.bones;

import java.util.Random;

public class Player {

    private int[] sums = new int[10];
    private int rolledNumber;

    public int scorePoints() {
        int totalScore = 0;
        for(int i = 0; i < 10; i++) {
            totalScore += sums[i];
            totalScore = countingNumberOfMoves() * generateRandomNumber();
        }
        return totalScore;
       }

    public int countingNumberOfMoves() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if(sums[i] == 0) {
                sum += 1;
            }
        }
        return sum;
    }

    public int generateRandomNumber() {
        Random randomNumber = new Random();
        int rolledNumber = randomNumber.nextInt(6) + 1;
        return rolledNumber;
    }

    public int generateMove(int numberOfMove) {
        int rolledNumber = generateRandomNumber();
        sums[numberOfMove] = rolledNumber;
        return rolledNumber;
    }

}
