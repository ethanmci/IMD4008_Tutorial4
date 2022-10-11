package com.example.imd4008_tutorial4.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.imd4008_tutorial4.R;
import com.example.imd4008_tutorial4.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private TextView counter;
    private Button increment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        counter = root.findViewById(R.id.home_counter);
        increment = root.findViewById(R.id.home_button);

        counter.setText(Integer.toString(homeViewModel.counter));
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeViewModel.counter++;
                counter.setText(String.valueOf(homeViewModel.counter));
            }
        });

        return root;
    }

}