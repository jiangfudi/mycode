package com.qianfeng.zhushou.gift.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.zhushou.R;
import com.qianfeng.zhushou.gift.bean.Gift;

import java.util.List;

/**
 * Created by Liu Jianping
 *
 * @date : 16/1/12.
 */
public class GiftListAdapter extends BaseAdapter
{
    private List<Gift> list;
    private LayoutInflater inflater;

    public GiftListAdapter(Context context, List<Gift> list)
    {
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        GiftItem item = null;
        if (convertView == null)
        {
            item = new GiftItem();
            convertView = inflater.inflate(R.layout.adapter_gift_list, null);

            item.ivHeader = (ImageView) convertView.findViewById(R.id.adapter_gift_header_iv);
            item.tvName = (TextView) convertView.findViewById(R.id.adapter_gift_name_tv);
            item.tvRemain = (TextView) convertView.findViewById(R.id.adapter_gift_remain_tv);
            item.tvContent = (TextView) convertView.findViewById(R.id.adapter_gift_content_tv);
            item.btn = (Button) convertView.findViewById(R.id.adapter_gift_btn);

            convertView.setTag(item);
        }
        else
        {
            item = (GiftItem) convertView.getTag();
        }

        Gift gift = list.get(position);

        item.tvName.setText(gift.getName());
        item.tvRemain.setText("" + gift.getRemain());
        item.tvContent.setText(gift.getContent());

        return convertView;
    }

    class GiftItem
    {
        ImageView ivHeader;

        TextView tvName, tvRemain, tvContent;

        Button btn;
    }



}
