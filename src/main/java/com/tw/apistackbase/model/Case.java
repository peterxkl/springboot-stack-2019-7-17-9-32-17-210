package com.tw.apistackbase.model;

import java.util.Date;

public class Case {
      private int id;
      private String name;
      private Date time;

    public Case(String name, Date time) {
        this.name = name;
        this.time = time;
    }
}
