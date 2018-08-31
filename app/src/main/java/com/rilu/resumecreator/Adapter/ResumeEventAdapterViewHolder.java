package com.rilu.resumecreator.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rilu.resumecreator.R;

class ResumeEventAdapterViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
        ResumeEventAdapter.ResumeEventOnClickListener mResumeEventOnClickListener;
        TextView institute , course , cgpa , year;


public ResumeEventAdapterViewHolder(View itemView, ResumeEventAdapter.ResumeEventOnClickListener resumeEventOnClickListener) {
        super(itemView);
        institute = itemView.findViewById(R.id.institute);
        course = itemView.findViewById(R.id.course);
        cgpa = itemView.findViewById(R.id.cgpa);
        year = itemView.findViewById(R.id.year);
        mResumeEventOnClickListener = resumeEventOnClickListener;
        itemView.setOnClickListener(this);
        }

@Override
public void onClick(View v) {
        mResumeEventOnClickListener.onClick(getAdapterPosition());
        }
        }