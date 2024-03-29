package com.example.samsungproject2.view.clubs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samsungproject2.R;
import com.example.samsungproject2.adapters.ClubsAdapter;
import com.example.samsungproject2.databinding.FragmentClubsBinding;
import com.example.samsungproject2.model.Club;
import com.example.samsungproject2.viewmodel.clubs.ClubsViewModel;

import java.util.List;


public class ClubsFragment extends Fragment implements ClubsAdapter.OnClubListener {

    private FragmentClubsBinding binding;
    private ClubsViewModel clubsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentClubsBinding.inflate(inflater, container, false);
        clubsViewModel = new ViewModelProvider(requireActivity()).get(ClubsViewModel.class);
        clubsViewModel.getClubListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Club>>() {
            @Override
            public void onChanged(List<Club> clubs) {
                binding.clubsRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.clubsRecyclerview.setAdapter(new ClubsAdapter(clubs, ClubsFragment.this));
            }
        });
        return binding.getRoot();
    }
    @Override
    public void onClubClick(String clubName) {
        Bundle bundle = new Bundle();
        bundle.putString("CLUB_NAME", clubName);
        bundle.putString("FROM", "clubs_fragment");
        Navigation.findNavController(getActivity().findViewById(R.id.nav_host_fragment))
                .navigate(R.id.action_bottom_nav_clubs_to_clubInfoFragment, bundle);
    }
}