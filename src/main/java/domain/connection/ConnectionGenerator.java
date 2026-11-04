package domain.connection;

@FunctionalInterface
public interface ConnectionGenerator {
    Connection generate();
}
