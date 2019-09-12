package com.example.nodo.util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import com.example.nodo.data.NoDoDao;
import com.example.nodo.data.NoDoRoomDatabase;
import com.example.nodo.model.NoDO;

import java.util.List;

public class NoDoRep {
    private static NoDoDao noDoDao;
    private LiveData<List<NoDO>> allNoDos;



    public NoDoRep(Application application) {
        NoDoRoomDatabase db = NoDoRoomDatabase.getDatabase(application);
        noDoDao = db.noDoDao();
        allNoDos = noDoDao.getAllNoDos();

    }


    public LiveData<List<NoDO>>getAllNoDos(){
        return allNoDos;
    }



    public static void insert(NoDO noDO){
        new insertAsyncTask(noDoDao).execute(noDO);
    }






    private static class insertAsyncTask extends AsyncTask<NoDO,Void,Void> {
        private NoDoDao asyncTaskDao;
        public insertAsyncTask(NoDoDao dao) {
            asyncTaskDao = dao ;
        }

        @Override
        protected Void doInBackground(NoDO... params) {

            asyncTaskDao.insert(params[0]);

            return null;
        }
    }
}
