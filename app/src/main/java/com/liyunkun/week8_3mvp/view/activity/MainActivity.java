package com.liyunkun.week8_3mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.liyunkun.week8_3mvp.R;
import com.liyunkun.week8_3mvp.presenter.FoodPresenter;
import com.liyunkun.week8_3mvp.view.adapter.MyAdapter;
import com.liyunkun.week8_3mvp.view.intf.IFood;

public class MainActivity extends AppCompatActivity implements IFood{

    private ListView mLv;
    private FoodPresenter presenter=new FoodPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        presenter.load();
    }

    private void findView() {
        mLv = ((ListView) findViewById(R.id.lv));
    }

    @Override
    public void initData(MyAdapter adapter) {
        mLv.setAdapter(adapter);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
