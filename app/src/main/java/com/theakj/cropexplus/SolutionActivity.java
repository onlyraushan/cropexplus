package com.theakj.cropexplus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SolutionActivity extends AppCompatActivity {

    FloatingActionButton fab;
//    DatabaseReference databaseReference;
//    ValueEventListener eventListener;
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    SearchView searchView;
    FirebaseFirestore fs;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        fs=FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        // searchView = findViewById(R.id.search);
//        searchView.clearFocus();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(SolutionActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setLayoutManager(new LinearLayoutManager(SolutionActivity.this));
        AlertDialog.Builder builder = new AlertDialog.Builder(SolutionActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        dialog = builder.create();
        dialog.show();
        dataList = new ArrayList<>();
        adapter = new MyAdapter(SolutionActivity.this, dataList);
        recyclerView.setAdapter(adapter);
        dialog.show();
        loadData();


//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                searchList(newText);
//                return true;
//            }
//        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SolutionActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        fs.collection("users")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Toast.makeText(SolutionActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        dataList.clear();
                        for (DocumentChange dc : snapshots.getDocumentChanges()) {
//                            dataList.clear();
//                            switch (dc.getType()) {
//                                case ADDED:
//                                case MODIFIED:
//                                case REMOVED:
//                                    dataList.add(dc.getDocument().toObject(DataClass.class));
//                                    break;
//                            }
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                dataList.add(dc.getDocument().toObject(DataClass.class));
                            }
                        }
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
}
//    public void searchList(String text){
//        ArrayList<DataClass> searchList = new ArrayList<>();
//        for (DataClass dataClass: dataList){
//            if (dataClass.getDataTitle().toLowerCase().contains(text.toLowerCase())){
//                searchList.add(dataClass);
//            }
//        }
//        adapter.searchDataList(searchList);
//    }
}