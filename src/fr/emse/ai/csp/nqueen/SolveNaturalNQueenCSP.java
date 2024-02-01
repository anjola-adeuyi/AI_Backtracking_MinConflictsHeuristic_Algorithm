package fr.emse.ai.csp.nqueen;

import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.BacktrackingStrategy;
import fr.emse.ai.csp.core.MinConflictsStrategy;

public class SolveNaturalNQueenCSP {
    public static void main(String[] args) {
        for (int n = 4; n <= 12; n++) {
            System.out.println("Solving " + n + "-Queens Problem");

            NaturalNQueenCSP csp = new NaturalNQueenCSP(n);

            // Timing Backtracking Strategy
            long startTime = System.currentTimeMillis();
            BacktrackingStrategy bts = new BacktrackingStrategy();
            Assignment solution = bts.solve(csp);
            long endTime = System.currentTimeMillis();
            System.out.println("Backtracking solution: " + solution);
            System.out.println("Backtracking Time = " + (endTime - startTime) + " ms");

            // Timing Min-Conflicts Strategy
            startTime = System.currentTimeMillis();
            MinConflictsStrategy mcs = new MinConflictsStrategy(1000);
            solution = mcs.solve(csp);
            endTime = System.currentTimeMillis();
            System.out.println("Min Conflicts solution: " + solution);
            System.out.println("Min Conflicts Time = " + (endTime - startTime) + " ms");

            System.out.println();
        }
    }
}

// Backtracking Strategy: Effective for small N (number of queens), but performance drops with larger N due to its exhaustive computation.
//The Backtracking Strategy will find a solution if it exists.
//For instance, for N = 12, it takes over 36 seconds to find a solution.

// Min-Conflicts Heuristic: Consistently fast across all N, highly efficient for larger N,
// prove a superior choice for complex instances.
//even for larger N (e.g., only 1 ms for 12 queens).


