package com.ucb.bottomnavigationgerolaga;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {

    private static final String ARG_CONTENT = "content";
    private static final String ARG_IMAGE_RES_ID = "imageResId";

    public static DetailsFragment newInstance(String content, int imageResId) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, content);
        args.putInt(ARG_IMAGE_RES_ID, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        TextView contentTextView = view.findViewById(R.id.contentTextView);
        ImageView contentImageView = view.findViewById(R.id.contentImageView);

        if (getArguments() != null) {
            String content = getArguments().getString(ARG_CONTENT);
            int imageResId = getArguments().getInt(ARG_IMAGE_RES_ID);
            contentTextView.setText(content);
            contentImageView.setImageResource(imageResId);
        }

        return view;
    }
}
