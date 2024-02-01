package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.Constraint;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.List;

public class C1 implements Constraint {
    private final Variable X;
    private final Variable Y;
    private final List<Variable> scope;

    public C1(Variable X, Variable Y) {
        this.X = X;
        this.Y = Y;

        scope = new ArrayList<Variable>(2);

        scope.add(X);
        scope.add(Y);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        Object valueX = assignment.getAssignment(X);
        Object valueY = assignment.getAssignment(Y);

        if (valueX == null || valueY == null) return true;
        return ((Integer) valueX + (Integer) valueY) == 9;
    }
}
