package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a Population Size:");

        double populationSize = scanner.nextDouble();

        System.out.println("Population Size: " + populationSize);

        System.out.println();

        System.out.println("What Percentage of the Population Does Candidate Meet?");

        double percentCandidateMeets = scanner.nextDouble() / 100;

        System.out.println("\nCandidate Meets " + percentCandidateMeets * 100 + "% of the Populaltion");

        double numRepublicans = (populationSize / 3) * 2;
        double numDemocrats = populationSize / 3;

        int republicans = (int) Math.round(numRepublicans);
        int democrats = (int) Math.round(numDemocrats);
        int popSize = (int) populationSize;

        int[] arrRep = new int[republicans];
        int[] arrDem = new int[democrats];

        System.out.println();

        System.out.println("Republicans: " + republicans);
        System.out.println("Democrats: " + democrats);
        System.out.println("Pop Size: " + popSize);

        System.out.println();

        // Generate Random Republican Values
        for (int i = 0; i < republicans; i++) {
            arrRep[i] = getRandomVoterValues(democrats+1, popSize);
            System.out.println("arrRep[" + i + "]: " + getRandomVoterValues(democrats+1, popSize));
        }

        System.out.println();

        // Generate Random Democrat Values
        for (int i = 0; i < democrats; i++) {
            arrDem[i] = getRandomVoterValues(1, popSize-republicans-1);
            System.out.println("arrDem[" + i + "]: " + getRandomVoterValues(1, popSize-republicans-1));
        }

        // Combine arrRep and arrDem in order to randomize which voter the candidate will meet
        int arrRepLength = arrRep.length;
        int arrDemLength = arrDem.length;
        int[] arrVoters = new int[arrRepLength+arrDemLength];

        System.arraycopy(arrRep, 0, arrVoters, 0, arrRepLength);
        System.arraycopy(arrDem, 0, arrVoters, arrRepLength, arrDemLength);

        System.out.println();
        System.out.println("Voters Array: ");
        System.out.println(Arrays.toString(arrVoters));

        // Randomize Voter Array
        Random rand = new Random();

        for (int i = 0; i < arrVoters.length; i++) {
            int randomIndexToSwap = rand.nextInt(arrVoters.length);
            int temp = arrVoters[randomIndexToSwap];
            arrVoters[randomIndexToSwap] = arrVoters[i];
            arrVoters[i] = temp;
        }
        System.out.println();
        System.out.println("Voters Array Randomized: ");
        System.out.println(Arrays.toString(arrVoters));

        System.out.println();
        System.out.println("Number of Republicans: " + Math.round(numRepublicans));
        System.out.println("Number of Democrats: " + Math.round(numDemocrats));

        double numVotersMet = percentCandidateMeets * populationSize;

        System.out.println();
        System.out.println("Candidate Met This Many Voters : " + Math.round(numVotersMet));
        System.out.println();

        int count = 0;
        int currentVoter = 0;
        int vote;
        int numDemVotes = 0;
        int numRepVotes = 0;
        int totalVotes = 0;
        int didnotVote = 0;

        while ( count < popSize ) {

            // Voter Meets with Candidate

            if (count < numVotersMet ) {
                System.out.println("Candidate met with voter");

                // Candidate Meets a Republican
                if ( arrVoters[currentVoter] > democrats ) {

                    // Person Will Vote 60% of the time
                    // Person Votes Republican 60% of the time
                    // Person Votes Democrat 40% of the time
                    // Person Won't Vote 40% of the time
                    System.out.println("Candidate met with a Republican");

                    vote = getRandomVoterValues(1,100);

                    // Voter will vote
                    if ( vote > 40 ) {

                        // Determine who voter will cast vote for
                        vote = getRandomVoterValues(1,100);

                        // Voter votes Republican
                        if ( vote > 40 ) {

                            System.out.println("Republican Voter voted Republican");
                            numRepVotes++;
                            totalVotes++;

                        }

                        // Voter votes Democrat
                        else {

                            System.out.println("Republican Voter voted Democrat");
                            numDemVotes++;
                            totalVotes++;

                        }

                        System.out.println("Republican Voter voted");

                    }

                    // Voter won't vote
                    else {
                        System.out.println("Republican Voter didn't vote");
                        didnotVote++;
                    }

                }

                // Candidate Meets a Democrat
                else {

                    // Person Will Vote 70% of the time
                    // Person Votes Republican 10% of the time
                    // Person Votes Democrat 90% of the time
                    // Person Won't Vote 30% of the time
                    System.out.println("Candidate met with a Democrat");

                    vote = getRandomVoterValues(1,100);

                    // Voter will vote
                    if ( vote > 30 ) {

                        // Determine who voter will cast vote for
                        vote = getRandomVoterValues(1,100);

                        // Voter votes Republican
                        if ( vote < 11 ) {

                            System.out.println("Democrat Voter voted Republican");
                            numRepVotes++;
                            totalVotes++;

                        }

                        // Voter votes Democrat
                        else {

                            System.out.println("Democrat Voter voted Democrat");
                            numDemVotes++;
                            totalVotes++;

                        }

                        System.out.println("Democrat Voter voted");

                    }

                    // Voter won't vote
                    else {
                        System.out.println("Democrat Voter didn't vote");
                        didnotVote++;
                    }

                }

            }

            // Voter Doesn't Meet With Candidate
            else {

                System.out.println("Candidate didn't meet with voter");

                // Voter is a Republican
                if ( arrVoters[currentVoter] > democrats ) {

                    // Person Will Vote 50% of the time
                    // Person Votes Republican 80% of the time
                    // Person Votes Democrat 20% of the time
                    // Person Won't Vote 50% of the time
                    System.out.println("Candidate didn't meet with a Republican");

                    vote = getRandomVoterValues(1,100);

                    // Voter will vote
                    if ( vote > 50 ) {

                        // Determine who voter will cast vote for
                        vote = getRandomVoterValues(1,100);

                        // Voter votes Republican
                        if ( vote > 20 ) {

                            System.out.println("Republican Voter voted Republican");
                            numRepVotes++;
                            totalVotes++;

                        }

                        // Voter votes Democrat
                        else {

                            System.out.println("Republican Voter voted Democrat");
                            numDemVotes++;
                            totalVotes++;

                        }

                        System.out.println("Republican Voter voted");

                    }

                    // Voter won't vote
                    else {
                        System.out.println("Republican Voter didn't vote");
                        didnotVote++;
                    }

                }

                // Voter is a Democrat
                else {

                    // Person Will Vote 40% of the time
                    // Person Votes Republican 20% of the time
                    // Person Votes Democrat 80% of the time
                    // Person Won't Vote 60% of the time
                    System.out.println("Candidate didn't meet with a Democrat");

                    vote = getRandomVoterValues(1,100);

                    // Voter will vote
                    if ( vote > 60 ) {

                        // Determine who voter will cast vote for
                        vote = getRandomVoterValues(1,100);

                        // Voter votes Republican
                        if ( vote < 21 ) {

                            System.out.println("Democrat Voter voted Republican");
                            numRepVotes++;
                            totalVotes++;

                        }

                        // Voter votes Democrat
                        else {

                            System.out.println("Democrat Voter voted Democrat");
                            numDemVotes++;
                            totalVotes++;

                        }

                        System.out.println("Democrat Voter voted");

                    }

                    // Voter won't vote
                    else {
                        System.out.println("Democrat Voter didn't vote");
                        didnotVote++;
                    }

                }

            }

            System.out.println("Current Voter: " + currentVoter);
            System.out.println("arrVoter: " + arrVoters[currentVoter]);
            System.out.println();

            count++;
            currentVoter++;

        }

        double demWinChance = ((double) numDemVotes / (double) totalVotes ) * 100;

        System.out.println();
        System.out.println("Number of Voters: " + popSize);
        System.out.println("How many people Voted: " + totalVotes);
        System.out.println("How many people didn't vote: " + didnotVote);
        System.out.println("Number of Republican Votes: " + numRepVotes);
        System.out.println("Number of Democrat Votes: " + numDemVotes);

        System.out.printf("Democrat Candidate has a "
                + "%.2f percent chance of winning election", demWinChance);

    }

    private static int getRandomVoterValues(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
