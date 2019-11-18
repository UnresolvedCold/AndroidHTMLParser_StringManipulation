package com.schwifty.factly_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class UnlimitedPager extends AppCompatActivity {

    ViewPager pager;
    List<View> views;
    Pager pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlimited_pager);

        pager = findViewById(R.id.pager);

        views = new ArrayList<>();
        pagerAdapter = new Pager(views, this);
        pager.setAdapter(pagerAdapter);

        AddPage("yo","Headline");
        AddPage("man","Headline");

        GetPageContents();

    }

    private void GetPageContents()
    {
        String url="http://factly.forumias.com/";


        Ion.with(getApplicationContext())
                .load(url)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result)
                    {

                        Log.d("HTML",result);
                    }
                });
    }

    public void AddPage(String date,String newsHeadline)
    {
        LayoutInflater inflater = LayoutInflater.from(this);;
        View mView = inflater.inflate(R.layout.activity_main_page, null, false);
        TextView vDate = mView.findViewById(R.id.date);
        vDate.setText(date);

        TextView vNewsHeadline = mView.findViewById(R.id.newsHeadline);
        vNewsHeadline.setText(newsHeadline);

        views.add(views.size(), mView);
        pagerAdapter.notifyDataSetChanged();
    }
}
