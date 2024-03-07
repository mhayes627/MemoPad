package edu.jsu.mcis.cs408.memopad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.jsu.mcis.cs408.memopad.databinding.ActivityMainBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<MemoPadModel> data;

    public RecyclerViewAdapter(List<MemoPadModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ActivityMainBinding binding = ActivityMainBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setContact(data.get(position));
        holder.bindData();

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private MemoPadModel memo;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setContact(MemoPadModel memo) {
            this.memo = memo;
        }

        public void bindData() {

            TextView noteLabel = (TextView) itemView.findViewById();

            noteLabel.setText(memo.getNote());

        }

    }

}