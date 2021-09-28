package com.mine.noting.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.mine.noting.adapter.NoteItemAdapter;
import com.mine.noting.model.NoteModel;
import com.mine.noting.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private ArrayList<NoteModel> mNoteList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        mNoteList = new ArrayList<>();

        generateTestData();

        NoteItemAdapter noteItemAdapter = new NoteItemAdapter(mNoteList);
        RecyclerView recyclerView = findViewById(R.id.rv_note_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // vertical
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)); // HORIZONTAL
        recyclerView.setAdapter(noteItemAdapter);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");

    }

    private void generateTestData() {
        for(int i = 0; i < 100; i++){
            NoteModel noteModel = new NoteModel();
            noteModel.setNoteId(i);
            noteModel.setNoteIconType(getRandomNum() - 1);
            noteModel.setNoteContent("호로롤 : " + (i + 1));
            noteModel.setNoteSavedTimestamp(System.currentTimeMillis());
            mNoteList.add(noteModel);
        }
        Log.d(TAG, "mNoteList.size() : " + mNoteList.size());
    }

    private int getRandomNum(){
        Random random = new Random();
        return random.nextInt(4);
    }

}