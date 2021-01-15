package com.example.movietraining;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.movietraining.adapter.MovieAdpater;
import com.example.movietraining.databinding.FragmentMovieBinding;

public abstract class BaseFragment extends Fragment {
    protected Activity mContext;
    private LayoutInflater inflater;
    private FragmentMovieBinding biding;
    private MovieAdpater movieAdpater;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        biding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        return biding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FragmentMovieBinding binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_movie);
        binding.setFragmentMovie(this);
        binding.rcvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rcvMovie.setAdapter(movieAdpater);
    }

    public abstract void callApiMoive();

}
