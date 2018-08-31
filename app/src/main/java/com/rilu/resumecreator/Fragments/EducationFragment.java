package com.rilu.resumecreator.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rilu.resumecreator.Adapter.EducationAdapter;
import com.rilu.resumecreator.Adapter.ResumeEventAdapter;
import com.rilu.resumecreator.EditActivity;
import com.rilu.resumecreator.PojoClass.Education;
import com.rilu.resumecreator.PojoClass.Resume;

import com.rilu.resumecreator.SubClasses.ResumeEventFragment;
import com.rilu.resumecreator.SubClasses.ResumeFragment;


public  class EducationFragment extends ResumeEventFragment<Education> {
    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new EducationFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    protected void delete(int pos) {
        getResume().education.remove(pos);
    }

    @Override
    public void onClick(int position) {
        Intent intent = EditActivity.getEducationIntent(getContext());
        EditActivity.setData(intent, position, getResume().education.get(position));
        startActivityForResult(intent, REQUEST_EDIT);
    }

    @Override
    protected void addClicked() {
        Intent intent = EditActivity.getEducationIntent(getContext());
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    protected ResumeEventAdapter<Education> getAdapter(View emptyView) {
        return new EducationAdapter(getResume().education, this)
                .setEmptyView(emptyView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ADD && resultCode == Activity.RESULT_OK) {
            getResume().education.add(new Education(EditActivity.getEvent(data)));
            notifyDataChanged();
        }
        if (requestCode == REQUEST_EDIT && resultCode == Activity.RESULT_OK) {
            int id = data.getIntExtra(EditActivity.FIELD_ID, -1);
            getResume().education.get(id).cloneThis(EditActivity.getEvent(data));
            notifyDataChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
