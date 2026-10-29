package domain;

@FunctionalInterface
public interface ConnectionGenerator {
    Connection generate();
}
