package com.example.seducation.ui.sobrenos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.seducation.databinding.FragmentSobreNosBinding;


public class SobrenosFragment extends Fragment {

    private FragmentSobreNosBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SobreNosViewModel sobreNosViewModel =
                new ViewModelProvider(this).get(SobreNosViewModel.class);

        binding = FragmentSobreNosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSobrenos;
        sobreNosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
