package com.tl.entity;


public class Region {

  private long id;
  private long code;
  private String codeName;
  private long parent;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCode() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }


  public String getCodeName() {
    return codeName;
  }

  public void setCodeName(String codeName) {
    this.codeName = codeName;
  }


  public long getParent() {
    return parent;
  }

  public void setParent(long parent) {
    this.parent = parent;
  }

}
