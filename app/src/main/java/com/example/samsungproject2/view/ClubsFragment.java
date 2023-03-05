package com.example.samsungproject2.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samsungproject2.R;
import com.example.samsungproject2.databinding.FragmentClubsBinding;


public class ClubsFragment extends Fragment {

    private FragmentClubsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentClubsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}