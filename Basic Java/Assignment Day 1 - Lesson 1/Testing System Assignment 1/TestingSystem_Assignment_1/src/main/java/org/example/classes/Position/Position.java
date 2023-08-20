package org.example.classes.Position;

public class Position {
    public byte positionID;
    public EnumPositionName positionName;

    public Position(byte positionID, EnumPositionName positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }
}
