package view;

public enum LadderFormat {
    MARGIN("    "), //4칸 빈칸임
    VERTICAL("|"),
    CONNECTED("-----"),
    EMPTY("     "),//5칸 빈칸임
    CELL("%-6s");
    private final String symbol;

    LadderFormat(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
