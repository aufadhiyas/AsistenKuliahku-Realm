package xyz.aufa.asistenkuliahku.ModelClass;

import io.realm.RealmObject;

/**
 * Created by SENSODYNE on 28/03/2017.
 */

public class userO extends RealmObject{
    public static final String TAG = userO.class.getSimpleName();
    public static final String TABLE_USER= "user";




    private String id;
    private String uid;
    private String nama;
    private String email;
    private String password;
    private String kode_verifikasi,status_verifikasi;
    private String universitas;
    private String jurusan;
    private String kelas;
    private String lokasi;
    private String tanggal_lahir;
    private String created_at;
    private String updated_at;
    private String sync_at;
    private String no_online;

    public userO() {
    }

    public userO(String id, String uid, String nama, String email, String password, String kode_verifikasi, String status_verifikasi, String universitas, String jurusan, String kelas, String lokasi, String tanggal_lahir, String created_at, String updated_at, String sync_at, String no_online) {
        this.id = id;
        this.uid = uid;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.kode_verifikasi = kode_verifikasi;
        this.status_verifikasi = status_verifikasi;
        this.universitas = universitas;
        this.jurusan = jurusan;
        this.kelas = kelas;
        this.lokasi = lokasi;
        this.tanggal_lahir = tanggal_lahir;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.sync_at = sync_at;
        this.no_online = no_online;
    }

    public userO(String id, String uid, String nama, String email, String password, String kode_verifikasi, String status_verifikasi) {
        this.id = id;
        this.uid = uid;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.kode_verifikasi = kode_verifikasi;
        this.status_verifikasi = status_verifikasi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKode_verifikasi() {
        return kode_verifikasi;
    }

    public void setKode_verifikasi(String kode_verifikasi) {
        this.kode_verifikasi = kode_verifikasi;
    }

    public String getStatus_verifikasi() {
        return status_verifikasi;
    }

    public void setStatus_verifikasi(String status_verifikasi) {
        this.status_verifikasi = status_verifikasi;
    }

    public String getUniversitas() {
        return universitas;
    }

    public void setUniversitas(String universitas) {
        this.universitas = universitas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
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

    public String getSync_at() {
        return sync_at;
    }

    public void setSync_at(String sync_at) {
        this.sync_at = sync_at;
    }

    public String getNo_online() {
        return no_online;
    }

    public void setNo_online(String no_online) {
        this.no_online = no_online;
    }
}
