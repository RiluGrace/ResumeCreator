package com.rilu.resumecreator.SubClasses;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rilu.resumecreator.Adapter.ResumeEventAdapter;
import com.rilu.resumecreator.PojoClass.ResumeEvent;
import com.rilu.resumecreator.R;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public abstract class ResumeEventFragment<T extends ResumeEvent> extends ResumeFragment implements ResumeEventAdapter.ResumeEventOnClickListener {
    public static final int REQUEST_ADD = 1;
    public static final int REQUEST_EDIT = 2;

    RecyclerView recyclerView;

    protected abstract void addClicked();

    protected abstract ResumeEventAdapter<T> getAdapter(View emptyView);

    protected abstract void delete(int pos);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        View emptyView = view.findViewById(android.R.id.empty);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(getAdapter(emptyView));
        setUpItemTouchHelper();
        return view;
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,  ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(getActivity(),"Deleted Successfully" , Toast.LENGTH_SHORT).show();
                delete((int) viewHolder.itemView.getTag());
                notifyDataChanged();
            }

            @Override
            public void onChildDraw (Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,float dX, float dY,int actionState, boolean isCurrentlyActive){
                new RecyclerViewSwipeDecorator.Builder(getActivity(), c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

                        .addSwipeRightBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent))
                        .addSwipeRightActionIcon(R.drawable.ic_delete_white_24dp)
                        .create()
                        .decorate();
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);


            }

        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void notifyDataChanged() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            addClicked();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(int position) {

    }
}
