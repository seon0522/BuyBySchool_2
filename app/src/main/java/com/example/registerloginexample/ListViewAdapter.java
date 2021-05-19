package com.example.registerloginexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//3. BaseAdapter를 상속받아 Adapter구현
public class ListViewAdapter extends BaseAdapter {

    Context mContext= null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<ListViewItem> mListView;

//    private ImageView iconImageView;
//    private TextView titleTextView;
//    private TextView contentTextView;

//    private ArrayList<ListViewItem> listViewItemList = new ArrayList<>();


    public ListViewAdapter(Context context, ArrayList<ListViewItem> data){
        mContext = context;
        mListView = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mListView.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ListViewItem getItem(int position) {
        return mListView.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview_item, null);
        ImageView imageView = (ImageView)view.findViewById(R.id.icon);
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView text = (TextView)view.findViewById(R.id.text);

        imageView.setImageResource(mListView.get(position).getIcon());
        title.setText(mListView.get(position).getTitle());
        text.setText(mListView.get(position).getContent());

        return convertView;
    }
}
