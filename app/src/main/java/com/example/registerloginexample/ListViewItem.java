package com.example.registerloginexample;

public class ListViewItem {
    private int iconDrawavle;
    private String contentStr;
    private String titleStr;

    public void setTitle(String title){
        titleStr = title;
    }
    public void setIcon(int icon){
        iconDrawavle = icon;
    }
    public void setContent(String content){
        contentStr = content;
    }

    public int getIcon(){
        return this.iconDrawavle;
    }
    public String getContent(){
        return this.contentStr;
    }
    public String getTitle(){
        return this.titleStr;
    }

}
