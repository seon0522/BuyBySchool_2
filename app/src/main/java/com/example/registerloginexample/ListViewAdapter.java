package com.example.registerloginexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//3. BaseAdapter를 상속받아 Adapter구현
public class ListViewAdapter extends BaseAdapter {
//
//    Context mContext= null;
//    LayoutInflater mLayoutInflater = null;
//    ArrayList<ListViewItem> mListView;

    private ImageView iconImageView;
    private TextView titleTextView;
    private TextView contentTextView;
    private TextView priceTextView;

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<>();


//    public ListViewAdapter(Context context, ArrayList<ListViewItem> data){
//        mContext = context;
//        mListView = data;
//        mLayoutInflater = LayoutInflater.from(mContext);
//    }

    public ListViewAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int post = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

//        View view = mLayoutInflater.inflate(R.layout.listview_item, null);
//        ImageView imageView = (ImageView)view.findViewById(R.id.icon);
//        TextView title = (TextView)view.findViewById(R.id.title);
//        TextView text = (TextView)view.findViewById(R.id.text);

        titleTextView = (TextView)convertView.findViewById(R.id.title);
        iconImageView = (ImageView) convertView.findViewById(R.id.icon);
        contentTextView = (TextView) convertView.findViewById(R.id.text);
        priceTextView = (TextView)convertView.findViewById(R.id.price);

        ListViewItem mlistViewItem = listViewItemList.get(position);


        iconImageView.setImageResource(mlistViewItem.getIcon());
        titleTextView.setText(mlistViewItem.getTitle());
        contentTextView.setText(mlistViewItem.getContent());
        priceTextView.setText(mlistViewItem.getPrice());

        return convertView;
    }

    public void addItem(String title, int icon, String content,String price){
        ListViewItem item = new ListViewItem();

        item.setTitle(title);
        item.setContent(content);
        item.setIcon(icon);
        item.setPrice(price);

        listViewItemList.add(item);
    }
}
