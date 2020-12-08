package year2020.java.day8;

public class Command {
    private int value;
    private Instruction instruction;


    public Command(int value, Instruction instruction) {
        this.value = value;
        this.instruction = instruction;
    }

    public int getValue() {
        return value;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
}

