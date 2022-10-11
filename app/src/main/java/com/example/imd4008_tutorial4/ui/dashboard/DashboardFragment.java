package com.example.imd4008_tutorial4.ui.dashboard;

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
import com.example.imd4008_tutorial4.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    private TextView counter;
    private Button increment;
    int count = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        counter = root.findViewById(R.id.dashboard_counter);
        increment = root.findViewById(R.id.dashboard_button);

        counter.setText(Integer.toString(dashboardViewModel.counter));
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardViewModel.counter++;
                counter.setText(String.valueOf(dashboardViewModel.counter));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}