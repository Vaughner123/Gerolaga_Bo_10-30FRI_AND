package com.ucb.newsgerolaga;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentFragment extends Fragment {

    private static final String ARG_CONTENT = "content";
    private static final String ARG_IMAGE_RES = "image_res";

    public static ContentFragment newInstance(String content, int imageResId) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, content);
        args.putInt(ARG_IMAGE_RES, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        String content = getArguments().getString(ARG_CONTENT);
        int imageResId = getArguments().getInt(ARG_IMAGE_RES);

        TextView contentTextView = view.findViewById(R.id.content_text);
        contentTextView.setText(content);

        ImageView newsImageView = view.findViewById(R.id.news_image);
        newsImageView.setImageResource(imageResId);

        return view;
    }
}
