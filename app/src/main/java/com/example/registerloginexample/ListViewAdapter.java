package com.example.registerloginexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

//3. BaseAdapter를 상속받아 Adapter구현
public class ListViewAdapter extends BaseAdapter implements Filterable {

    private ImageView iconImageView;
    private TextView titleTextView;
    private TextView writerTextView;  //저자
    private TextView priceTextView;

    //    데이터를 넣은 리스트 변수(원본데이터)
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<>();

    //    필터링 결과를 저장하기 위한 ArrayList.
    private ArrayList<ListViewItem> filteredItemList = listViewItemList;

    Filter listFilter;

    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return filteredItemList.size();
    }


    //    지정한 위치에 있는 데이터와 관계된 아이템의 ID를 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {

//        Log.i("TAG",listViewItemList.get(position));
        return (Object)filteredItemList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int post = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
        titleTextView = (TextView) convertView.findViewById(R.id.title);
        iconImageView = (ImageView) convertView.findViewById(R.id.icon);
        writerTextView = (TextView) convertView.findViewById(R.id.text);
        priceTextView = (TextView) convertView.findViewById(R.id.price);

//        ListViewItem mlistViewItem = listViewItemList.get(post);
        ListViewItem mlistViewItem = filteredItemList.get(post);

        Log.i("뭐냐", "왜이래");
        iconImageView.setImageResource(mlistViewItem.getIcon());
        titleTextView.setText(mlistViewItem.getTitle());
        writerTextView.setText(mlistViewItem.getWriter());

//        Log.i("뭐냐", mlistViewItem.getTitle());
//        Log.i("뭐냐", mlistViewItem.getPrice() + "");
//        Log.i("뭐냐", mlistViewItem.getContent());


        priceTextView.setText(mlistViewItem.getPrice() + "");

//        LinearLayout cmdArea = convertView.findViewById(R.id.cmdArea);
//        cmdArea.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), filteredItemList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }
    // mainactivity 에서 받은 값을 넣음 listvieItemlist 객체로
    public void addItem(int Postnum ,String title, int icon, int price, String writer, String Content) {
        ListViewItem item = new ListViewItem();

//        Log.i("check", price + content);
//        Log.i("addItem", title);
//        Log.i("addItem", Postnum + "");
//        Log.i("addItem", price + "");
//        Log.i("addItem", content);

        item.setPostNum(Postnum);
        item.setTitle(title);
        item.setWriter(writer);
        item.setIcon(icon);
        item.setPrice(price);
        item.setContent(Content);

        listViewItemList.add(item);
    }

    @Override
    public Filter getFilter() {
        if(listFilter == null){
            listFilter = new ListFilter();
        }

        return listFilter;
    }

    private class ListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults() ;

            if (constraint == null || constraint.length() == 0) {
                results.values = listViewItemList ;
                results.count = listViewItemList.size() ;
            } else {
                ArrayList<ListViewItem> itemList = new ArrayList<ListViewItem>() ;

                for (ListViewItem item : listViewItemList) {
                    if (item.getTitle().toUpperCase().contains(constraint.toString().toUpperCase()) ||
                            item.getWriter().toUpperCase().contains(constraint.toString().toUpperCase()))
                    {
                        itemList.add(item) ;
                    }
                }

                results.values = itemList ;
                results.count = itemList.size() ;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            //검색된 리스트의 데이터를 업데이트
            filteredItemList = (ArrayList<ListViewItem>) results.values ;

            // notify
            if (results.count > 0) {
                notifyDataSetChanged() ;
            } else {
                notifyDataSetInvalidated() ;
            }
        }
    }

}
