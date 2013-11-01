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
	 * У�ʷ���
	 */
	private static final int SERVCE = 0;
	/**
	 * ����У��
	 */
	private static final int ABOUT = 1;
	/**
	 * ��ʷ��¼
	 */
	private static final int HISTORY = 2;
	/**
	 * У������
	 */
	private static final int HOTLINE = 3;
	/**
	 * У�ʽ���
	 */
	private static final int SUGGEST = 4;
	/**
	 * ΢��
	 */
	private static final int MICROBLOG = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ȥ���ֻ�����Ĭ�ϱ���
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.moreinfor);

		// �ֻ������������
		super.textViewTitle = (TextView) findViewById(R.id.title);
		super.textViewTitle.setText(R.string.more);
		// �ײ��˵�������¼�Ч������
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
		// ����ý���ʱ,ģ�´ӷ�������������ʱ�����������
//		super.progressDialog = ProgressDialog.show(this, "У�ʹ�����", "���ݻ�ȡ��....",
//				true);
//		super.progressDialog.show();
//		// ͨ���߳���ѭ�����ý�����
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

	static final String[] MORETYPE = { "У�ʹ������ŵ", "����", "�����¼", "У�ʷ�������",
			"���鷴��", "�ֻ�У��΢��" };

	// �ײ��˵�ģ��<����>ListView������
	class listViewLitongOnclickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			if (position == SERVCE) {
				// �����ŵ
				intent.setClass(MoreInforActivity.this,
						LetaoServceActivity.class);
				startActivity(intent);
			} else if (position == ABOUT) {
				// ����ҳ��
				intent.setClass(MoreInforActivity.this,
						LetaoAboutActivity.class);
				startActivity(intent);
			} else if (position == HISTORY) {
				// �����¼
				intent.setClass(MoreInforActivity.this,
						LetaoHistoryActivity.class);
				startActivity(intent);
			} else if (position == HOTLINE) {
				// ��������
				intent.setClass(MoreInforActivity.this,
						LetaoHotLineActivity.class);
				startActivity(intent);
			} else if (position == SUGGEST) {
				// ���鷴��
				intent.setClass(MoreInforActivity.this,
						LetaoSuggestActivity.class);
				startActivity(intent);
			} else if (position == MICROBLOG) {
				// �ֻ�����
				intent.setClass(MoreInforActivity.this,
						LetaoMicroBlogActivity.class);
				startActivity(intent);
			}
		}

	}
}
