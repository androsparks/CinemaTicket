package com.ldt.cinematicket.ui.main.admin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashBoard extends SupportFragment {
    public static DashBoard newInstance() {
        return new DashBoard();
    }

    @BindView(R.id.back_button) ImageView mBackButton;
    @BindView(R.id.title) TextView mTitle;

    @OnClick(R.id.back_button)
    void back() {
        getMainActivity().dismiss();
    }

    @OnClick(R.id.see_all_movie_panel)
    void goToAllMoviePage() {
        getMainActivity().presentFragment(AllMovie.newInstance());
    }


    @Nullable
    @Override
    protected View onCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.admin_dash_board,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }
}