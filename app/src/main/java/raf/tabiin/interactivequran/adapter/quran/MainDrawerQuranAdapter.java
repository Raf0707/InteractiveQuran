package raf.tabiin.interactivequran.adapter.quran;

import static java.lang.String.format;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import raf.tabiin.interactivequran.R;
import raf.tabiin.interactivequran.object.DrawerNamesContent;

public class MainDrawerQuranAdapter extends RecyclerView.Adapter<MainDrawerQuranAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<DrawerNamesContent> namesDrawer;

    public MainDrawerQuranAdapter(Context context, List<DrawerNamesContent> namesDrawer) {
        this.namesDrawer = namesDrawer;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.listitem1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DrawerNamesContent newName = namesDrawer.get(position);

        holder.nameView1.setText(format("%s", newName.getNameDrawer()));

        holder.nameView1.setOnClickListener(v -> {
        });
    }

    @Override
    public int getItemCount() {
        return namesDrawer.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView1;

        ViewHolder(View view) {
            super(view);
            nameView1 = view.findViewById(R.id.name1);
        }
    }
}


