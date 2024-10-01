package com.ucb.bottomnavigationgerolaga;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private EditText nameEditText;
    private RadioGroup genderRadioGroup;
    private CheckBox termsCheckBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        nameEditText = view.findViewById(R.id.nameEditText);
        genderRadioGroup = view.findViewById(R.id.genderRadioGroup);
        termsCheckBox = view.findViewById(R.id.checkboxTerms);

        Button saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> saveProfile());

        return view;
    }

    private void saveProfile() {
        String name = nameEditText.getText().toString();
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        boolean termsAccepted = termsCheckBox.isChecked();

    }
}
