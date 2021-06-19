package com.example.registerloginexample;

//2. listView 표시 할 데이터 객체를 위한 클래스
public class ListViewItem {
    private int iconDrawavle;
    private String writerStr;  //책의 저자
    private String titleStr;  //게시글제목
    private int priceInt;  //가격
    private int postNumInt;  //게시글 고유 번호
    private String ContentStr;  //게시글 내용


    public void setPostNum(int PostNum) {
        this.postNumInt = PostNum;
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

    public void setContent(String content) {ContentStr = content; }


    public int getPostNum() {
        return this.postNumInt;
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

    public String getContent() { return this.ContentStr; }

}
