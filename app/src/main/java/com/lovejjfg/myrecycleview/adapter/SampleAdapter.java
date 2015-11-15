package com.lovejjfg.myrecycleview.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.lovejjfg.myrecycleview.R;

import java.util.ArrayList;
import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Integer> list;

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public List<Integer> getList() {
        return list;
    }

    public SampleAdapter() {
        list = new ArrayList<Integer>();
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    /**
     * 在绑定中完成具体数据的封装。以及点击事件的处理。
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder) {
            LayoutParams layoutParams = ((ItemViewHolder) holder).textView.getLayoutParams();
            // int with = (int) (20 + Math.random() * 200);
            int height = (int) (100 + Math.random() * 200);
            layoutParams.height = height;
            //  layoutParams.width = with;
            ((ItemViewHolder) holder).textView.setLayoutParams(layoutParams);
            ((ItemViewHolder) holder).textView.setText(String.valueOf(list.get(position)));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {

                        itemClickListener.onItemClickListener(holder, holder.itemView, position);
                    }
                }
            });

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_text, null);
            view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            return new ItemViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footerview, null);
            view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }

        return null;
    }

    public void addData(int i) {
        if (list != null) {
            list.add(i, (int) (Math.random() * 100));
            notifyItemInserted(i);
        }
    }

    public void removeData(int i) {
        if (list != null) {
            list.remove(i);
            notifyItemRemoved(i);
        }
    }

    class FooterViewHolder extends ViewHolder {

        public FooterViewHolder(View view) {
            super(view);
        }

    }

    class ItemViewHolder extends ViewHolder {
        TextView textView;

        public ItemViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.text);
//            int with = (int) (20+Math.random()*10);
//            int height = (int) (10+Math.random()*10);
//            LayoutParams layoutParams = new LinearLayout.LayoutParams(with, height);
//            textView.setLayoutParams(layoutParams);
        }

    }

    private ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void onItemClickListener(ViewHolder holder, View view, int position);
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        itemClickListener = listener;
    }

}
