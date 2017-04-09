package xyz.aufa.asistenkuliahku.ModelClass;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by SENSODYNE on 08/04/2017.
 */

public class jkO extends RealmObject{
    private static final AtomicInteger count = new AtomicInteger(0);

    @PrimaryKey
    private int no_jk;

    private String hari_jk;
    private String waktu_jk;
    private String ruangan_jk;
    private String makul_jk;
    private String dosen_jk;
    private String kelas_jk, created_at, updated_at;
    private String Author;
    private int noonline_j;

    public int getNo_jk() {
        return no_jk;
    }

    public void setNo_jk(int no_jk) {
        this.no_jk = no_jk;
    }

    public String getHari_jk() {
        return hari_jk;
    }

    public void setHari_jk(String hari_jk) {
        this.hari_jk = hari_jk;
    }

    public String getWaktu_jk() {
        return waktu_jk;
    }

    public void setWaktu_jk(String waktu_jk) {
        this.waktu_jk = waktu_jk;
    }

    public String getRuangan_jk() {
        return ruangan_jk;
    }

    public void setRuangan_jk(String ruangan_jk) {
        this.ruangan_jk = ruangan_jk;
    }

    public String getMakul_jk() {
        return makul_jk;
    }

    public void setMakul_jk(String makul_jk) {
        this.makul_jk = makul_jk;
    }

    public String getDosen_jk() {
        return dosen_jk;
    }

    public void setDosen_jk(String dosen_jk) {
        this.dosen_jk = dosen_jk;
    }

    public String getKelas_jk() {
        return kelas_jk;
    }

    public void setKelas_jk(String kelas_jk) {
        this.kelas_jk = kelas_jk;
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
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getNoonline_j() {
        return noonline_j;
    }

    public void setNoonline_j(int noonline_j) {
        this.noonline_j = noonline_j;
    }
}
