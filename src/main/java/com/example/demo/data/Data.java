package com.example.demo.data;


public class Data {

  public String status;

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatus(){
    return this.status;
  }

  @Override
  public String toString() {
    return "status:" + status;
  }
}
