package me.citrafa.asistenkuliahku.ModelClass;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by SENSODYNE on 08/04/2017.
 */

public class JadwalLainModel extends RealmObject {

    @PrimaryKey
    private int no_jl;

    private String nama_jl;
    private Date waktus_jl;
    private Date waktuf_jl;
    private String tempat_jl;
    private String deskripsi_jl;
    private int status_jl;
    private String Author;
    private String created_at;
    private String updated_at;
    private String noonline_jl;

    public JadwalLainModel() {
    }

    public JadwalLainModel(int no_jl, String nama_jl, Date waktus_jl, Date waktuf_jl, String tempat_jl, String deskripsi_jl, int status_jl, String author, String created_at, String updated_at, String noonline_jl) {
        this.no_jl = no_jl;
        this.nama_jl = nama_jl;
        this.waktus_jl = waktus_jl;
        this.waktuf_jl = waktuf_jl;
        this.tempat_jl = tempat_jl;
        this.deskripsi_jl = deskripsi_jl;
        this.status_jl = status_jl;
        Author = author;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.noonline_jl = noonline_jl;
    }

    public int getNo_jl() {
        return no_jl;
    }

    public void setNo_jl(int no_jl) {
        this.no_jl = no_jl;
    }

    public String getNama_jl() {
        return nama_jl;
    }

    public void setNama_jl(String nama_jl) {
        this.nama_jl = nama_jl;
    }

    public Date getWaktus_jl() {
        return waktus_jl;
    }

    public void setWaktus_jl(Date waktus_jl) {
        this.waktus_jl = waktus_jl;
    }

    public Date getWaktuf_jl() {
        return waktuf_jl;
    }

    public void setWaktuf_jl(Date waktuf_jl) {
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



    public int getStatus_jl() {
        return status_jl;
    }

    public void setStatus_jl(int status_jl) {
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
