/* Copyright (C) 2012 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.benliger.chart;

import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
    }
}

