package checks;

import org.sonar.api.batch.sensor.issue.Issue;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.AssignmentExpressionTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.Collections;
import java.util.List;

@Rule(key ="NoStreamsRedSmell")
public class NoStreamsCheck extends IssuableSubscriptionVisitor{
    @Override
    public List<Kind> nodesToVisit() {
        return Collections.singletonList(Kind.ASSIGNMENT);
    }

    @Override
    public void visitNode(Tree tree) {
        /*AssignmentExpressionTree variableTree = (AssignmentExpressionTree) tree;
        if(variableTree.expression().symbolType())
        //...
        ReportIssue*/
    }
}
