package com.beliautopart.beliautopart.model;

/**
 * Created by brandon on 12/05/16.
 */
public class SearchOptionModel {
    private String keyword;
    private int kat;
    private int jenis;
    private int merk;
    private int tipe;
    private int katItem;

    public SearchOptionModel(String keyword, int kat, int jenis, int merk, int tipe, int katItem) {
        this.keyword = keyword;
        this.kat = kat;
        this.jenis = jenis;
        this.merk = merk;
        this.tipe = tipe;
        this.katItem = katItem;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getKat() {
        return kat;
    }

    public void setKat(int kat) {
        this.kat = kat;
    }

    public int getJenis() {
        return jenis;
    }

    public void setJenis(int jenis) {
        this.jenis = jenis;
    }

    public int getMerk() {
        return merk;
    }

    public void setMerk(int merk) {
        this.merk = merk;
    }

    public int getTipe() {
        return tipe;
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }

    public int getKatItem() {
        return katItem;
    }

    public void setKatItem(int kat_item) {
        this.katItem = kat_item;
    }
}
