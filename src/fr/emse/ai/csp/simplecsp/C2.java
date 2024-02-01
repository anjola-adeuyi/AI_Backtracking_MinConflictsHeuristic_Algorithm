package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.Constraint;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.List;

public class C2 implements Constraint {

    private final Variable X;
    private final Variable Z;
    private final List<Variable> scope;

    public C2(Variable X, Variable Z) {
        this.X = X;
        this.Z = Z;

        scope = new ArrayList<Variable>(2);

        scope.add(X);
        scope.add(Z);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        Object valueX = assignment.getAssignment(X);
        Object valueZ = assignment.getAssignment(Z);

        if (valueX == null || valueZ == null) return true;
        return ((Integer) valueX < (Integer) valueZ);
    }
}
