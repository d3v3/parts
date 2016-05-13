package com.beliautopart.beliautopart.model;

/**
 * Created by brandon on 12/05/16.
 */
public class SearchOptionModel {
    private String keyword = "";
    private Integer kat = null;
    private Integer jenis = null;
    private Integer merk = null;
    private Integer tipe = null;
    private Integer katItem = null;

    public SearchOptionModel() {
    }

    public SearchOptionModel(String keyword, int kat, int jenis, int merk, int tipe, int katItem) {
        this.keyword = keyword;
        this.kat = kat;
        this.jenis = jenis;
        this.merk = merk;
        this.tipe = tipe;
        this.katItem = katItem;
    }

    public Integer getKatItem() {
        return katItem;
    }

    public void setKatItem(Integer katItem) {
        this.katItem = katItem;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getKat() {
        return kat;
    }

    public void setKat(Integer kat) {
        this.kat = kat;
    }

    public Integer getJenis() {
        return jenis;
    }

    public void setJenis(Integer jenis) {
        this.jenis = jenis;
    }

    public Integer getMerk() {
        return merk;
    }

    public void setMerk(Integer merk) {
        this.merk = merk;
    }

    public Integer getTipe() {
        return tipe;
    }

    public void setTipe(Integer tipe) {
        this.tipe = tipe;
    }
}
