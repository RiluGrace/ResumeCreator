package com.rilu.resumecreator.Adapter;

import android.support.annotation.NonNull;

import com.rilu.resumecreator.PojoClass.Education;

import java.util.List;

public class EducationAdapter extends ResumeEventAdapter<Education> {

    public EducationAdapter(@NonNull List<Education> list,
                          ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }
}