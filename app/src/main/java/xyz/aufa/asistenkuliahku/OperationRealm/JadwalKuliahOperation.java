package xyz.aufa.asistenkuliahku.OperationRealm;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;
import xyz.aufa.asistenkuliahku.ModelClass.JadwalKuliahModel;

/**
 * Created by SENSODYNE on 09/04/2017.
 */

public class JadwalKuliahOperation {
    private static String TAG = JadwalKuliahOperation.class.getSimpleName();
    RealmBaseActivity rba;
    Realm realm;
    JadwalKuliahModel jk;

    public void tambahJadwalKuliah(final JadwalKuliahModel JadwalKuliahModel){
        realm = Realm.getDefaultInstance();
        realm.getConfiguration();
        realm.beginTransaction();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.createObject(JadwalKuliahModel.class, getNextId());
            }
        }, new Realm.Transaction.OnSuccess(){
            public void onSuccess(){
                Log.d(TAG, "Berhasil Menyimpan Data Di Realm");
                Log.d(TAG,"Path : "+realm.getPath());
            }
        });
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
