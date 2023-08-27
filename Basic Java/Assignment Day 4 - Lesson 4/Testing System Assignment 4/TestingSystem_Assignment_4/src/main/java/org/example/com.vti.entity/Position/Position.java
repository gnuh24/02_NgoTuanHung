package org.example.com.vti.entity.Position;

public class Position {
    private byte positionID;
    private EnumPositionName positionName;

    public byte getPositionID() {
        return positionID;
    }

    public void setPositionID(byte positionID) {
        this.positionID = positionID;
    }

    public EnumPositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(EnumPositionName positionName) {
        this.positionName = positionName;
    }
    public Position(byte positionID, EnumPositionName positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }


}
