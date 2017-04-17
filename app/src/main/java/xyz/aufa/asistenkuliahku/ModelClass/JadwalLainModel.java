package xyz.aufa.asistenkuliahku.ModelClass;

import io.realm.RealmObject;

/**
 * Created by SENSODYNE on 08/04/2017.
 */

public class JadwalLainModel extends RealmObject {
    private String no_jl;
    private String nama_jl;
    private String waktus_jl;
    private String waktuf_jl;
    private String tempat_jl;
    private String deskripsi_jl;
    private String akumulasi_jl;
    private String status_jl;
    private String Author;
    private String created_at;
    private String updated_at;
    private String noonline_jl;

    public JadwalLainModel() {
    }

    public JadwalLainModel(String no_jl, String nama_jl, String waktus_jl, String waktuf_jl, String tempat_jl, String deskripsi_jl, String akumulasi_jl, String status_jl, String author, String created_at, String updated_at, String noonline_jl) {
        this.no_jl = no_jl;
        this.nama_jl = nama_jl;
        this.waktus_jl = waktus_jl;
        this.waktuf_jl = waktuf_jl;
        this.tempat_jl = tempat_jl;
        this.deskripsi_jl = deskripsi_jl;
        this.akumulasi_jl = akumulasi_jl;
        this.status_jl = status_jl;
        Author = author;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.noonline_jl = noonline_jl;
    }

    public String getNo_jl() {
        return no_jl;
    }

    public void setNo_jl(String no_jl) {
        this.no_jl = no_jl;
    }

    public String getNama_jl() {
        return nama_jl;
    }

    public void setNama_jl(String nama_jl) {
        this.nama_jl = nama_jl;
    }

    public String getWaktus_jl() {
        return waktus_jl;
    }

    public void setWaktus_jl(String waktus_jl) {
        this.waktus_jl = waktus_jl;
    }

    public String getWaktuf_jl() {
        return waktuf_jl;
    }

    public void setWaktuf_jl(String waktuf_jl) {
        this.waktuf_jl = waktuf_jl;
    }

    public String getTempat_jl() {
        return tempat_jl;
    }

    public void setTempat_jl(String tempat_jl) {
        this.tempat_jl = tempat_jl;
    }

    public String getDeskripsi_jl() {
        return deskripsi_jl;
    }

    public void setDeskripsi_jl(String deskripsi_jl) {
        this.deskripsi_jl = deskripsi_jl;
    }

    public String getAkumulasi_jl() {
        return akumulasi_jl;
    }

    public void setAkumulasi_jl(String akumulasi_jl) {
        this.akumulasi_jl = akumulasi_jl;
    }

    public String getStatus_jl() {
        return status_jl;
    }

    public void setStatus_jl(String status_jl) {
        this.status_jl = status_jl;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getNoonline_jl() {
        return noonline_jl;
    }

    public void setNoonline_jl(String noonline_jl) {
        this.noonline_jl = noonline_jl;
    }
}
