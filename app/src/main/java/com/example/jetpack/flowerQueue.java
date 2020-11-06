package com.example.jetpack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class flowerQueue extends Fragment {
private RecyclerView StockRecyclerView;
private RecyclerView.Adapter adapter;
private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.queue, container, false);
        StockRecyclerView = view.findViewById(R.id.stock_recycler);
        layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new Adapter();
        StockRecyclerView.setLayoutManager(layoutManager);
        StockRecyclerView.setAdapter(adapter);
         StockRecyclerView.setHasFixedSize(true);
         StockRecyclerView.setItemViewCacheSize(20);
         StockRecyclerView.setDrawingCacheEnabled(true);
         StockRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        return view;
    }
    private class Adapter extends RecyclerView.Adapter<Adapter.Holder>{
        private String[] names;
        private int[] vi;
        private setDt data;
        public Adapter() {
         data = new setDt(getContext());
        names =  data.getImageNames();
        vi = data.getImageViews();
    }
        @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_act_lay, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setData(position);
    }
    @Override
    public int getItemCount() {
        return names.length;
    }

    private class Holder extends RecyclerView.ViewHolder{
        public ImageView im;
        public TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.imageView_main);
            textView = itemView.findViewById(R.id.image_name_main);
        }
        public void setData(int position) {
            try {
                im.setImageResource(vi[position]);
                textView.setText(names[position]);
            }catch (Exception e){

            }
        }
        }
}
}