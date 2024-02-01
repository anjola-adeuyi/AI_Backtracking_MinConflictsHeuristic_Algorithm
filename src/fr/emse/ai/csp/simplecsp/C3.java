package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.Constraint;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C3 implements Constraint {
    private final Variable Y;
    private final Variable Z;
    private final List<Variable> scope;

    public C3(Variable Y, Variable Z) {
        this.Y = Y;
        this.Z = Z;

        scope = new ArrayList<Variable>(2);

        scope.add(Y);
        scope.add(Z);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        Object valueY = assignment.getAssignment(Y);
        Object valueZ = assignment.getAssignment(Z);

        if (valueY == null || valueZ == null) return true;
        return ((Integer) valueZ < (Integer) valueY);
    }
}
