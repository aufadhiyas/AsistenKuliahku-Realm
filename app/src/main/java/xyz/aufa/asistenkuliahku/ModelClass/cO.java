package xyz.aufa.asistenkuliahku.ModelClass;

/**
 * Created by SENSODYNE on 08/04/2017.
 */

public class cO {

    private String no_c;
    private String uid;
    private String nama_c;
    private String deskripsi_c;
    private String attlink_c;
    private String waktu_c;
    private String created_at;
    private String updated_at;
    private String noonline_c;

    public cO(String no_c, String uid, String nama_c, String deskripsi_c, String attlink_c, String waktu_c, String created_at, String updated_at, String noonline_c) {
        this.no_c = no_c;
        this.uid = uid;
        this.nama_c = nama_c;
        this.deskripsi_c = deskripsi_c;
        this.attlink_c = attlink_c;
        this.waktu_c = waktu_c;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.noonline_c = noonline_c;
    }

    public String getNo_c() {
        return no_c;
    }

    public void setNo_c(String no_c) {
        this.no_c = no_c;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNama_c() {
        return nama_c;
    }

    public void setNama_c(String nama_c) {
        this.nama_c = nama_c;
    }

    public String getDeskripsi_c() {
        return deskripsi_c;
    }

    public void setDeskripsi_c(String deskripsi_c) {
        this.deskripsi_c = deskripsi_c;
    }

    public String getAttlink_c() {
        return attlink_c;
    }

    public void setAttlink_c(String attlink_c) {
        this.attlink_c = attlink_c;
    }

    public String getWaktu_c() {
        return waktu_c;
    }

    public void setWaktu_c(String waktu_c) {
        this.waktu_c = waktu_c;
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

    public String getNoonline_c() {
        return noonline_c;
    }

    public void setNoonline_c(String noonline_c) {
        this.noonline_c = noonline_c;
    }
}
