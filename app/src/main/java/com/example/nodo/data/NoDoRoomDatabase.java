package com.example.nodo.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.nodo.model.NoDO;

@Database(entities = {NoDO.class},version = 1)

public abstract class  NoDoRoomDatabase extends RoomDatabase {

    public static volatile NoDoRoomDatabase  INSTANCE;

    public abstract NoDoDao noDoDao();

    public static NoDoRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (NoDoRoomDatabase.class){
                if (INSTANCE == null ){


                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoDoRoomDatabase.class,"nodo_database")
                            .addCallback(roomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }











    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private final NoDoDao noDoDao;

        public PopulateDbAsync(NoDoRoomDatabase db) {
            noDoDao =db.noDoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

          noDoDao.deleteAll();
            NoDO noDO = new NoDO("Not waste your time ");
            noDoDao.insert(noDO);
            noDO = new NoDO("No Do bad  things ");
            noDoDao.insert(noDO);
            return null;
        }
    }
}
