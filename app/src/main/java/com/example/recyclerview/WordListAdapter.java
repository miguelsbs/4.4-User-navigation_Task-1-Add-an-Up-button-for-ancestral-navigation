package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordViewHolder> {

    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> mWordList) {
        //this.mWordList = mWordList;
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }


    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public class WordViewHolde extends RecyclerView.ViewHolder {
        public WordViewHolde(View itemView) {
            super(itemView);
        }
    }
}

class WordViewHolder extends RecyclerView.ViewHolder {
    public final TextView wordItemView;
    final WordListAdapter mAdapter;

    public WordViewHolder(View itemView, WordListAdapter adapter) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.word);
        this.mAdapter = adapter;
    }
}