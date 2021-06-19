package com.example.registerloginexample;

//2. listView 표시 할 데이터 객체를 위한 클래스
public class ListViewItem {
    private int iconDrawavle;
    private String writerStr;
    private String titleStr;
    private int priceInt;
    private int postNumInt;


    public void setPostNum(int PostNum) {
        this.postNumInt = PostNum;
    }

    public int getPostNum() {
        return this.postNumInt;
    }

    public void setTitle(String title) {
        titleStr = title;
    }

    public void setIcon(int icon) {
        iconDrawavle = icon;
    }

    public void setWriter(String writer) {
        writerStr = writer;
    }

    public void setPrice(int Price) {
        priceInt = Price;
    }

    public int getIcon() {
        return this.iconDrawavle;
    }

    public String getWriter() {
        return this.writerStr;
    }

    public String getTitle() {
        return this.titleStr;
    }

    public int getPrice() {
        return this.priceInt;
    }

}
