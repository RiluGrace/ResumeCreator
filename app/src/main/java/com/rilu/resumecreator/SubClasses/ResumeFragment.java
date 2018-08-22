package com.rilu.resumecreator.SubClasses;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rilu.resumecreator.PojoClass.Resume;
import com.rilu.resumecreator.R;


public class ResumeFragment extends Fragment {

    public static final String ARGUMENT_RESUME = "resume";

    public void setResume(Resume resume) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARGUMENT_RESUME, resume);
        setArguments(bundle);
    }

    public Resume getResume() {
        return getArguments().getParcelable(ARGUMENT_RESUME);
    }
}
