package com.project.gemastik.reminder.impian;

import java.util.List;

public class ImpianItem {

    private String txImpian;
    private List<KebiasaanItem> itemList;

    public String getTxImpian() {
        return txImpian;
    }

    public void setTxImpian(String txImpian) {
        this.txImpian = txImpian;
    }

    public List<KebiasaanItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<KebiasaanItem> itemList) {
        this.itemList = itemList;
    }

    public ImpianItem(String txImpian, List<KebiasaanItem> itemList) {
        this.txImpian = txImpian;
        this.itemList = itemList;
    }
}
