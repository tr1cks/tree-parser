package com.github.tr1cks.treeparser;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Collection;

@NotThreadSafe
public class NumbersSumVisitor extends AbstractVisitor<String> {
    private final StringBuilder result;

    public NumbersSumVisitor() {
        this.result = new StringBuilder();
    }

    @Override protected void visitBefore(Node currentNode) {
        result.append(" [").append(sum(currentNode.getNumbers()));
    }

    @Override protected void visitAfter(Node currentNode) {
        result.append(']');
    }

    public String getResult() { return result.toString(); }

    private Integer sum(Collection<Integer> numbers) {
        int sum = 0;
        for(Integer number : numbers) {
            sum += number;
        }

        return sum;
    }
}
