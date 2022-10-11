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

    private DashboardViewModel dashboardViewModel;

    private TextView counter;
    private Button increment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(getActivity()).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        counter = root.findViewById(R.id.dashboard_counter_settings);
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
}