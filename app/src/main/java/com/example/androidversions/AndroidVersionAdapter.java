package com.example.androidversions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AndroidVersionAdapter
        extends RecyclerView.Adapter<AndroidVersionAdapter.VersionViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private final List<AndroidVersion> versionList;

    public AndroidVersionAdapter(Context context, List<AndroidVersion> versionList) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.versionList = versionList;
    }

    @NonNull
    @Override
    public VersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_android_version, parent, false);
        return new VersionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionViewHolder holder, int position) {
        AndroidVersion item = versionList.get(position);

        holder.imageLogo.setImageResource(item.getImageResId());
        holder.codeName.setText(item.getCodeName());
        holder.version.setText(item.getVersion());

        String name = item.getCodeName();
        if (name != null && name.length() > 0) {
            holder.initial.setText(name.substring(0, 1).toUpperCase());
        } else {
            holder.initial.setText("");
        }

        if (position % 2 == 0) {
            holder.cardRoot.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.row_even));
        } else {
            holder.cardRoot.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.row_odd));
        }
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        CardView cardRoot;
        ImageView imageLogo;
        TextView initial;
        TextView codeName;
        TextView version;

        VersionViewHolder(@NonNull View itemView) {
            super(itemView);
            cardRoot = itemView.findViewById(R.id.card_root);
            imageLogo = itemView.findViewById(R.id.image_logo);
            initial = itemView.findViewById(R.id.text_initial);
            codeName = itemView.findViewById(R.id.text_code_name);
            version = itemView.findViewById(R.id.text_version);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position == RecyclerView.NO_POSITION) {
                return;
            }
            AndroidVersion item = versionList.get(position);
            String message = "You selected: " + item.getCodeName()
                    + " (" + item.getVersion() + ")";
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}
