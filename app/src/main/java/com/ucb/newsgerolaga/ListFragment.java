package com.ucb.newsgerolaga;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        String[] newsTitles = {
                "PAGASA: Signal No. 1 in parts of Luzon as Gener hastens approach",
                "Consumer group warns vs, vulnerability of Konektadong Pinoy bill",
                "Philippines still deadliest country in Asia for environmental defenders in 2023 – watchdog"
        };

        String[] newsDetails = {
                "Signal No. 1 is up in 19 areas in Luzon as Tropical Depression Gener accelerated while approaching Northern Luzon, PAGASA said on Monday night.\n" +
                        "\n" +
                        "advertisement\n" +
                        "\n" +
                        "According to its 8p.m. bulletin, PAGASA raised Signal No. 1 hoisted over the following areas:\n" +
                        "\n" +
                        "Cagayan including Babuyan Islands\n" +
                        "Isabela\n" +
                        "Quirino\n" +
                        "Nueva Vizcaya\n" +
                        "Apayao\n" +
                        "Kalinga\n" +
                        "Abra\n" +
                        "Ifugao\n" +
                        "Mountain Province\n" +
                        "Benguet\n" +
                        "Ilocos Norte\n" +
                        "Ilocos Sur\n" +
                        "La Union\n" +
                        "Pangasinan\n" +
                        "Zambales\n" +
                        "Tarlac\n" +
                        "Nueva Ecija\n" +
                        "Aurora\n" +
                        "The northern portion of Quezon (General Nakar, Infanta, Real) including Polillo Islands\n" +
                        "State meteorologists said Gener was spotted 240 kilometers east of Tuguegarao City, Cagayan.\n" +
                        "\n" +
                        "It moves northwestward at 15 kph, packing maximum sustained winds of 55 kilometers per hour (kph) near the center and gustiness of up to 70 kph.",
                "A consumer group has raised concern over Senate Bill No. 2699 or the Konektadong Pinoy Bill as some of its provisions are allegedly open to abuse. \n" +
                        "\n" +
                        "advertisement\n" +
                        "\n" +
                        "“Limiting or removing the oversight functions of the National Telecommunications Commission (NTC) would close the door for consumers to bring up their grievances against the inefficiency of foreign service providers,” Bantay Konsyumer, Kalsada, Kuryente (BK3) said in a statement.\n" +
                        "\n" +
                        "Author of the bill Senator Alan Peter Cayetano earlier said the Konektadong Pinoy Bill aims to improve access to fast and affordable connectivity nationwide.\n" +
                        "\n" +
                        "Under the proposed measure, “data transmission industry participants shall not be required to secure a legislative franchise or a Certificate of Public Convenience and Necessity (CPCN) but must meet the criteria set by the NTC in registering as industry participants in order to construct, operate, lease or own networks or facilities.”\n" +
                        "\n" +
                        "The bill also encourages sharing of infrastructure among telecom companies.",
                "MANILA, Philippines — The Philippines remains the most dangerous country in Asia for land and environmental defenders, accounting for 68% of the recorded killings and enforced disappearances in the region in 2023, the watchdog Global Witness found.\n" +
                        "\n" +
                        "Of the 25 defenders in Asia whose lives were taken away in 2023, 17 of them came from the Philippines, where 10 were killed and seven have disappeared. India recorded five such cases, while Indonesia had three. \n" +
                        "\n" +
                        "In 2023, a total of 196 defenders were killed or forcibly disappeared worldwide, with Colombia, Brazil, Honduras, Mexico and Philippines ranking as the top five most dangerous countries.\n" +
                        "\n" +
                        "“The Marcos Jr. administration has failed to stem the tide of violence against those protecting our environment and natural resources,” Kalikasan People’s Network for the Environment (Kaliaksan PNE) advocacy officer Jonila Castro said in a statement.\n" +
                        "\n" +
                        "“In fact, repression and militarization have worsened under this regime. Environmental defenders are being red-tagged, harassed, and murdered with impunity,” she added.\n" +
                        "\n" +
                        "\n" +
                        "Data shows that the targeted killings and enforced disappearances of green activists in the Philippines have risen by 54.5%, up from 11 cases in 2022. "
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
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).showContent(selectedNewsContent, selectedNewsImage);
                }
            }
        });

        return view;
    }
}
