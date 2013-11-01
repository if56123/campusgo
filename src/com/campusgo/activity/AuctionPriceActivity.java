package com.campusgo.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.campusgo.activity.R;
import com.campusgo.db.entity.ProductType;
import com.campusgo.db.dal.*;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class AuctionPriceActivity extends CommonActivity implements
		OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去除手机界面默认标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.girlshoes);
		// 手机界面标题设置
		super.textViewTitle = (TextView) findViewById(R.id.title);
		super.textViewTitle.setText(R.string.girlshoes);

		// 底部菜单栏点击事件效果设置
		imageViewIndex = (ImageView) findViewById(R.id.menu_home_img);
		imageViewIndex.setOnTouchListener(viewIndex);

		imageViewType = (ImageView) findViewById(R.id.menu_brand_img);
		imageViewType.setOnTouchListener(viewType);
		imageViewType.setImageResource(R.drawable.menu_brand_pressed);

		imageViewShooping = (ImageView) findViewById(R.id.menu_shopping_cart_img);
		imageViewShooping.setOnTouchListener(viewShooping);

		imageViewMyLetao = (ImageView) findViewById(R.id.menu_my_letao_img);
		imageViewMyLetao.setOnTouchListener(viewMyLetao);

		imageViewMore = (ImageView) findViewById(R.id.menu_more_img);
		imageViewMore.setOnTouchListener(viewMore);

		super.listViewAll = (ListView) findViewById(android.R.id.list);
		setListAdapter(new SimpleAdapter(this, getData(),
				R.layout.common_listview_text, new String[] { "img", "text",
						"img_pre" }, new int[] { R.id.img, R.id.text,
						R.id.img_pre }));
		super.listViewAll.setOnItemClickListener(this);
		// 进入该界面时,模仿从服务器加载数据时的虚拟进度条
//		super.progressDialog = ProgressDialog.show(this, "校际购购物", "数据获取中....",
//				true);
//		super.progressDialog.show();
//		// 通过线程来循环调用进度条
//		super.handler.post(this);

	}

	//这里的加载商品类别数据需要在以后改为程序启动就加载数据
	private List<Map<String, Object>> getData() {
		
		ProductTypesDal ptd = new ProductTypesDal();
		ArrayList<ProductType> pts = ptd.getProductTypes(1);
		List<Map<String, Object>> listGirl = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < pts.size(); i++) {
			Map<String, Object> mapGirl = new HashMap<String, Object>();
			mapGirl.put("text", pts.get(i).getProductName());
			mapGirl.put("img", R.drawable.toright_mark);
			mapGirl.put("img_pre", R.drawable.paopao);
			listGirl.add(mapGirl);
		}
		return listGirl;
	}
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		intent.setClass(getApplicationContext(), NewProMarketActivity.class);
		startActivity(intent);
	}
}
