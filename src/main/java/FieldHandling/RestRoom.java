package FieldHandling;

public class RestRoom extends Field {
    private boolean goTo;

    public boolean isGoTo() {
        return goTo;
    }

    public RestRoom(String fieldName, String fieldDiscription, int placementOnBoard, boolean goTo) {
        super(fieldName, fieldDiscription, placementOnBoard);
        this.goTo = goTo;
    }
}
