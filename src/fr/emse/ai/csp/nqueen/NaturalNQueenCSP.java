package fr.emse.ai.csp.nqueen;

import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.Domain;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.List;

public class NaturalNQueenCSP extends CSP {
    public NaturalNQueenCSP(int n) {
        super();
        List<ChessBoardCell> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new ChessBoardCell(i, j));
            }
        }
        Domain domain = new Domain(cells.toArray());

        for (int i = 1; i <= n; i++) {
            Variable var = new Variable("Q" + i);
            addVariable(var);
            setDomain(var, domain);
        }

        // Add QueenConstraint for each pair of queens
        List<Variable> vars = getVariables();
        for (int i = 0; i < vars.size(); i++) {
            for (int j = i + 1; j < vars.size(); j++) {
                addConstraint(new QueenConstraint(vars.get(i), vars.get(j)));
            }
        }
    }
}
