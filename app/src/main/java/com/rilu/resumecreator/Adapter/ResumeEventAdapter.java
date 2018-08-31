package com.rilu.resumecreator.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rilu.resumecreator.PojoClass.ResumeEvent;
import com.rilu.resumecreator.R;

import java.util.List;

public class ResumeEventAdapter<T extends ResumeEvent>
        extends RecyclerView.Adapter<ResumeEventAdapterViewHolder> {


    private List<T> list;
    private ResumeEventOnClickListener mResumeEventOnClickListener;

    public ResumeEventAdapter(@NonNull List<T> list,
                              ResumeEventOnClickListener resumeEventOnClickListener) {
        this.list = list;
        mResumeEventOnClickListener = resumeEventOnClickListener;
    }

    public interface ResumeEventOnClickListener {
        void onClick(int position);
    }

    @Override
    public ResumeEventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        ResumeEventAdapterViewHolder viewHolder =
                new ResumeEventAdapterViewHolder(itemView, mResumeEventOnClickListener);
        updateViewHolder(viewHolder);
        return viewHolder;
    }

    protected void updateViewHolder(ResumeEventAdapterViewHolder viewHolder) {

    }

    public ResumeEventAdapter<T> setEmptyView(final View emptyView) {
        this.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if (getItemCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                } else {
                    emptyView.setVisibility(View.INVISIBLE);
                }
            }
        });
        return this;
    }

    @Override
    public void onBindViewHolder(ResumeEventAdapterViewHolder holder, int position) {
        ResumeEvent event = list.get(position);
        holder.itemView.setTag(position);
        holder.institute.setText(event.getInstitute());
        holder.course.setText(event.getCourse());
        holder.cgpa.setText(event.getCgpa());
        holder.year.setText(event.getYear());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
