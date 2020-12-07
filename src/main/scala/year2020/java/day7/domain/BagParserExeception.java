package year2020.java.day7.domain;

public class BagParserExeception extends RuntimeException {
    public BagParserExeception() {
        super("Bags can not be parsed properly.");
    }
}
