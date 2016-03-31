package com.espresso.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liyanan on 16/3/31.
 */
public class ListFragment extends Fragment {
    private ListView lv_data;
    private List<Book> values;
    private ListActionListener listActionListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, null);
        initAdapter(view);
        return view;
    }


    private void initAdapter(View view) {
        lv_data = (ListView) view.findViewById(R.id.lv_data);
        values = ListUtil.buildData();
        lv_data.setAdapter(new ListItemAdapter(getActivity(), values));
        lv_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listActionListener.itemClick(values.get(position));
            }
        });
    }

    public void setListActionListener(ListActionListener listActionListener) {
        this.listActionListener = listActionListener;
    }

    class ListItemAdapter extends BaseAdapter {
        private List<Book> values;
        private Context context;

        public ListItemAdapter(Context context, List<Book> values) {
            this.context = context;
            this.values = values;
        }

        @Override
        public int getCount() {
            return values == null ? 0 : values.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Book getItem(int position) {
            return values.get(position);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item_test, null);
                holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                holder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
                holder.btn_click = (Button) convertView.findViewById(R.id.btn_click);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_title.setText(getItem(position).getTitle());
            holder.tv_desc.setText(getItem(position).getDesc());
            holder.btn_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listActionListener.btnClick(values.get(position));
                }
            });
            return convertView;
        }

        class ViewHolder {
            TextView tv_title;
            TextView tv_desc;
            Button btn_click;
        }
    }

    interface ListActionListener {
        void itemClick(Book book);

        void btnClick(Book book);
    }
}

