package com.campusgo.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.campusgo.activity.SecondActivity.listViewLitongOnclickListener;
import com.campusgo.activity.more.LetaoAboutActivity;
import com.campusgo.activity.more.LetaoHistoryActivity;
import com.campusgo.activity.more.LetaoHotLineActivity;
import com.campusgo.activity.more.LetaoMicroBlogActivity;
import com.campusgo.activity.more.LetaoServceActivity;
import com.campusgo.activity.more.LetaoSuggestActivity;
import com.campusgo.activity.R;

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

public class MoreInforActivity extends CommonActivity {
	/**
	 * 校际服务
	 */
	private static final int SERVCE = 0;
	/**
	 * 关于校际
	 */
	private static final int ABOUT = 1;
	/**
	 * 历史记录
	 */
	private static final int HISTORY = 2;
	/**
	 * 校际热线
	 */
	private static final int HOTLINE = 3;
	/**
	 * 校际建议
	 */
	private static final int SUGGEST = 4;
	/**
	 * 微博
	 */
	private static final int MICROBLOG = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去除手机界面默认标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.moreinfor);

		// 手机界面标题设置
		super.textViewTitle = (TextView) findViewById(R.id.title);
		super.textViewTitle.setText(R.string.more);
		// 底部菜单栏点击事件效果设置
		imageViewIndex = (ImageView) findViewById(R.id.menu_home_img);
		imageViewIndex.setOnTouchListener(viewIndex);
		imageViewIndex.setImageResource(R.drawable.menu_home_released);

		imageViewType = (ImageView) findViewById(R.id.menu_brand_img);
		imageViewType.setOnTouchListener(viewType);

		imageViewShooping = (ImageView) findViewById(R.id.menu_shopping_cart_img);
		imageViewShooping.setOnTouchListener(viewShooping);

		imageViewMyLetao = (ImageView) findViewById(R.id.menu_my_letao_img);
		imageViewMyLetao.setOnTouchListener(viewMyLetao);

		imageViewMore = (ImageView) findViewById(R.id.menu_more_img);
		imageViewMore.setOnTouchListener(viewMore);
		imageViewMore.setImageResource(R.drawable.menu_more_pressed);

		super.listViewAll = (ListView) findViewById(android.R.id.list);
		super.listViewAll
				.setOnItemClickListener(new listViewLitongOnclickListener());
		setListAdapter(new SimpleAdapter(this, getDate(),
				R.layout.common_listview_text, new String[] { "img", "text",
						"img_pre" }, new int[] { R.id.img, R.id.text,
						R.id.img_pre }));
		// 进入该界面时,模仿从服务器加载数据时的虚拟进度条
//		super.progressDialog = ProgressDialog.show(this, "校际购购物", "数据获取中....",
//				true);
//		super.progressDialog.show();
//		// 通过线程来循环调用进度条
//		super.handler.post(this);
//		super.onCreate(savedInstanceState);
	}

	private List<Map<String, Object>> getDate() {
		List<Map<String, Object>> listMore = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < MORETYPE.length; i++) {
			Map<String, Object> mapMore = new HashMap<String, Object>();
			mapMore.put("text", MORETYPE[i]);
			mapMore.put("img", R.drawable.toright_mark);
			mapMore.put("img_pre", R.drawable.paopao);
			listMore.add(mapMore);
		}
		return listMore;
	}

	static final String[] MORETYPE = { "校际购服务承诺", "关于", "浏览记录", "校际服务热线",
			"建议反馈", "手机校际微博" };

	// 底部菜单模块<更多>ListView监听器
	class listViewLitongOnclickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			if (position == SERVCE) {
				// 服务承诺
				intent.setClass(MoreInforActivity.this,
						LetaoServceActivity.class);
				startActivity(intent);
			} else if (position == ABOUT) {
				// 关于页面
				intent.setClass(MoreInforActivity.this,
						LetaoAboutActivity.class);
				startActivity(intent);
			} else if (position == HISTORY) {
				// 浏览记录
				intent.setClass(MoreInforActivity.this,
						LetaoHistoryActivity.class);
				startActivity(intent);
			} else if (position == HOTLINE) {
				// 服务热线
				intent.setClass(MoreInforActivity.this,
						LetaoHotLineActivity.class);
				startActivity(intent);
			} else if (position == SUGGEST) {
				// 建议反馈
				intent.setClass(MoreInforActivity.this,
						LetaoSuggestActivity.class);
				startActivity(intent);
			} else if (position == MICROBLOG) {
				// 手机博客
				intent.setClass(MoreInforActivity.this,
						LetaoMicroBlogActivity.class);
				startActivity(intent);
			}
		}

	}
}
