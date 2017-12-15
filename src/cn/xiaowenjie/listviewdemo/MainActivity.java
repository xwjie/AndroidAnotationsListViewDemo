package cn.xiaowenjie.listviewdemo;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 主活动页面，渲染ListView，增加删除数据
 * 
 * @author xiaowenjie
 * @date 2015-12-24
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity
{
    @ViewById
    ListView listview;

    @Bean
    ItemListAdapter adapter;

    @AfterViews
    void init()
    {
        listview.setAdapter(adapter);

        initData();
    }

    private void initData()
    {
        List<Item> items = new ArrayList<Item>();

        for (int i = 0; i < 20; i++)
        {
            items.add(new Item("标题" + i, "正文" + i + "\n长按删除", R.drawable.ic_launcher));
        }

        adapter.update(items);
    }

    /**
     * 名字必须是这个
     */
    @ItemClick
    void listviewItemClicked(Item item)
    {
        Toast.makeText(this, "点击了" + item.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 名字必须是这个
     */
    @ItemLongClick
    void listviewItemLongClicked(Item item)
    {
        adapter.delete(item);
    }
}
