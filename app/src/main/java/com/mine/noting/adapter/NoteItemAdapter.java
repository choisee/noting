package com.mine.noting.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mine.noting.common.Constant;
import com.mine.noting.R;
import com.mine.noting.model.NoteModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NoteItemAdapter extends RecyclerView.Adapter<NoteItemAdapter.ViewHolder> {

    private final String TAG = "NoteItemAdapter";

    private Context mContext = null;
    private ArrayList<NoteModel> mNoteList = null;

    public NoteItemAdapter(ArrayList<NoteModel> noteList){
        mNoteList = noteList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout noteLinearLayout;
        private ImageView noteIcon;
        private TextView noteContent;
        private TextView noteDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Log.d(TAG, "ViewHolder()");
            noteLinearLayout = itemView.findViewById(R.id.ll_note_item);
            noteDate = itemView.findViewById(R.id.tv_note_date);
            noteContent = itemView.findViewById(R.id.tv_note_content);
            noteIcon = itemView.findViewById(R.id.iv_note_icon);
        }
    }

    @NonNull
    @Override
    public NoteItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder()");

        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
//        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.item_rv_note_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder()");

        if(mNoteList.get(position).getNoteIconType() == Constant.Emoji.HAPPY){
            holder.noteIcon.setImageResource(R.drawable.happyeye);
            holder.noteLinearLayout.setBackgroundColor(mContext.getColor(R.color.strong));
        } else if(mNoteList.get(position).getNoteIconType() == Constant.Emoji.FINE){
            holder.noteIcon.setImageResource(R.drawable.happy);
            holder.noteLinearLayout.setBackgroundColor(mContext.getColor(R.color.normal));
        } else if(mNoteList.get(position).getNoteIconType() == Constant.Emoji.SOSO){
            holder.noteIcon.setImageResource(R.drawable.surprised);
            holder.noteLinearLayout.setBackgroundColor(mContext.getColor(R.color.bright_grey));
        } else if(mNoteList.get(position).getNoteIconType() == Constant.Emoji.SAD){
            holder.noteIcon.setImageResource(R.drawable.sad);
            holder.noteLinearLayout.setBackgroundColor(mContext.getColor(R.color.dark_grey));
        }
        holder.noteContent.setText(mNoteList.get(position).getNoteContent());

        long timestamp = mNoteList.get(position).getNoteSavedTimestamp();
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        holder.noteDate.setText(dataFormat.format(timestamp));
    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount()");

        return mNoteList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "getItemViewType()");

        return mNoteList.get(position).getNoteIconType();
    }


    @Override
    public long getItemId(int position) {
        Log.d(TAG, "getItemId()");

        return mNoteList.get(position).getNoteId();
    }

}
