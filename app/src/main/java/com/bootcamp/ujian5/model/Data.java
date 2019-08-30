package com.bootcamp.ujian5.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.bootcamp.ujian5.application.AppController;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

@Table(database = AppController.class)
public class Data extends BaseModel implements Serializable, Parcelable {
  @SerializedName("id")
  @Expose
  @PrimaryKey(autoincrement = true)
  private Integer id;

  @SerializedName("nama")
  @Expose
  @Column
  private String nama;

  @SerializedName("umur")
  @Expose
  @Column
  private Integer umur;

  @SerializedName("berat_badan")
  @Expose
  @Column
  private Integer beratBadan;

  @SerializedName("tekanan_darah")
  @Expose
  @Column
  private String tekananDarah;

  @SerializedName("alamat")
  @Expose
  @Column
  private String alamat;

  public final static Creator<Data> CREATOR = new Creator<Data>() {


    @SuppressWarnings({
      "unchecked"
    })
    public Data createFromParcel(Parcel in) {
      return new Data(in);
    }

    public Data[] newArray(int size) {
      return (new Data[size]);
    }

  };

  private final static long serialVersionUID = -28233401489564790L;

  protected Data (Parcel in) {
    this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.nama = ((String) in.readValue((String.class.getClassLoader())));
    this.umur = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.beratBadan = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.tekananDarah = ((String) in.readValue((String.class.getClassLoader())));
    this.alamat = ((String) in.readValue((String.class.getClassLoader())));
  }

  public Data() {

  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(id);
    dest.writeValue(nama);
    dest.writeValue(umur);
    dest.writeValue(beratBadan);
    dest.writeValue(tekananDarah);
    dest.writeValue(alamat);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public Integer getUmur() {
    return umur;
  }

  public void setUmur(Integer umur) {
    this.umur = umur;
  }

  public Integer getBeratBadan() {
    return beratBadan;
  }

  public void setBeratBadan(Integer beratBadan) {
    this.beratBadan = beratBadan;
  }

  public String getTekananDarah() {
    return tekananDarah;
  }

  public void setTekananDarah(String tekananDarah) {
    this.tekananDarah = tekananDarah;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }
}
