package FieldHandling;

public class Jail extends Field {
    private final boolean goTo;

    public boolean isGoTo() {
        return goTo;
    }

    public Jail(String fieldName, String fieldDiscription, int placementOnBoard, boolean goTo) {
        super(fieldName, fieldDiscription, placementOnBoard);
        this.goTo = goTo;
    }
}
