package com.example.menuintro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesClass> {

    MainActivity mainActivity;
    int[] images;

    int status;
    public ImagesAdapter(MainActivity mainActivity, int[] images,int status) {
        this.mainActivity = mainActivity;
        this.images = images;
        this.status=status;
    }

    @NonNull
    @Override
    public ImagesAdapter.ImagesClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;

        if(status==2)
        {
            view = LayoutInflater.from(mainActivity).inflate(R.layout.listview_items_layout,parent,false);
        }
        else
        {
            view = LayoutInflater.from(mainActivity).inflate(R.layout.gridview_items_layout,parent,false);
        }

        ImagesClass imagesClass = new ImagesClass(view);

        return imagesClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesAdapter.ImagesClass holder, int position) {

        holder.imageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ImagesClass extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ImagesClass(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);

        }
    }
}
