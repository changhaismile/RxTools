package com.vondear.tools.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.vondear.rxtools.view.cardstackview.AdapterRxAllMoveDownAnimator;
import com.vondear.rxtools.view.cardstackview.RxCardStackView;
import com.vondear.rxtools.view.cardstackview.AdapterUpDownRxAnimator;
import com.vondear.rxtools.view.cardstackview.AdapterUpDownStackRxAnimator;
import com.vondear.tools.R;
import com.vondear.tools.adapter.AdapterTestRxStack;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityCardStack extends AppCompatActivity implements RxCardStackView.ItemExpendListener {

    @BindView(R.id.stackview_main)
    RxCardStackView mStackView;
    @BindView(R.id.button_container)
    LinearLayout mButtonContainer;

    public static Integer[] TEST_DATAS = new Integer[]{
            R.color.custom_progress_green_header,
            R.color.custom_progress_green_progress,
            R.color.background_content,
            R.color.custom_progress_orange_header,
            R.color.custom_progress_orange_progress,
            R.color.darkslategrey,
            R.color.forestgreen,
            R.color.custom_progress_blue_header,
            R.color.cadetblue,
            R.color.custom_progress_purple_header,
            R.color.mediumaquamarine,
            R.color.mediumseagreen,
            R.color.custom_progress_red_header,
            R.color.custom_progress_red_progress,
            R.color.coral,
            R.color.WARNING_COLOR,
            R.color.INFO_COLOR,
            R.color.SUCCESS_COLOR,
            R.color.ERROR_COLOR,
            R.color.mi_green,
            R.color.brown,
            R.color.brown1,
            R.color.brown2,
            R.color.brown3,
            R.color.orange,
            R.color.baby_blue
    };

    private AdapterTestRxStack mTestStackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_stack);
        ButterKnife.bind(this);

        mStackView.setItemExpendListener(this);
        mTestStackAdapter = new AdapterTestRxStack(this);
        mStackView.setAdapter(mTestStackAdapter);


        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        mTestStackAdapter.updateData(Arrays.asList(TEST_DATAS));
                    }
                }
                , 200
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_all_down:
                mStackView.setAdapterRxAnimator(new AdapterRxAllMoveDownAnimator(mStackView));
                break;
            case R.id.menu_up_down:
                mStackView.setAdapterRxAnimator(new AdapterUpDownRxAnimator(mStackView));
                break;
            case R.id.menu_up_down_stack:
                mStackView.setAdapterRxAnimator(new AdapterUpDownStackRxAnimator(mStackView));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onPreClick(View view) {
        mStackView.pre();
    }

    public void onNextClick(View view) {
        mStackView.next();
    }

    @Override
    public void onItemExpend(boolean expend) {
        mButtonContainer.setVisibility(expend ? View.VISIBLE : View.INVISIBLE);
    }
}