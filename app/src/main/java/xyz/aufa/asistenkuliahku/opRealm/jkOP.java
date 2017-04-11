package xyz.aufa.asistenkuliahku.opRealm;

import io.realm.Realm;
import io.realm.RealmResults;
import xyz.aufa.asistenkuliahku.ModelClass.jkO;

/**
 * Created by SENSODYNE on 09/04/2017.
 */

public class jkOP {
    Realm realm;
    jkO jk;

    public void tambahJadwalKuliah(final jkO jkO){
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(jkO);
            }
        });

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


}
