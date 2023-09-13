package org.example.entity;

public class Car
{
    private String name;
    private String type;
    public Car(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getEn(){
        Engine e = new Engine("C");
        return e.getEngineType();
    }

    public class Engine extends CPU{
        private String engineType;
        public String getEngineType() {
            return engineType;
        }

        public void setEngineType(String engineType) {
            this.engineType = engineType;
        }

        public Engine(String engineType){
            this.engineType = engineType;
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
