package com.octohub.pil4u.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.CustomGallery;

import java.util.ArrayList;

public class ImageListRecyclerAdapter  extends RecyclerView.Adapter<ImageListRecyclerAdapter.MYVIEWHOLDER>{

    private final Context mContext;
    private final ImageLoader imageLoader;
    private final DisplayImageOptions imageOptions;
    public ArrayList<CustomGallery> mItems = new ArrayList<>();
    private boolean isActionMultiplePick;

    public EventListener mEventListener;

    public ImageListRecyclerAdapter(Context mContext) {
        this.mContext = mContext;

        imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext).build();
        imageLoader.init(config);
        imageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .showImageOnLoading(R.drawable.no_media)
                .showImageForEmptyUri(R.drawable.no_media)
                .showImageOnFail(R.drawable.no_media)
                .build();
    }

    public boolean isMultiSelected() {
        return isActionMultiplePick;
    }



    public interface EventListener {
        public void onItemClickListener(int position, MYVIEWHOLDER v);
    }

    public ArrayList<CustomGallery> getSelected() {
        ArrayList<CustomGallery> dataT = new ArrayList<CustomGallery>();

        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).isSeleted) {
                dataT.add(mItems.get(i));
            }
        }

        return dataT;
    }

    public void addAll(ArrayList<CustomGallery> files) {

        try {
            this.mItems.clear();
            this.mItems.addAll(files);

        } catch (Exception e) {
            e.printStackTrace();
        }

        notifyDataSetChanged();
    }

    public void changeSelection(MYVIEWHOLDER v, int position) {

        if (mItems.get(position).isSeleted) {
            mItems.get(position).isSeleted = false;
        } else {
            mItems.get(position).isSeleted = true;
        }
        v.imgQueueMultiSelected.setSelected(mItems.get(position).isSeleted);
        //((ImageListRecyclerAdapter.VerticalItemHolder) v.getTag()).imgQueueMultiSelected.setSelected(mItems.get(position).isSeleted);
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public void setMultiplePick(boolean isMultiplePick) {
        this.isActionMultiplePick = isMultiplePick;
    }

    @NonNull
    @Override
    public MYVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.image_picker_rec, parent, false);
        return new MYVIEWHOLDER(root, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final MYVIEWHOLDER holder, final int position) {

        CustomGallery item = mItems.get(position);

//        imageLoader.displayImage(item.sdcardPath, holder.imgQueue);

        holder.setImage(item.sdcardPath);

        if (isActionMultiplePick) {
            holder.imgQueueMultiSelected.setVisibility(View.VISIBLE);
        } else {
            holder.imgQueueMultiSelected.setVisibility(View.GONE);
        }
        if (isActionMultiplePick) {

            holder.imgQueueMultiSelected
                    .setSelected(item.isSeleted);

        }
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEventListener != null) {
                    mEventListener.onItemClickListener(position, holder);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public CustomGallery getItem(int position) {
        return mItems.get(position);
    }

    public class MYVIEWHOLDER extends RecyclerView.ViewHolder {
        ImageView imgQueue;
        ImageView imgQueueMultiSelected;
        View container;

        public MYVIEWHOLDER(View itemView, ImageListRecyclerAdapter adapter) {
            super(itemView);

            imgQueue = itemView.findViewById(R.id.imgQueue);
            imgQueueMultiSelected = itemView.findViewById(R.id.imgQueueMultiSelected);
            container = itemView.findViewById(R.id.container);
        }

        public void setImage(String url) {
            imageLoader.displayImage("file://" + url,
                    imgQueue, new SimpleImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String imageUri, View view) {
                            imgQueue
                                    .setImageResource(R.drawable.no_media);
                            super.onLoadingStarted(imageUri, view);
                        }
                    });
        }
    }

    public void setEventListner(EventListener eventListner) {
        mEventListener = eventListner;
    }
}
