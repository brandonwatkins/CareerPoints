package edu.mhu.cs.brandonwatkins.careerpoints;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by brandonwatkins on 13/09/17.
 */

public class cpData implements Serializable {

    private int currentPoints;
    private int desiredPoints;
    private int minGames;
    private int maxGames;

    public cpData(int currentPoints, int desiredPoints, int minGames, int maxGames){
        setCurrentPoints(currentPoints);
        setDesiredPoints(desiredPoints);
        setMinGames(minGames);
        setMaxGames(maxGames);
    }

    public String displayGames() {

        String numGames = "";

        for(int i = minGames; i <= maxGames; i++) {
            numGames += i + "\n";
        }

        return numGames;
    }

    public String calcAvgPointsNeeded() {
        //if(desiredPoints == 0) return -1;

        int pointsNeeded = desiredPoints - currentPoints;
        double avgPoints;
        String pointsMessage = "";
        for(double i = minGames; i <= maxGames; i++) {
            avgPoints = (pointsNeeded / i);
            avgPoints = Double.parseDouble(new DecimalFormat("##.##").format(avgPoints));
            System.out.println(avgPoints);
            pointsMessage += "= " + avgPoints + "\n";
        }

        return pointsMessage;

    }

    /*
    public String calcAvgPointsNeeded() {
        //if(desiredPoints == 0) return -1;

        int pointsNeeded = desiredPoints - currentPoints;
        String avgPoints = "";
        for(int i = minGames; i <= maxGames; i++) {
            avgPoints += "= " + (pointsNeeded / i) + "\n";
        }

        return avgPoints;

    }
    */

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public int getDesiredPoints() {
        return desiredPoints;
    }

    public void setDesiredPoints(int desiredPoints) {
        this.desiredPoints = desiredPoints;
    }

    public int getMinGames() {
        return minGames;
    }

    public void setMinGames(int minGames) {
        this.minGames = minGames;
    }

    public int getMaxGames() {
        return maxGames;
    }

    public void setMaxGames(int maxGames) {
        this.maxGames = maxGames;
    }
}
