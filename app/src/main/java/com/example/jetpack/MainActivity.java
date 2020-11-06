package com.example.jetpack;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String[] names;
    private static setDt data;
    public static String GLOBAL_CONSTANT_IMAGE_NAME;
    public static String GLOBAL_CONSTANT_IMAGE;
    public static String GLOBAL_CONSTANT_POSITION;
    private static int[] vi;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Toast.makeText(getApplicationContext(), "Tap On The Cards To View The Information", Toast.LENGTH_LONG).show();
         initData(this);
         scrollerForData(this);
    }


    private void scrollerForData(Context context) {
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(context);
        adapter = new Adapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(30);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        adapter.setOnItemClickListner(position -> {
            Intent intent = new Intent(getApplicationContext(), product_descrp.class);
            GLOBAL_CONSTANT_IMAGE_NAME = data.getImageNameAtPosition(position);
            GLOBAL_CONSTANT_IMAGE = Integer.toString(data.getImageAtPosition(position));
            intent.putExtra(GLOBAL_CONSTANT_IMAGE_NAME, data.getImageNameAtPosition(position));
            intent.putExtra(GLOBAL_CONSTANT_IMAGE, data.getImageAtPosition(position));
            intent.putExtra(GLOBAL_CONSTANT_POSITION, position);
            startActivity(intent);
        });
    }
    private void initData(Context context) {
        data = new setDt(context);
        names =  data.getImageNames();
        vi = data.getImageViews();
    }
    private static class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
       public onClickListener MClickListener;
        public interface onClickListener{
           void onClick(int position);
       }
       public void setOnItemClickListner(onClickListener clickListner){
           MClickListener = clickListner;
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
                itemView.setOnClickListener(v -> {
                    if(MClickListener!=null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            MClickListener.onClick(position);
                        }
                    }
                });
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

