package com.github.tr1cks.treeparser;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class NumbersSumVisitorTest {
    private static Visitor<String> numbersSumVisitor;

    @Before public void setUp() { numbersSumVisitor = new NumbersSumVisitor(); }
    @After public void tearDown() { numbersSumVisitor = null; }

    @Test public void referenceTree() throws Exception {
        Node referenceTree = new Node(1, 4)
                                 .addChildNodes(new Node(2, 3),
                                                new Node(5)
                                                    .addChildNodes(new Node(6, 7)),
                                                new Node(8));
        String referenceResult = " [5 [5] [5 [13]] [8]]";

        numbersSumVisitor.visit(referenceTree);

        assertEquals(referenceResult, numbersSumVisitor.getResult());
    }
}
