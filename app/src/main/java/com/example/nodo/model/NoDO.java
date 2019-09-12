package com.example.nodo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;




@Entity(tableName = "nodo_table")



public class NoDO {



    @PrimaryKey(autoGenerate = true)
    private int id;



    @NonNull
    @ColumnInfo(name = "nodo_col")
    private String noDo;





    public NoDO(@NonNull String noDo) {
        this.noDo = noDo;
    }

    public String getNoDo() {
        return noDo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNoDo(@NonNull String noDo) {
        this.noDo = noDo;
    }
}
