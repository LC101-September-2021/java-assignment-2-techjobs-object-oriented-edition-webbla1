package org.launchcode.techjobs.oo;

import java.util.Objects;

public class CoreCompetency extends JobField {


    public CoreCompetency() {
        super();
    }

    public CoreCompetency(String value) {
        super(value);
    }

    // Custom equals method:


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoreCompetency)) return false;
        CoreCompetency that = (CoreCompetency) o;
        return this.getId() == that.getId();
    }


    // TODO: Use the "Generate" tool to add a getter and setter for the 'value' field but
    //  ONLY a getter for the 'id' field.


}
