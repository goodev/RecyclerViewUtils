package org.goodev.recyclerviewutils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AsyncListAdapter extends RecyclerView.Adapter<AsyncListAdapter.ViewHolder> {
    private Context mContext;
    private AsyncListCursorUtil mAsyncListCursorUtil;

    public AsyncListAdapter(Activity activity, RecyclerView rv) {
        mContext = activity;
        mAsyncListCursorUtil = new AsyncListCursorUtil(activity, rv);
    }

    @Override
    public AsyncListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AsyncListAdapter.ViewHolder holder, int position) {
        final Data item = mAsyncListCursorUtil.getItem(position);
        holder.updateData(item);
    }

    @Override
    public int getItemCount() {
        return mAsyncListCursorUtil.getItemCount();
    }

    static class Data {
        String key;
        String name;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView1;
        private TextView mTextView2;

        ViewHolder(View itemView) {
            super(itemView);
            mTextView1 = (TextView) itemView.findViewById(android.R.id.text1);
            mTextView2 = (TextView) itemView.findViewById(android.R.id.text2);
        }

        void updateData(Data item) {
            if (item == null) {
                mTextView1.setText(R.string.loading);
                mTextView2.setText(R.string.unknown);
            } else {
                mTextView1.setText(item.name);
                mTextView2.setText(item.key);
            }
        }
    }

}
