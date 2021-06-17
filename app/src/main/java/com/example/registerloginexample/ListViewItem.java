package com.example.registerloginexample;

//2. listView 표시 할 데이터 객체를 위한 클래스
public class ListViewItem {
    private int iconDrawavle;
    private String contentStr;
    private String titleStr;
    private int priceInt;



    public void setTitle(String title) {
        titleStr = title;
    }

    public void setIcon(int icon) {
        iconDrawavle = icon;
    }

    public void setContent(String content) {
        contentStr = content;
    }


    public void setPrice(int Price) {
        priceInt = Price;
    }

    public int getIcon() {
        return this.iconDrawavle;
    }

    public String getContent() {
        return this.contentStr;
    }

    public String getTitle() {
        return this.titleStr;
    }

    public int getPrice() {
        return this.priceInt;
    }

//    public void getPosition(){ return this.position;}

}
