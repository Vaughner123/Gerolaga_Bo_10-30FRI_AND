package com.ucb.newsgerolaga;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if (findViewById(R.id.fragment_container_2) != null) {
                transaction.replace(R.id.fragment_container_1, new ListFragment());
                transaction.replace(R.id.fragment_container_2, ContentFragment.newInstance("Select a news item", R.drawable.weather));
            } else {
                transaction.replace(R.id.fragment_container, new ListFragment());
            }

            transaction.commit();
        }
    }

    public void showContent(String content, int imageResId) {
        if (findViewById(R.id.fragment_container_2) != null) {
            ContentFragment contentFragment = ContentFragment.newInstance(content, imageResId);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_2, contentFragment)
                    .commit();
        } else {
            ContentFragment contentFragment = ContentFragment.newInstance(content, imageResId);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, contentFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
