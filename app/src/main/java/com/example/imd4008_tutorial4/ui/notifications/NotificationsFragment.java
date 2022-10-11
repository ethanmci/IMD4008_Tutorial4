package com.example.imd4008_tutorial4.ui.notifications;

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
import com.example.imd4008_tutorial4.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private TextView counter;
    private Button increment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = new ViewModelProvider(getActivity()).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        counter = root.findViewById(R.id.notification_counter_settings);
        increment = root.findViewById(R.id.notification_button);

        counter.setText(Integer.toString(notificationsViewModel.counter));
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationsViewModel.counter++;
                counter.setText(String.valueOf(notificationsViewModel.counter));
            }
        });

        return root;
    }
}