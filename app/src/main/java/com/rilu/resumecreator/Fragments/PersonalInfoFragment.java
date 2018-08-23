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

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalInfoFragment extends ResumeFragment {

    @BindView(R.id.personal_name)
    EditText P_Name;

    @BindView(R.id.personal_email)
    EditText P_Email;

    @BindView(R.id.personal_job)
    EditText P_Job;

    @BindView(R.id.personal_address1)
    EditText P_Addr;

    @BindView(R.id.personal_address2)
    EditText P_Address;

    @BindView(R.id.personal_phone)
    EditText P_No;



    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new PersonalInfoFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_personal_info, container, false);

        // butterknife..
        ButterKnife.bind(this,root);

        final PersonalInfo personalInfo = getResume().personalInfo;



        P_Name.setText(personalInfo.getName());
        P_Name.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        P_Email.setText(personalInfo.getEmail());
        P_Email.addTextChangedListener(new TextWatcher() {
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

        P_Job.setText(personalInfo.getJobTitle());
        P_Job.addTextChangedListener(new TextWatcher()
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

        P_Addr.setText(personalInfo.getAddressLine1());
        P_Addr.addTextChangedListener(new TextWatcher() {
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

        P_Address.setText(personalInfo.getAddressLine2());
        P_Address.addTextChangedListener(new TextWatcher() {
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

        P_No.setText(personalInfo.getPhone());
        P_No.addTextChangedListener(new TextWatcher() {
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


        return root;
    }
}
