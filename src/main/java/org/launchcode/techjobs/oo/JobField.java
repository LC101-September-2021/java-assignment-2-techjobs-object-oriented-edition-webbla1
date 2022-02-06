package org.launchcode.techjobs.oo;

public abstract class JobField {
    //common variables
    private int id;
    private static int nextId = 1;
    private String value;

    //constructors
    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }


    //methods
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return id;
    }


    //getters and setters
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
