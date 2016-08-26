package com.bjw.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Action1;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSetview;
    private TextView mTv;
    private ImageView mImage;
    private List<AppInfo> mSystemApps;
    private List<AppInfo> mUserApps;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnSetview = (Button) findViewById(R.id.btn_setview);
        mTv = (TextView) findViewById(R.id.tv);

        mBtnSetview.setOnClickListener(this);
        mImage = (ImageView) findViewById(R.id.image);
        mImage.setOnClickListener(this);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    private void getMovie() {
        String uri = "https://api.thinkpage.cn";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        IWeather iWeather = retrofit.create(IWeather.class);
        Call<WeatherBean> call = iWeather.weather("rot2enzrehaztkdk", "beijing");
        call.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                WeatherBean weatherBean = response.body();
                Logger.i(weatherBean.results.get(0).now.temperature + "");
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_setview:
                getMovie();
/*                Observer observer = new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("Completed");
                        mTv.setText("Completed");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Logger.d(s);
                    }
                };
                Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("哈哈");
                        subscriber.onNext("呵呵");
                        subscriber.onCompleted();
                    }
                });
                Subscriber subscriber = new Subscriber() {
                    @Override
                    public void onCompleted() {
                        Logger.d("xixi");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {
                        Logger.d("xixi");
                    }
                };
                observable.subscribe(observer);
                observable.subscribe(subscriber);
                Observable.from(new String[]{"ddd", "aaa", "dadad"}).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.e(s);
                    }
                });*/
/*                Observable.just(1, 2, 3, 4)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer integer) {
                                Logger.e(integer + "");
                            }
                        });
                Observable.create(new Observable.OnSubscribe<Drawable>() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void call(Subscriber<? super Drawable> subscriber) {
                        Drawable drawable = getTheme().getDrawable(R.mipmap.ic_launcher);
                        subscriber.onNext(drawable);
                        subscriber.onCompleted();
                        Logger.w("getDrawable");
                    }
                })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Drawable>() {
                            @Override
                            public void call(Drawable drawable) {
                                mImage.setImageDrawable(drawable);
                                Logger.w("setImage");
                            }
                        });*/
/*                AppinfoProvider.getAllAppInfo(this)
                        .flatMap(new Func1<List<AppInfo>, Observable<AppInfo>>() {
                            @Override
                            public Observable<AppInfo> call(List<AppInfo> appInfos) {
                                Logger.w("ddddddddddd3");
                                return Observable.from(appInfos);
                            }
                        })
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {
                                Logger.w("ddddddddddd2");
                                mSystemApps = new ArrayList<>();
                                mUserApps = new ArrayList<>();
                            }
                        })
                        .subscribe(new Action1<AppInfo>() {
                            @Override
                            public void call(AppInfo appInfo) {
                                Logger.i(appInfo.getAppName());
                                boolean isSystemApp = appInfo.getIsSystemApp();
                                if (isSystemApp) {
                                    mSystemApps.add(appInfo);
                                } else {
                                    mUserApps.add(appInfo);
                                }
                            }
                        });
                Logger.w(mSystemApps.size()+"");
                Logger.w(mUserApps.size()+"");*/
                Observable.interval(2000, TimeUnit.MILLISECONDS)
                        .subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {
                                Logger.e(aLong+"");
                            }
                        });
/*                rx.Observable.create(new Observable.OnSubscribe<List<String>>() {
                    @Override
                    public void call(Subscriber<? super List<String>> subscriber) {
                        AppinfoProvider
                    }
                }).flatMap(new Func1<List<String>, rx.Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> strings) {
                        return rx.Observable.from(strings);
                    }
                }).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.i(s);
                    }
                });
                Logger.i("55555555");*/
  /*              Observable.create(new Observable.OnSubscribe<Drawable>() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void call(Subscriber<? super Drawable> subscriber) {
                        Drawable drawable = getTheme().getDrawable(R.mipmap.ic_launcher);
                        subscriber.onNext(drawable);
                        subscriber.onCompleted();
                        Logger.w("getDrawable");
                    }
                })
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {
                                //mImage.setVisibility(View.INVISIBLE);
                                Logger.e("setVisibility");
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        //.observeOn(Schedulers.io())
                        .subscribe(new Action1<Drawable>() {
                            @Override
                            public void call(Drawable drawable) {
                                mImage.setImageDrawable(drawable);
                                Logger.w("setImage");
                            }
                        });*/
                break;
            case R.id.button:
                Logger.i(mSystemApps.size() + "");
                Logger.i(mUserApps.size() + "");
                break;
        }
    }
}
