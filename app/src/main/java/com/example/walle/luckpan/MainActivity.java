package com.example.walle.luckpan;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.walle.luckpan.bean.HouDongDetailEntity;
import com.example.walle.luckpan.luckypan.OnCallBackPosition;
import com.example.walle.luckpan.luckypan.OnTouchCenterListener;
import com.example.walle.luckpan.luckypan.RotateLayoutView;
import com.example.walle.luckpan.utils.ButtonUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.rv_rotatelayoutview)
    RotateLayoutView mRotateLayoutView;

    private final String[] IMAGE_URL = new String[] {"https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg",
                                                    "https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg",
                                                    "https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg",
                                                    "https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg",
                                                    "https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg",
                                                    "https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg"};

    private int count = 6;

    List<Object> imagesBit = new ArrayList<>();
    List<String> names = new ArrayList<>();
    private OnCallBackPosition onCallBackPosition;
    private HouDongDetailEntity detailEntity;
    private List<HouDongDetailEntity.DataBean.SubDataBean.PrizesBean> detailList;
    private int numBit = 0;

    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mActivity = this;

        //开启抽奖按钮
        mRotateLayoutView.setOnTouchCenterListener(new OnTouchCenterListener() {
            @Override
            public void onTouchCenter() {
                if (!ButtonUtils.isFastDoubleClick()) {
                    //抽奖
                    //这里的pos已经决定了最终是什么奖品
                    // pos = -1 真的随机
                    // pos = 1奖品就是元素序号为1的奖品
                    // ToastUtils.showShort("位置：" + names.get(pos));

                    mRotateLayoutView.startAnimation(-1);
                    mRotateLayoutView.setOnCallBackPosition(-1,onCallBackPosition);
                }
            }
        });

        prepareDefaultData();

        //初始化奖品数据
        parseDataFromServer();

        //中奖弹窗
        onCallBackPosition = new OnCallBackPosition() {
            @Override
            public void getStopPosition(int pos) {
                //中奖弹窗
                Toast.makeText(mActivity, pos + "",Toast.LENGTH_SHORT).show();
            }
        };
    }

    /**
     * 准备初始化数据，避免获取网络图片之前转为黑色
     */
    private void prepareDefaultData() {
        int default_count = 8;
        List<String> prizeNames = new ArrayList<>();
        List<Object> prizeImages = new ArrayList<>();
        for (int i = 0; i < default_count; i++) {
            prizeNames.add("奖品" + i);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.prize);
            prizeImages.add(bitmap);
        }
        mRotateLayoutView.setStrName(prizeNames);
        mRotateLayoutView.setImageIcon(prizeImages);
    }

    /**
     * 模拟数据
     * 这些数据应该是网络请求来的
     */
    private void parseDataFromServer() {
        detailEntity = new HouDongDetailEntity();
        detailEntity.setStatus_code("200");
        detailEntity.setMessage("ok");

        HouDongDetailEntity.DataBean dataBean = new HouDongDetailEntity.DataBean();
        HouDongDetailEntity.DataBean.SubDataBean subDataBean = new HouDongDetailEntity.DataBean.SubDataBean();
        ArrayList<HouDongDetailEntity.DataBean.SubDataBean.PrizesBean> list = new ArrayList<HouDongDetailEntity.DataBean.SubDataBean.PrizesBean>();
        for (int i = 0; i < count; i++) {
            HouDongDetailEntity.DataBean.SubDataBean.PrizesBean prizesBean = new HouDongDetailEntity.DataBean.SubDataBean.PrizesBean();
            prizesBean.setId(i);
            prizesBean.setName("奖品" + i);
            prizesBean.setImage(IMAGE_URL[i]);
            list.add(prizesBean);
        }
        subDataBean.setPrizes(list);
        dataBean.setSub_data(subDataBean);
        detailEntity.setData(dataBean);


        detailList = detailEntity.getData().getSub_data().getPrizes();

        for (int i = 0; i < detailList.size(); i++) {
            imagesBit.add("");
        }
        for (int i = 0; i < detailList.size(); i++) {
            names.add(detailList.get(i).getName());
            returnBitMap(detailList.get(i).getImage(), i);
        }
    }

    // 消息处理器
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            imagesBit = (List<Object>) msg.obj;
            mRotateLayoutView.resetData();
            mRotateLayoutView.setStrName(names);
            mRotateLayoutView.setImageIcon(imagesBit);
        }
    };

    public void returnBitMap(final String url, final int position) {
        Log.i(TAG,"位置11111== " + position);
        new Thread(new Runnable() {


            @Override
            public void run() {

                URL imageurl = null;
                try {
                    imageurl = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection conn = (HttpURLConnection) imageurl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
//                    LogUtils.i("位置== " + position);
                    addList(bitmap,position);

                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();


    }
    public synchronized void addList(Bitmap bitmap , int position){
        synchronized (this){
            Message msg = Message.obtain();
            imagesBit.set(position, bitmap);
            numBit++;
//            LogUtils.i("numbit == " + numBit +"  position=== "+position);
            if (numBit == imagesBit.size()) {
                msg.obj = imagesBit;
                if (mHandler != null) {
                    mHandler.sendMessage(msg);
                }
            }
        }
    }


}
