package com.rilu.resumecreator.Fragments;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.rilu.resumecreator.PojoClass.PersonalInfo;
import com.rilu.resumecreator.PojoClass.Resume;
import com.rilu.resumecreator.R;
import com.rilu.resumecreator.SubClasses.ResumeFragment;

public class PersonalInfoFragment extends ResumeFragment {


    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new PersonalInfoFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_personal_info, container, false);

        final PersonalInfo personalInfo = getResume().personalInfo;

        EditText nameEditText = root.findViewById(R.id.input_name);
        nameEditText.setText(personalInfo.getName());
        nameEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Log.d("TC", "beforeTC " + s.toString() + " " + s.subSequence(start, start + count).toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        EditText jobTitleEditText = root.findViewById(R.id.input_job_title);
        jobTitleEditText.setText(personalInfo.getJobTitle());
        jobTitleEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setJobTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText address1EditText = root.findViewById(R.id.input_address1);
        address1EditText.setText(personalInfo.getAddressLine1());
        address1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setAddressLine1(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText address2EditText = root.findViewById(R.id.input_address2);
        address2EditText.setText(personalInfo.getAddressLine2());
        address2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setAddressLine2(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText phoneEditText = root.findViewById(R.id.input_phone);
        phoneEditText.setText(personalInfo.getPhone());
        phoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setPhone(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText emailEditText = root.findViewById(R.id.input_email);
        emailEditText.setText(personalInfo.getEmail());
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return root;
    }
}
