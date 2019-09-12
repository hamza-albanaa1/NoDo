package com.example.nodo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nodo.R;
import com.example.nodo.model.NoDO;

import java.util.List;
import java.util.zip.Inflater;

public class NoDoListAdapter extends RecyclerView.Adapter <NoDoListAdapter.NoDoViewHolder>{

   private final LayoutInflater noDoInflater;
   private List<NoDO> noDOList;






    public NoDoListAdapter(Context context) {
       noDoInflater = LayoutInflater.from(context);
    }










    @NonNull
    @Override
    public NoDoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        View view = noDoInflater.inflate(R.layout.recyclerview_item,viewGroup,false);





        return new NoDoViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull NoDoViewHolder holder, int position) {
        if(noDOList !=null) {
            NoDO current = noDOList.get(position);
            holder.noDoTextView.setText(current.getNoDo());
        }else {
            holder.noDoTextView.setText(R.string.no_todo);
        }

    }



   public void setNoDo(List<NoDO>noDos){
        noDOList = noDos;
       notifyDataSetChanged();
    }







    @Override
    public int getItemCount() {
        if(noDOList !=null)
        return noDOList.size();
        else return 0;
    }










    public class NoDoViewHolder extends RecyclerView.ViewHolder{
        public TextView noDoTextView;
        public NoDoViewHolder(@NonNull View itemView) {
            super(itemView);
            noDoTextView = itemView.findViewById(R.id.textView);
        }
    }
}
