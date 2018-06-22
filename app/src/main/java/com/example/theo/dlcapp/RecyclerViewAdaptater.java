package com.example.theo.dlcapp;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.theo.dlcapp.Model.SimulateurLumière;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

interface ItemClickListener{
    void onClick(View view, int position);
}

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView nom_lum ;
    public TextView etat_lum;
    public Switch switch_lum;
    public SeekBar intensity_lum;

    private ItemClickListener itemClickListener;



    @RequiresApi(api = Build.VERSION_CODES.O)
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        nom_lum = (TextView)itemView.findViewById(R.id.nom_lum);
        etat_lum = (TextView)itemView.findViewById(R.id.etat_lum);
        switch_lum = (Switch) itemView.findViewById(R.id.switch_lum);
        intensity_lum = (SeekBar)itemView.findViewById(R.id.intensity_lum);
        intensity_lum.setMin(0);
        intensity_lum.setMax(100);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }



    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition());

    }


}

public class RecyclerViewAdaptater extends RecyclerView.Adapter<RecyclerViewHolder>{

    private List<SimulateurLumière> list_lum = new ArrayList<>();
    private Context context;

    public RecyclerViewAdaptater(List<SimulateurLumière> list_lum) {
        this.list_lum = list_lum;
    }

    @Override
    public int getItemCount() {
        return list_lum.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_lum,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        holder.nom_lum.setText(list_lum.get(position).getNom());
        holder.etat_lum.setText(list_lum.get(position).getIs_on().toString());

        holder.switch_lum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(position);
            }
        });

        holder.setItemClickListener(new ItemClickListener(){
            @Override
            public void onClick(View view, int position) {
                list_lum.get(position).inverser();
                System.out.println(position);

            }
        });

        holder.intensity_lum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                System.out.println(progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
