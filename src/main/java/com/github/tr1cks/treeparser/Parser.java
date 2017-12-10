package com.github.tr1cks.treeparser;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Scanner;

@ThreadSafe
public interface Parser {
    Node parse(String[] treeStr);
    Node parse(Scanner scanner);
}
