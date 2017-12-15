package cn.xiaowenjie.listviewdemo;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * listview����������������update��append��delete���������ݸ��µ�ʱ����á�
 * 
 * ע�⣺�ڲ���datas��Ҫֱ��ʹ����������ã����׳����⣬��Ҫ���ɻ�ϰ�ߡ�
 *  
 * @author xiaowenjie
 * @date 2015-12-24
 */
@EBean
public class ItemListAdapter extends BaseAdapter
{

    @RootContext
    Context context;

    private ArrayList<Item> datas;

    @AfterInject
    void init()
    {
        this.datas = new ArrayList<Item>();
    }

    @Override
    public int getCount()
    {
        return this.datas.size();
    }

    @Override
    public Item getItem(int position)
    {
        return this.datas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ItemView view = null;

        if (convertView == null)
        {
            view = ItemView_.build(context);
        }
        else
        {
            view = (ItemView) convertView;
        }

        view.bind(getItem(position));

        return view;
    }

    public void update(List<Item> items)
    {
        this.datas.clear();
        this.datas.addAll(items);

        notifyDataSetChanged();
    }

    public void append(List<Item> items)
    {
        this.datas.addAll(items);

        notifyDataSetChanged();
    }

    public void delete(Item item)
    {
        this.datas.remove(item);

        notifyDataSetChanged();
    }

}
