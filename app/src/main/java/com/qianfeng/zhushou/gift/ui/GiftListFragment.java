package com.qianfeng.zhushou.gift.ui;

import android.util.Log;
import android.widget.ListView;

import com.qianfeng.zhushou.R;
import com.qianfeng.zhushou.gift.adapter.GiftListAdapter;
import com.qianfeng.zhushou.gift.bean.Gift;
import com.qianfeng.zhushou.other.ui.BaseFragment;
import com.qianfeng.zhushou.other.utils.ZhuShouHttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 礼包列表页面
 *
 * Created by Liu Jianping
 *
 * @date : 16/1/12.
 */
public class GiftListFragment extends BaseFragment
{
    private ListView listView;

    @Override
    protected int getLayout()
    {
        return R.layout.fragment_type_list;
    }

    @Override
    protected void initViews()
    {
        listView = (ListView) root;
    }

    @Override
    protected void initEvents()
    {

    }

    @Override
    protected void initData()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("platform", "2");
                params.put("gifttype", "1");

                Object result = ZhuShouHttpUtil.doPost(
                        "http://zhushou.72g.com/app/gift/gift_list/", params);

                try
                {
                    JSONObject json = new JSONObject(result.toString());

                    String state = json.getString("state");
                    // 如果解析的状态是成功
                    if ("success".equals(state))
                    {
                        // JSONArray info = json.getJSONArray("info");

                        // List<Gift> list =
                        // Gift.arrayGiftFromData(info.toString());

                        final List<Gift> list = Gift.arrayGiftFromData(
                                json.toString(), "info");

                        Log.w("tag", "list.size = " + list.size());

                        getActivity().runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                GiftListAdapter adapter = new GiftListAdapter(
                                        getActivity(), list);

                                listView.setAdapter(adapter);
                            }
                        });

                    }

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }.start();

    }
}
