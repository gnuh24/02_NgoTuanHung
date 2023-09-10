package org.example.entity;

public class EX3_Student<T> {


        private T id;
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setId(T id) {
            this.id = id;
        }

        public T getId() {
            return id;
        }

        public EX3_Student(T id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString(){
            return  "(" + this.id + " " + this.name + ")";
        }

}
