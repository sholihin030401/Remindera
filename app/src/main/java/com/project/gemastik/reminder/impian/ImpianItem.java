package com.project.gemastik.reminder.impian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImpianItem {

    private String txImpian;
    private ArrayList<HabitsItem> itemList;

    public String getTxImpian() {
        return txImpian;
    }

    public void setTxImpian(String txImpian) {
        this.txImpian = txImpian;
    }

    public ArrayList<HabitsItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<HabitsItem> itemList) {
        this.itemList = itemList;
    }

    public ImpianItem() {
        this.txImpian = txImpian;
        this.itemList = itemList;
    }
}
