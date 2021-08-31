package com.example.recycleviewfromfirestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    ArrayList<model> dataList;
    FirebaseFirestore db;
    myAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recycleViewEditText);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList=new ArrayList<>();
        adapter=new myAdapter(dataList);
        recyclerView.setAdapter(adapter);

        db=FirebaseFirestore.getInstance();
        db.collection("Users").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            model obj=d.toObject(model.class);
                            dataList.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}