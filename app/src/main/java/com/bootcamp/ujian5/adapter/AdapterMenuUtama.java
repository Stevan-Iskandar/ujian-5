package com.bootcamp.ujian5.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bootcamp.ujian5.R;
import com.bootcamp.ujian5.model.Data;

import java.util.List;

public class AdapterMenuUtama extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  Context context;
  List<Data> lstData;

  public AdapterMenuUtama(Context context , List<Data> lstData ) {
    this.context = context;
    this.lstData = lstData;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder vh;
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu_utama, parent, false);
    vh = new ContohViewHolder(v);
    return vh;
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof ContohViewHolder) {
      final ContohViewHolder view = (ContohViewHolder) holder;
      final Data data = lstData.get(position);

      view.txtNama.setText(data.getNama());
      view.txtUmur.setText(String.valueOf(data.getUmur()));
      view.txtBeratBadan.setText(String.valueOf(data.getBeratBadan()));
      view.txtTekananDarah.setText(data.getTekananDarah());
      view.txtAlamat.setText(data.getAlamat());
      view.btnDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          data.delete();
          view.vLayout.setVisibility(View.GONE);
        }
      });
    }
  }

  @Override
  public int getItemCount() {
    return lstData.size();
  }

  public class ContohViewHolder  extends RecyclerView.ViewHolder{
    TextView txtNama, txtUmur, txtBeratBadan, txtTekananDarah, txtAlamat;
    Button btnDelete;
    LinearLayout vLayout;
    CardView cardView;

    public ContohViewHolder(@NonNull View itemView) {
      super(itemView);
      vLayout = (LinearLayout) itemView.findViewById(R.id.vLayout);
      cardView = (CardView) itemView.findViewById(R.id.cardView);

      txtNama = (TextView) itemView.findViewById(R.id.txtNama);
      txtUmur = (TextView) itemView.findViewById(R.id.txtUmur);
      txtBeratBadan = (TextView) itemView.findViewById(R.id.txtBeratBadan);
      txtTekananDarah = (TextView) itemView.findViewById(R.id.txtTekananDarah);
      txtAlamat = (TextView) itemView.findViewById(R.id.txtAlamat);
      btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
    }
  }
}
