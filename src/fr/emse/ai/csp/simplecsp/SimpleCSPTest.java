package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.core.*;

public class SimpleCSPTest {

    public static void main(String[] args) {
        CSP simpleCSP = new SimpleCSP();

        // Print each variable with its domain, after the reduction
        System.out.println("Domains before AC3:");
        for (Variable var : simpleCSP.getVariables()) {
            System.out.println(var + " = " + simpleCSP.getDomain(var));
        }

        AC3Strategy ac3 = new AC3Strategy();
        ac3.reduceDomains(simpleCSP);

        // Print each variable with its domain, after the reduction
        System.out.println("\nDomains after AC3:");
        for (Variable var : simpleCSP.getVariables()) {
            System.out.println(var + " = " + simpleCSP.getDomain(var));
        }

        BacktrackingStrategy bts = new BacktrackingStrategy();
        bts.addCSPStateListener(new CSPStateListener() {
            @Override
            public void stateChanged(Assignment assignment, CSP csp) {
                System.out.println("Assignment evolved : " + assignment);
            }

            @Override
            public void stateChanged(CSP csp) {
                System.out.println("CSP evolved : " + csp);
            }
        });
        double start = System.currentTimeMillis();
        Assignment sol = bts.solve(simpleCSP);
        double end = System.currentTimeMillis();

        // Print time to solve
        System.out.println(sol);
        System.out.println("Time to solve = " + (end - start));
    }
}
