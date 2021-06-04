package com.example.registerloginexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registerloginexample.databinding.ListviewItemBinding;

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

//        Log.i("TAG",listViewItemList.get(position));
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

        TextView ccon = (TextView) convertView.findViewById(R.id.ccontent);
        TextView ppri = (TextView) convertView.findViewById(R.id.pprice);

        ListViewItem mlistViewItem = listViewItemList.get(position);

        Log.i("뭐냐","왜이래");
        iconImageView.setImageResource(mlistViewItem.getIcon());
        titleTextView.setText(mlistViewItem.getTitle());
        ccon.setText(mlistViewItem.getContent());

        Log.i("뭐냐",mlistViewItem.getTitle());
        Log.i("뭐냐",mlistViewItem.getPrice()+"");
        Log.i("뭐냐",mlistViewItem.getContent());


        ppri.setText(mlistViewItem.getPrice()+"");

        return convertView;
    }

    public void addItem(String title, int icon,int price,String content){
        ListViewItem item = new ListViewItem();
        Log.i("check",price+content);


        Log.i("addItem",title);
        Log.i("addItem",price+"");
        Log.i("addItem",content);

        item.setTitle(title);
        item.setContent(content);
        item.setIcon(icon);
        item.setPrice(price);

        listViewItemList.add(item);
    }
}
