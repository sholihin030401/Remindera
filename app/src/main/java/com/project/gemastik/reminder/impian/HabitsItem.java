package com.project.gemastik.reminder.impian;

import java.io.Serializable;

public class HabitsItem implements Serializable {
    private String textHabits;

    public HabitsItem() {

    }


    public String getTextHabits() {
        return textHabits;
    }

    public void setTextHabits(String textHabits) {
        this.textHabits = textHabits;
    }

    public HabitsItem(String textHabits) {
        this.textHabits = textHabits;
    }
}