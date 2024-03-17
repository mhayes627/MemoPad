package edu.jsu.mcis.cs408.memopad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import edu.jsu.mcis.cs408.memopad.databinding.MemoItemBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Memo> data;
    private final MainActivity activity;

    public RecyclerViewAdapter(MainActivity activity, List<Memo> data) {
        super();
        this.data = data;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MemoItemBinding binding = MemoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.getRoot().setOnClickListener(activity.getItemClick()); // the click handler
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setMemo(data.get(position));
        holder.bindData();

    }

    public Memo getItem(int position) { return data.get(position); }

    @Override
    public int getItemCount() { return data.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Memo memo;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setMemo(Memo memo) {
            this.memo = memo;
        }

        public void bindData() {

            TextView memoLabel = (TextView) itemView.findViewById(R.id.memoPadLabel);

            memoLabel.setText(memo.toString());

        }

    }

}