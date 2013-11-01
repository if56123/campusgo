package com.campusgo.activity.type;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.campusgo.activity.CommonActivity;
import com.campusgo.adapter.GalleryImageAdapter;
import com.campusgo.custom.BrandGallery;
import com.campusgo.db.dal.ProductDal;
import com.campusgo.db.entity.Product;
import com.campusgo.activity.R;

public class CommondityInforLetaoActivity extends CommonActivity implements
		OnClickListener, OnItemSelectedListener {
	/**
	 * 商品名称
	 */
	private TextView productNameTextView = null;
	
	/**
	 * 商品价格名称:一口价还是拍卖价
	 */
	private TextView priceNameTextView = null;
	
	/**
	 * 商品价格：销售价格
	 */
	private TextView priceTextView = null;
	
	/**
	 * 原价
	 */
	private TextView originalPriceTextView = null;
	
	/**
	 * 校际购价格
	 */
	private TextView campusGoPriceTextView = null;
	
	/**
	 * 获取联系方式
	 */
	private TextView getContactInfoTextView = null;
	
	/**
	 * 关注收藏
	 */
	private TextView collectProductTextView = null;
	
	/**
	 * 上架时间
	 */
	private TextView timeTextView = null;
	
	/**
	 * 型号
	 */
	private TextView marqueTextView = null;
	
	/**
	 * 成色
	 */
	private TextView qualityTextView = null;

	/**
	 * 产品数量
	 */
	private TextView productNumTextView = null;
	
	/**
	 * 产品描述
	 */
	private TextView productDescTextView = null;
	
	/**
	 * 颜色
	 */
	private TextView colorTextView = null;
	
	
	/**
	 * 收藏
	 */
	private TextView collectTextView = null;

	/**
	 * 商品图片展示
	 */
	private BrandGallery imagesGallery = null;
	
	/**
	 * 左边箭头按钮
	 */
	private ImageView leftImageView = null;
	
	/**
	 * 右边箭头按钮
	 */
	private ImageView rightImageView = null;
	
	/**
	 * value_hassize
	 */
	private LinearLayout codeLinearLayout = null;
	private GalleryImageAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去除手机界面默认标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.letao_type_commodity_infor);
		// 手机界面标题设置
		super.textViewTitle = (TextView) findViewById(R.id.title);
		super.textViewTitle.setText(R.string.app_name);

		this.initTextViewAll();
	}

	@Override
	public void onClick(View view) {
		if (view == getContactInfoTextView) {
			Toast toast = Toast.makeText(getApplicationContext(), "获取联系信息成功!",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} else if (view == collectProductTextView) {
			Toast toast = Toast.makeText(getApplicationContext(), "关注成功!",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} else if (view == collectTextView) {
			Toast toast = Toast.makeText(getApplicationContext(), "收藏成功!",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} else if (view == codeLinearLayout) {//
			// codeTextView.setBackgroundColor(Color.RED);
			new AlertDialog.Builder(this)
					.setTitle("你的脚多大啊？")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setSingleChoiceItems(
							new String[] { "41", "42", "43", "44", "45" }, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {

								}
							}).setNegativeButton("确定", null).show();

			System.out.println("TanRuixiang");
		}
		;

	}

	/**
	 * 加载(绑定)所有控件
	 * 
	 * @Author TanRuixiang
	 */
	private void initTextViewAll() {
		ProductDal ptd = new ProductDal();
		Product product = new Product();
		product.setGoodsid(1);
		product = ptd.selectProductById(product);
		productNameTextView = (TextView) findViewById(R.id.shoe_title);
		productNameTextView.setText(product.getGoodsname());
		priceNameTextView = (TextView) findViewById(R.id.lable_specially_price);
		priceNameTextView.setText("一口价:");
		priceTextView = (TextView) findViewById(R.id.value_specially_price);
		priceTextView.setText(Integer.toString(product.getPrice()));
		// 立即购买按钮
		getContactInfoTextView = (TextView) findViewById(R.id.detail_tobuymust_button);
		getContactInfoTextView.setOnClickListener(this);
		// 加入购物车按钮
		collectProductTextView = (TextView) findViewById(R.id.detail_buy_button);
		collectProductTextView.setOnClickListener(this);
		timeTextView = (TextView) findViewById(R.id.value_listing_date);
		timeTextView.setText(product.getAddadtime());
		marqueTextView = (TextView) findViewById(R.id.value_marque);
		marqueTextView.setText(product.getMarque());
		qualityTextView = (TextView) findViewById(R.id.value_quality);
		qualityTextView.setText(product.getQuality());
		productNumTextView = (TextView) findViewById(R.id.value_productnum);
		productNumTextView.setText(Integer.toString(product.getGoodsnum()));
		// itemNoTextView = (TextView)findViewById(R.id);
		productDescTextView = (TextView) findViewById(R.id.value_man_woman);
		productDescTextView.setText(product.getDescribe());
		colorTextView = (TextView) findViewById(R.id.value_colors);
		colorTextView.setText("红,黄,蓝,绿");
		originalPriceTextView = (TextView) findViewById(R.id.value_counter_price);
		originalPriceTextView.setText("$150");
		campusGoPriceTextView = (TextView) findViewById(R.id.value_letao_price);
		campusGoPriceTextView.setText("$120");
		// 收藏按钮
		collectTextView = (TextView) findViewById(R.id.detail_favorite_button);
		collectTextView.setOnClickListener(this);
		// 商品图片展示
		adapter = new GalleryImageAdapter(this);
		imagesGallery = (BrandGallery) findViewById(R.id.commodity_detail_gallery);
		imagesGallery.setAdapter(adapter);
		imagesGallery.setOnItemSelectedListener(this);
		leftImageView = (ImageView) findViewById(R.id.commodity_detail_left_Img);
		leftImageView.setVisibility(View.GONE);
		rightImageView = (ImageView) findViewById(R.id.commodity_detail_right_Img);
		codeLinearLayout = (LinearLayout) findViewById(R.id.detail_size_layout);
		codeLinearLayout.setOnClickListener(this);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		if (position > 0) {
			leftImageView.setVisibility(View.VISIBLE);
			if (position == adapter.images.length - 1) {
				rightImageView.setVisibility(View.GONE);
				leftImageView.setVisibility(View.VISIBLE);
			} else {
				rightImageView.setVisibility(View.VISIBLE);
			}
		} else if (position == 0) {
			leftImageView.setVisibility(View.GONE);
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
