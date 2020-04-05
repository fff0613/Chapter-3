package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView animationView;
    private AnimatorSet animatorSet;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<String> strings = new ArrayList<String>();
        strings.add("item1");
        strings.add("item2");
        strings.add("item3");
        strings.add("item4");
        strings.add("item5");
        strings.add("item6");

        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = view.findViewById(R.id.animation_view2);
        listView = (ListView)view.findViewById(R.id.list_numbers);
        listView.setAdapter(new ArrayAdapter<String>(container.getContext(),android.R.layout.simple_list_item_1,strings));
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,"alpha",1f,0f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(listView,"alpha",0f,1f);
                animator1.setDuration(1000);
                animator2.setDuration(1000);

                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1,animator2);
                animatorSet.start();
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
