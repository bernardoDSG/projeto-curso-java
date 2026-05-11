package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import model.entities.Voting;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            Map<String, Integer> voting = new HashMap<>();
            while (line != null) {
                String[] fields = line.split(",");
                String candidate = fields[0];
                Integer votes = Integer.parseInt(fields[1]);
                if (voting.containsKey(candidate)) {
                    voting.put(candidate, voting.get(candidate) + votes);
                }
                else {
                    voting.put(candidate, votes);
                }
                line = br.readLine();
            }
            Set<Voting> results = new TreeSet<>();
            for(String candidate : voting.keySet()) {
                results.add(new Voting(candidate, voting.get(candidate)));
            }
            for(Voting vot : results) {
                System.out.println(vot.getCandidate() + ": " + vot.getVotes());
            }
            }
            catch(IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                sc.close();
            }
            
        }

    }


