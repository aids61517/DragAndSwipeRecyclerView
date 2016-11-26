package aids61517.dragandswiperecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by deming_huang on 2016/8/3.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter implements ItemTouchHelperAdapter {
    private MainActivity mContext;
    private ArrayList<String> mDataList;

    public RecyclerViewAdapter(MainActivity context) {
        mContext = context;
        mDataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mDataList.add(String.valueOf(i));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        RecyclerViewHolder holder = (RecyclerViewHolder) viewHolder;
        holder.textView.setText(mDataList.get(position));
        holder.itemView.setClickable(true);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mDataList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.position);
        }
    }
}
