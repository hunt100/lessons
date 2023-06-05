package org.example.home1.task1;

public interface Ordered {

    int HIGHEST_PRECEDENCE = Integer.MIN_VALUE;

    int LOWEST_PRECEDENCE = Integer.MAX_VALUE;

    int getOrder();

}
