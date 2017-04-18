package me.citrafa.asistenkuliahku.OperationRealm;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;
import me.citrafa.asistenkuliahku.ModelClass.JadwalKuliahModel;

/**
 * Created by SENSODYNE on 09/04/2017.
 */

public class JadwalKuliahOperation {
    private static String TAG = JadwalKuliahOperation.class.getSimpleName();
    RealmBaseActivity rba;
    Realm realm;
    JadwalKuliahModel jk;

    public void tambahJadwalKuliah(final JadwalKuliahModel obj){
        realm = Realm.getDefaultInstance();

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(obj);
            }
        }, new Realm.Transaction.OnSuccess() {
            public void onSuccess() {
                Log.d(TAG, "Berhasil Menyimpan Data Di Realm");
                Log.d(TAG, "Path : " + realm.getPath());
            }
        });
        realm.beginTransaction();
        realm.commitTransaction();
    }
    public int getNextId() {
        realm = Realm.getDefaultInstance();
        Number currentID = realm.where(JadwalKuliahModel.class).max("no_jk");
        int nextID;
        if (currentID == null){
            nextID = 1;
        }else{
            nextID = currentID.intValue() + 1;
        }
        return nextID;
    }
    public RealmResults<JadwalKuliahModel> getAllJadwalKuliah(){
        return realm.where(JadwalKuliahModel.class).findAll();
    }

    public int getLastId(){
        realm.getDefaultInstance();
        int lastID;
        Number number = realm.where(JadwalKuliahModel.class).max("no_jk");
        lastID = number.intValue();
        return lastID;

    }

}
