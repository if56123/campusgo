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
	 * ��Ʒ����
	 */
	private TextView productNameTextView = null;
	
	/**
	 * ��Ʒ�۸�����:һ�ڼۻ���������
	 */
	private TextView priceNameTextView = null;
	
	/**
	 * ��Ʒ�۸����ۼ۸�
	 */
	private TextView priceTextView = null;
	
	/**
	 * ԭ��
	 */
	private TextView originalPriceTextView = null;
	
	/**
	 * У�ʹ��۸�
	 */
	private TextView campusGoPriceTextView = null;
	
	/**
	 * ��ȡ��ϵ��ʽ
	 */
	private TextView getContactInfoTextView = null;
	
	/**
	 * ��ע�ղ�
	 */
	private TextView collectProductTextView = null;
	
	/**
	 * �ϼ�ʱ��
	 */
	private TextView timeTextView = null;
	
	/**
	 * �ͺ�
	 */
	private TextView marqueTextView = null;
	
	/**
	 * ��ɫ
	 */
	private TextView qualityTextView = null;

	/**
	 * ��Ʒ����
	 */
	private TextView productNumTextView = null;
	
	/**
	 * ��Ʒ����
	 */
	private TextView productDescTextView = null;
	
	/**
	 * ��ɫ
	 */
	private TextView colorTextView = null;
	
	
	/**
	 * �ղ�
	 */
	private TextView collectTextView = null;

	/**
	 * ��ƷͼƬչʾ
	 */
	private BrandGallery imagesGallery = null;
	
	/**
	 * ��߼�ͷ��ť
	 */
	private ImageView leftImageView = null;
	
	/**
	 * �ұ߼�ͷ��ť
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
		// ȥ���ֻ�����Ĭ�ϱ���
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.letao_type_commodity_infor);
		// �ֻ������������
		super.textViewTitle = (TextView) findViewById(R.id.title);
		super.textViewTitle.setText(R.string.app_name);

		this.initTextViewAll();
	}

	@Override
	public void onClick(View view) {
		if (view == getContactInfoTextView) {
			Toast toast = Toast.makeText(getApplicationContext(), "��ȡ��ϵ��Ϣ�ɹ�!",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} else if (view == collectProductTextView) {
			Toast toast = Toast.makeText(getApplicationContext(), "��ע�ɹ�!",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} else if (view == collectTextView) {
			Toast toast = Toast.makeText(getApplicationContext(), "�ղسɹ�!",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} else if (view == codeLinearLayout) {//
			// codeTextView.setBackgroundColor(Color.RED);
			new AlertDialog.Builder(this)
					.setTitle("��ĽŶ�󰡣�")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setSingleChoiceItems(
							new String[] { "41", "42", "43", "44", "45" }, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {

								}
							}).setNegativeButton("ȷ��", null).show();

			System.out.println("TanRuixiang");
		}
		;

	}

	/**
	 * ����(��)���пؼ�
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
		priceNameTextView.setText("һ�ڼ�:");
		priceTextView = (TextView) findViewById(R.id.value_specially_price);
		priceTextView.setText(Integer.toString(product.getPrice()));
		// ��������ť
		getContactInfoTextView = (TextView) findViewById(R.id.detail_tobuymust_button);
		getContactInfoTextView.setOnClickListener(this);
		// ���빺�ﳵ��ť
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
		colorTextView.setText("��,��,��,��");
		originalPriceTextView = (TextView) findViewById(R.id.value_counter_price);
		originalPriceTextView.setText("$150");
		campusGoPriceTextView = (TextView) findViewById(R.id.value_letao_price);
		campusGoPriceTextView.setText("$120");
		// �ղذ�ť
		collectTextView = (TextView) findViewById(R.id.detail_favorite_button);
		collectTextView.setOnClickListener(this);
		// ��ƷͼƬչʾ
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
