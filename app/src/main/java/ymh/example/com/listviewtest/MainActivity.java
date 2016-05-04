package ymh.example.com.listviewtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MyAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        myadapter = new MyAdapter(this, R.layout.info_item_big);
        listView.setAdapter(myadapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScroll(AbsListView paramAbsListView, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                Log.e("test", "onScroll");
            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE://空闲状态
                        Log.e("test", "空闲状态");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING://滚动状态
                        Log.e("test", "滚动状态");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL://触摸后滚动
                        Log.e("test", "触摸后滚动");
                        break;
                }
            }
        });
    }

    private String[] datas = {"aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "aaa", "bbb",
            "ccc", "aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "aaa", "bbb", "ccc"};

    private class MyAdapter extends BaseAdapter {
        private Context context;

        public MyAdapter(Context context, int resource) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return datas.length;
        }

        @Override
        public Object getItem(int position) {
            return datas[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.info_item_big, null);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(datas[position]);
            return view;
        }
    }

    public void click(View view) {
        listView.setSelection(50);
    }
}
