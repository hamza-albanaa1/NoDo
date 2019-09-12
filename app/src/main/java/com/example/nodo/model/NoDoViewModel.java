package com.example.nodo.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nodo.util.NoDoRep;

import java.util.List;

public class NoDoViewModel extends AndroidViewModel {
    private NoDoRep noDoRep;
    private LiveData<List<NoDO>> allnodos;
    public NoDoViewModel(@NonNull Application application) {
        super(application);


        noDoRep = new NoDoRep(application);
        allnodos = noDoRep.getAllNoDos();

    }

    public LiveData<List<NoDO>>getAllnodos(){
        return allnodos;
    }

    public void insert(NoDO noDO){
        NoDoRep.insert(noDO);
    }
}
