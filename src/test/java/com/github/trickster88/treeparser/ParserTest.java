package com.github.trickster88.treeparser;

import org.junit.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class ParserTest {
    private static Parser parser;

    @BeforeClass public static void before() { parser = new ParserImpl(); }
    @AfterClass public static void after() { parser = null; }

    @Test public void correctInput() {
        String[] referenceInput = { "[","1","[","2","3","]","4","[","5","[","6","7","]","]","[","8","]","]" };
        Node referenceTree = new Node(1, 4)
                                 .addChildNodes(new Node(2, 3),
                                                new Node(5)
                                                    .addChildNodes(new Node(6, 7)),
                                                new Node(8));

        assertEquals(referenceTree, parser.parse(referenceInput));
    }

    @Test public void partialDefinedNode() {
        checkOnWrongInput(new String[]{"[", "1", "[", "2", "3", "]", "4", "[", "5", "[", "6", "7", "]", "]", "[", "8"},
                "Input contains partial defined node");
    }

    @Test public void wrongFirstToken() {
        checkOnWrongInput(new String[]{"]", "1", "[", "2", "3", "]", "4", "[", "5", "[", "6", "7", "]", "]", "[", "8", "]", "]"},
                "First input token isn't beginning of the node");
    }

    @Test public void emptyNode() {
        checkOnWrongInput(new String[]{"[", "1", "[", "]", "4", "[", "5", "[", "6", "7", "]", "]", "[", "8", "]", "]"},
                "Input contains empty node");
    }

    @Test public void unrecognizableToken() {
        checkOnWrongInput(new String[] { "[","1","[","2","$","]","4","[","5","[","6","7","]","]","[","8","]","]" },
                          "Input contains unrecognizable token: $");
    }

    private void checkOnWrongInput(String[] incorrectInput, String expectedExcMessage) {
        try {
            parser.parse(incorrectInput);
            fail("Expected exception");
        } catch(IllegalArgumentException exc) {
            if(!expectedExcMessage.equals(exc.getMessage())) {
                fail("Expected other exception");
            }
        }
    }
}