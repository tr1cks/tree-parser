package com.github.trickster88.treeparser;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractVisitor<T> implements Visitor<T> {

    @Override public void visit(Node tree) {
        visitBefore(tree);

        for(Node child : tree.getChildren()) {
            visit(child);
        }

        visitAfter(tree);
    }

    protected abstract void visitBefore(Node currentNode);

    protected abstract void visitAfter(Node currentNode);
}
