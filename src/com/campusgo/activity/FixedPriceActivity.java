package com.campusgo.activity;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

import com.campusgo.activity.R;
import com.campusgo.db.dal.ProductTypesDal;
import com.campusgo.db.entity.ProductType;

public class FixedPriceActivity extends CommonActivity implements
		OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// ȥ���ֻ�����Ĭ�ϱ���
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.boyshoes);
		// �ֻ������������
		super.textViewTitle = (TextView) findViewById(R.id.title);
		super.textViewTitle.setText(R.string.boyshoes);

		// �ײ��˵�������¼�Ч������
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
		setListAdapter(new SimpleAdapter(FixedPriceActivity.this, getData(),
				R.layout.common_listview_text, new String[] { "img", "text",
						"img_pre" }, new int[] { R.id.img, R.id.text,
						R.id.img_pre }));
		super.listViewAll.setOnItemClickListener(this);
		// ����ý���ʱ,ģ�´ӷ�������������ʱ�����������
		// super.progressDialog = ProgressDialog.show(this, "У�ʹ�����",
		// "���ݻ�ȡ��....",true);
		// super.progressDialog.show();
		// ͨ���߳���ѭ�����ý�����
		// super.handler.post(this);
	}

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
		String username = "postgres";
		String password = "123456";
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");// ������������
			con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.1.101:5432/campusgodb",
					username, password);
			// System.out.print("����˭");
		} catch (Exception e) {
			// TODO: handle exception
			String err;
			try {
				err = new String(e.getMessage().getBytes(), "UTF-8");
				System.out.println(err);
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		try {
			String sql = "SELECT * FROM admin";// ��ѯ����Ϊ��table_test������������
			Statement stmt = con.createStatement();// ����Statement
			ResultSet rs = stmt.executeQuery(sql);// ResultSet����Cursor

			while (rs.next()) {// <code>ResultSet</code>���ָ���һ��
				System.out.println(rs.getString("uid"));// �����n�У�����Ϊ��test_id����ֵ
				System.out.println(rs.getString("uname"));

			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		intent.setClass(this, NewProMarketActivity.class);
		startActivity(intent);
	}

}
