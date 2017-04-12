package xyz.aufa.asistenkuliahku.opRealm;

import android.util.Log;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import xyz.aufa.asistenkuliahku.ModelClass.jkO;
import xyz.aufa.asistenkuliahku.SessionManager.SessionManager;

/**
 * Created by SENSODYNE on 09/04/2017.
 */

public class jkOP {
    private static String TAG = jkOP.class.getSimpleName();
    RealmBaseActivity rba;
    Realm realm;
    jkO jk;

    public void tambahJadwalKuliah(final jkO jkO){
        realm = Realm.getDefaultInstance();
        realm.getConfiguration();
        realm.beginTransaction();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.createObject(jkO.class, getNextId());
            }
        }, new Realm.Transaction.OnSuccess(){
            public void onSuccess(){
                Log.d(TAG, "Berhasil Menyimpan Data Di Realm");
            }
        });
        realm.commitTransaction();
    }
    public int getNextId() {
        realm = Realm.getDefaultInstance();
        Number currentID = realm.where(jkO.class).max("no_jk");
        int nextID;
        if (currentID == null){
            nextID = 1;
        }else{
            nextID = currentID.intValue() + 1;
        }
        return nextID;
    }
    public RealmResults<jkO> getAllJadwalKuliah(){
        return realm.where(jkO.class).findAll();
    }

    public int getLastId(){
        realm.getDefaultInstance();
        int lastID;
        Number number = realm.where(jkO.class).max("no_jk");
        lastID = number.intValue();
    }

}
