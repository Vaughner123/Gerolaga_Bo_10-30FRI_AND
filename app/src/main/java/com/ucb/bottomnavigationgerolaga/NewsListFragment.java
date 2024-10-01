package com.ucb.bottomnavigationgerolaga;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class NewsListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        String[] newsTitles = {
                "PAGASA: Signal No. 1 in parts of Luzon as Gener hastens approach",
                "Consumer group warns vs, vulnerability of Konektadong Pinoy bill",
                "Philippines still deadliest country in Asia for environmental defenders in 2023 – watchdog"
        };

        String[] newsDetails = {
                "Signal No. 1 is up in 19 areas in Luzon as Tropical Depression Gener accelerated while approaching Northern Luzon...",
                "A consumer group has raised concern over Senate Bill No. 2699 or the Konektadong Pinoy Bill...",
                "MANILA, Philippines — The Philippines remains the most dangerous country in Asia for land and environmental defenders..."
        };

        int[] newsImages = {
                R.drawable.weather,
                R.drawable.consumers,
                R.drawable.environment
        };

        ListView listView = view.findViewById(R.id.news_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, newsTitles);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedNewsContent = newsDetails[position];
                int selectedNewsImage = newsImages[position];

                if (getActivity() != null) {
                    DetailsFragment detailsFragment = DetailsFragment.newInstance(selectedNewsContent, selectedNewsImage);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, detailsFragment)
                            .addToBackStack(null) // Allow user to navigate back
                            .commit();
                }
            }
        });

        return view;
    }
}
