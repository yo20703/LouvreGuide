package com.ukn.edu.louvreguide.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ukn.edu.louvreguide.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransportationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransportationFragment extends Fragment {
    public TransportationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transportation, container, false);
    }
}