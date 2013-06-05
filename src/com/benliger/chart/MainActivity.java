package com.benliger.chart;

import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.benliger.chart.view.PieDonutChart;

public class MainActivity extends Activity {
    private PieDonutChart mPie;
	private Resources mRes;
	private Random mRandomGenerator;

	/**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRes = getResources();
        mRandomGenerator = new Random(new Date().getTime());
        
        setContentView(R.layout.main);
        mPie = (PieDonutChart) this.findViewById(R.id.pie);
        mPie.addItem(20, mRes.getColor(R.color.holo_red_light));
        mPie.addItem(8, mRes.getColor(R.color.holo_green_light));
        mPie.addItem(3, mRes.getColor(R.color.holo_blue_light));
        
        ((Button)findViewById(R.id.button)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPie.deleteItems();
				mPie.addItem(mRandomGenerator.nextInt(100), mRes.getColor(R.color.holo_red_light));
		        mPie.addItem(mRandomGenerator.nextInt(100), mRes.getColor(R.color.holo_green_light));
		        mPie.addItem(mRandomGenerator.nextInt(100), mRes.getColor(R.color.holo_blue_light));
			}
		});
        
        ((SeekBar) findViewById(R.id.seekBar)).setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar current, int value, boolean arg2) {
				mPie.setRatioCircleInside((float) value/100f);
				
			}
		});
    }
}

