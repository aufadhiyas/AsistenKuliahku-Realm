package xyz.aufa.asistenkuliahku.ModelClass;

import io.realm.RealmObject;

/**
 * Created by SENSODYNE on 15/04/2017.
 */

public class JadwalUjianModel extends RealmObject{

    private int no_ju;
    private String nama_makul;
    private String waktu;
    private String jenis;
    private String deskripsi;
    private String ruangan;
    private int status_ju;
    private String Author;
    private String created_at;
    private String updated_at;

    public JadwalUjianModel() {
    }

    public JadwalUjianModel(int no_ju, String Jenis, String nama_makul, String waktu, String deskripsi, String ruangan, int status_ju, String author, String created_at, String updated_at) {
        this.no_ju = no_ju;
        this.jenis = Jenis;
        this.nama_makul = nama_makul;
        this.waktu = waktu;
        this.deskripsi = deskripsi;
        this.ruangan = ruangan;
        this.status_ju = status_ju;
        Author = author;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getNo_ju() {
        return no_ju;
    }

    public void setNo_ju(int no_ju) {
        this.no_ju = no_ju;
    }

    public String getNama_makul() {
        return nama_makul;
    }

    public void setNama_makul(String nama_makul) {
        this.nama_makul = nama_makul;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public int getStatus_ju() {
        return status_ju;
    }

    public void setStatus_ju(int status_ju) {
        this.status_ju = status_ju;
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
}
