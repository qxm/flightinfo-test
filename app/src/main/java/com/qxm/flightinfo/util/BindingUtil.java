package com.qxm.flightinfo.util;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.qxm.flightinfo.adapter.SimpleAdapter;
import com.qxm.flightinfo.model.Roster;

import java.util.List;

public class BindingUtil {
    @BindingAdapter("items")
    public static void setItem(RecyclerView rv, List<Roster> items) {
        if (items != null) {
            SimpleAdapter<Roster> adapter = (SimpleAdapter<Roster>) rv.getAdapter();

            adapter.refreshData(items);
        }
    }
}
