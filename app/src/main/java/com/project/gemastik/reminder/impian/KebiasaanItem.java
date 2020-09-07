package com.project.gemastik.reminder.impian;

import java.io.Serializable;

public class KebiasaanItem implements Serializable {

    private String textHabits;

    public KebiasaanItem() {

    }

    public String getTextHabits() {
        return textHabits;
    }

    public void setTextHabits(String textHabits) {
        this.textHabits = textHabits;
    }

    public KebiasaanItem(String textHabits) {
        this.textHabits = textHabits;
    }
}
