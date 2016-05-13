package com.beliautopart.beliautopart.model;

/**
 * Created by brandon on 13/05/16.
 */
public class ItemProduk {
    private int idItem;
    private String namaItem;
    private int sts;
    private double harga;
    private String kompatibel;
    private String kode;
    private String foto;


    public ItemProduk(int idItem, String namaItem, int sts, double harga, String kompatibel, String kode, String foto) {
        this.idItem = idItem;
        this.namaItem = namaItem;
        this.sts = sts;
        this.harga = harga;
        this.kompatibel = kompatibel;
        this.kode = kode;
        this.foto = foto;
    }


    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public int getSts() {
        return sts;
    }

    public void setSts(int sts) {
        this.sts = sts;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getKompatibel() {
        return kompatibel;
    }

    public void setKompatibel(String kompatibel) {
        this.kompatibel = kompatibel;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
