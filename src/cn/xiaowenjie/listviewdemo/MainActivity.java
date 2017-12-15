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
 * ���ҳ�棬��ȾListView������ɾ������
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
            items.add(new Item("����" + i, "����" + i + "\n����ɾ��", R.drawable.ic_launcher));
        }

        adapter.update(items);
    }

    /**
     * ���ֱ��������
     */
    @ItemClick
    void listviewItemClicked(Item item)
    {
        Toast.makeText(this, "�����" + item.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * ���ֱ��������
     */
    @ItemLongClick
    void listviewItemLongClicked(Item item)
    {
        adapter.delete(item);
    }
}
