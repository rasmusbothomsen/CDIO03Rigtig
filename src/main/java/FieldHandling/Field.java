package FieldHandling;


public class Field {
    private final String fieldName;
    private final String fieldDiscription;

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDiscription() {
        return fieldDiscription;
    }

    public int getPlacementOnBoard() {
        return placementOnBoard;
    }

    private final int placementOnBoard;
    private String type;

    public Field(String fieldName, String fieldDiscription, int placementOnBoard) {
        this.fieldName = fieldName;
        this.fieldDiscription = fieldDiscription;
        this.placementOnBoard = placementOnBoard;
    }


}








