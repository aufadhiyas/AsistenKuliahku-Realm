package me.citrafa.asistenkuliahku.ModelClass;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by SENSODYNE on 08/04/2017.
 */

public class TugasModel extends RealmObject{
    @PrimaryKey
    private String no_t;

    private String deskripsi_t;
    private String attlink_t;
    private String waktu_t;
    private String dosen_t;
    private String status_t;
    private String created_at;
    private String updated_at;
    private String author;
    private String noonline_t;

    public TugasModel() {
    }

    public TugasModel(String no_t, String deskripsi_t, String attlink_t, String waktu_t, String dosen_t, String status_t, String created_at, String updated_at, String author, String noonline_t) {
        this.no_t = no_t;
        this.deskripsi_t = deskripsi_t;
        this.attlink_t = attlink_t;
        this.waktu_t = waktu_t;
        this.dosen_t = dosen_t;
        this.status_t = status_t;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.author = author;
        this.noonline_t = noonline_t;
    }

    public String getNo_t() {
        return no_t;
    }

    public void setNo_t(String no_t) {
        this.no_t = no_t;
    }

    public String getDeskripsi_t() {
        return deskripsi_t;
    }

    public void setDeskripsi_t(String deskripsi_t) {
        this.deskripsi_t = deskripsi_t;
    }

    public String getAttlink_t() {
        return attlink_t;
    }

    public void setAttlink_t(String attlink_t) {
        this.attlink_t = attlink_t;
    }

    public String getWaktu_t() {
        return waktu_t;
    }

    public void setWaktu_t(String waktu_t) {
        this.waktu_t = waktu_t;
    }

    public String getDosen_t() {
        return dosen_t;
    }

    public void setDosen_t(String dosen_t) {
        this.dosen_t = dosen_t;
    }

    public String getStatus_t() {
        return status_t;
    }

    public void setStatus_t(String status_t) {
        this.status_t = status_t;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNoonline_t() {
        return noonline_t;
    }

    public void setNoonline_t(String noonline_t) {
        this.noonline_t = noonline_t;
    }
}
