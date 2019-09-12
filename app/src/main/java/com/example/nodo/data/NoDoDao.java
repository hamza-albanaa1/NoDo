package com.example.nodo.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.nodo.model.NoDO;

import java.util.List;

@Dao
public interface NoDoDao {

    //CRUD
    @Insert
    void insert(NoDO noDO);


    @Query("DELETE FROM nodo_table")
    void deleteAll();






    @Query("DELETE FROM nodo_table Where id = :id")
    int deleteANoDo(int id);



    @Query("UPDATE nodo_table SET nodo_col = :nodoText WHERE id =:id")
    int updateNoDoItem(int id, String nodoText);





    @Query("SELECT * FROM nodo_table ORDER BY nodo_col DESC ")
    LiveData<List<NoDO>> getAllNoDos();
}
