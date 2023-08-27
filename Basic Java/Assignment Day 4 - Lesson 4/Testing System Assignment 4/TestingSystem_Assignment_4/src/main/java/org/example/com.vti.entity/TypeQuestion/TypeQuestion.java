package org.example.com.vti.entity.TypeQuestion;

public class TypeQuestion {
    private byte typeID;
    private EnumTypeName typeName;

    public TypeQuestion(byte typeID, EnumTypeName typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }
}
