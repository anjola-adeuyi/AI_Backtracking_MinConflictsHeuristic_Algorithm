package fr.emse.ai.csp.nqueen;

import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.Constraint;
import fr.emse.ai.csp.core.Variable;

import java.util.Arrays;
import java.util.List;

public class QueenConstraint implements Constraint {
    private Variable var1;
    private Variable var2;

    public QueenConstraint(Variable var1, Variable var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    @Override
    public List<Variable> getScope() {
        return Arrays.asList(var1, var2);
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        ChessBoardCell cell1 = (ChessBoardCell) assignment.getAssignment(var1);
        ChessBoardCell cell2 = (ChessBoardCell) assignment.getAssignment(var2);

        if (cell1 == null || cell2 == null) return true;

        // Check for same row, column, and diagonals
        return cell1.row != cell2.row && cell1.column != cell2.column
                && Math.abs(cell1.row - cell2.row) != Math.abs(cell1.column - cell2.column);
    }
}

// My Opinion
// Backtracking Strategy: Effective for small N (number of queens), but performance drops with larger N due to its exhaustive computation.
//The Backtracking Strategy will find a solution if it exists.
//For instance, for N = 12, it takes over 36 seconds to find a solution.

// Min-Conflicts Heuristic: Consistently fast across all N, highly efficient for larger N,
// prove a superior choice for complex instances.
//even for larger N (e.g., only 1 ms for 12 queens).
