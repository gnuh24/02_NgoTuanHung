package org.example.entity;

public class Phone <K, V> extends MyMap <K, V>{


    public Phone(K key, V value) {
        super(key, value);
    }

    @Override
    public K getKey() {
        return super.getKey();
    }

    public V getPhoneNumber(){
        return super.getValue();
    }
}
