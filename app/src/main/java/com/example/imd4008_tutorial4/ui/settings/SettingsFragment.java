package com.example.imd4008_tutorial4.ui.settings;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.imd4008_tutorial4.R;
import com.example.imd4008_tutorial4.databinding.FragmentSettingsBinding;
import com.example.imd4008_tutorial4.ui.dashboard.DashboardViewModel;
import com.example.imd4008_tutorial4.ui.home.HomeViewModel;
import com.example.imd4008_tutorial4.ui.notifications.NotificationsViewModel;

public class SettingsFragment extends Fragment {
    private SettingsViewModel settingsViewModel;

    private HomeViewModel homeViewModel;
    private DashboardViewModel dashboardViewModel;
    private NotificationsViewModel notificationsViewModel;

    private SettingsViewModel mViewModel;
    private TextView counter;
    private TextView homeCounter;
    private TextView dashCounter;
    private TextView notificationsCounter;
    private Button increment;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        settingsViewModel = new ViewModelProvider(getActivity()).get(SettingsViewModel.class);

        homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);

        dashboardViewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);

        notificationsViewModel = new ViewModelProvider(requireActivity()).get(NotificationsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        increment = root.findViewById(R.id.settings_button);

        counter = root.findViewById(R.id.settings_counter);
        homeCounter = root.findViewById(R.id.home_counter_settings);
        dashCounter = root.findViewById(R.id.dashboard_counter_settings);
        notificationsCounter = root.findViewById(R.id.notification_counter_settings);

        counter.setText(Integer.toString(settingsViewModel.counter));
        homeCounter.setText(Integer.toString(homeViewModel.counter));
        dashCounter.setText(Integer.toString(dashboardViewModel.counter));
        notificationsCounter.setText(Integer.toString(notificationsViewModel.counter));

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("STATE", String.valueOf(homeViewModel.counter));
                settingsViewModel.counter++;
                counter.setText(Integer.toString(settingsViewModel.counter));
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
    }
}