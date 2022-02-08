package Chess.Terminal;

public enum TerminalColor {
    ANSI_RESET("\u001B[0m"), ANSI_WHITE("\u001B[37m"), ANSI_BLACK("\u001B[30m"), ANSI_RED("\u001B[31m"), ANSI_GREEN("\u001B[32m"), ANSI_BLACK_BACKGROUND("\u001B[40m"), ANSI_WHITE_BACKGROUND("\u001B[47m");

    final private String color;

    TerminalColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}
