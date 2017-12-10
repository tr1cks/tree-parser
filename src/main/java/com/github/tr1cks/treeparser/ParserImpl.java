package com.github.tr1cks.treeparser;

import com.google.common.base.Joiner;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ParserImpl implements Parser {
    private static final String nodeBegin = "[";
    private static final String nodeEnd = "]";
    private static final Pattern numberRegexp = Pattern.compile("[+-]?\\d+");

    public static final Joiner spaceJoiner = Joiner.on(' ');

    @Override public Node parse(String[] treeStr) {
        return parse(new Scanner(spaceJoiner.join(treeStr)));
    }

    @Override public Node parse(Scanner scanner) {
        String firstToken = scanner.next();
        if(!nodeBegin.equals(firstToken)) {
            throw new IllegalArgumentException("First input token isn't beginning of the node");
        }

        return build(scanner);
    }

    private Node build(Scanner scanner) {
        Node buildingNode = new Node();

        while(scanner.hasNext()) {
            String token = scanner.next();

            if(nodeBegin.equals(token)) {
                buildingNode.addChildNodes(build(scanner));
            } else if(nodeEnd.equals(token)) {
                if(buildingNode.getNumbers().isEmpty()) {
                    throw new IllegalArgumentException("Input contains empty node");
                }

                return buildingNode;
            } else if(numberRegexp.matcher(token).matches()) {
                buildingNode.addNumber(Integer.parseInt(token));
            } else {
                throw new IllegalArgumentException("Input contains unrecognizable token: " + token);
            }
        }

        throw new IllegalArgumentException("Input contains partial defined node");
    }
}
