package com.bootcamp.ujian5.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bootcamp.ujian5.R;
import com.bootcamp.ujian5.adapter.AdapterMenuUtama;
import com.bootcamp.ujian5.application.AppController;
import com.bootcamp.ujian5.model.Data;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.queriable.StringQuery;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import java.util.List;

public class MenuUtamaActivity extends AppCompatActivity {
  Button btnAdd;
  RecyclerView listData;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_utama);

    listData = (RecyclerView) findViewById(R.id.listData);
    btnAdd = (Button) findViewById(R.id.btnAdd);
    btnAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MenuUtamaActivity.this, AddDataActivity.class);
        MenuUtamaActivity.this.startActivity(intent);
      }
    });

    sqlQueryList();
  }

  public void sqlQueryList(){
    String rawQuery = "SELECT * FROM `Data` ";
    StringQuery<Data> stringQuery = new StringQuery<>(Data.class, rawQuery);
    stringQuery
      .async()
      .queryListResultCallback(new QueryTransaction.QueryResultListCallback<Data>() {
                                 @Override
                                 public void onListQueryResult(QueryTransaction transaction, @NonNull List<Data> models) {
                                   setupAdapterList(models);
                                 }
                               }
      ).execute();
  }

  public void setupAdapterList(List<Data> model){
    AdapterMenuUtama toadapter = new AdapterMenuUtama (MenuUtamaActivity.this, model);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MenuUtamaActivity.this, LinearLayoutManager.VERTICAL, false);
    listData.setLayoutManager(linearLayoutManager);
    listData.setAdapter(toadapter);
  }
}
