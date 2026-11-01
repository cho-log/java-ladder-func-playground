package domain.random;

import domain.Connection;

@FunctionalInterface
public interface ConnectionGenerator {
    public Connection generate();
}
