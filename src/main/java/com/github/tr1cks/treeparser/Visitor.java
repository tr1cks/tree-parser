package com.github.tr1cks.treeparser;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public interface Visitor<T> {
    void visit(Node tree);

    T getResult();
}
