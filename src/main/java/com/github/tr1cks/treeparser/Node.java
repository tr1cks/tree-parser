package com.github.tr1cks.treeparser;

import com.google.common.base.Objects;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newLinkedList;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public class Node {
    private List<Node> children;
    private List<Integer> numbers;

    public Node() {
        children = newLinkedList();
        numbers = newLinkedList();
    }

    public Node(Integer... numbers) {
        this();

        this.numbers.addAll(asList(numbers));
    }

    public Node addChildNodes(Node... childNode) {
        children.addAll(asList(childNode));

        return this;
    }

    public Node addNumber(Integer number) {
        numbers.add(number);

        return this;
    }

    public Collection<Node> getChildren() { return unmodifiableList(children); }
    public Collection<Integer> getNumbers() { return unmodifiableList(numbers); }

    @Override public String toString() {
        return Objects.toStringHelper(this)
                .add("numbers", numbers)
                .add("children", children)
                .toString();
    }

    @Override public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Node)) return false;

        Node node = (Node) o;

        if(!children.equals(node.children)) return false;
        if(!numbers.equals(node.numbers)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = children.hashCode();
        result = 31 * result + numbers.hashCode();

        return result;
    }
}
