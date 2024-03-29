package com.example.badapples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.badapples.Server.post;

public class FilesAdapter extends RecyclerView.Adapter<FilesAdapter.ViewHolder> {

    String[] backUpFiles;
    Context context;
    int File;

    public FilesAdapter(String[] backUpFiles, Context context, int File){
        this.backUpFiles = backUpFiles;
        this.context = context;
        this.File = File;
    }

    @NonNull
    @Override
    public FilesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_import, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilesAdapter.ViewHolder holder, int position) {
        holder.btnImportAdapter.setText(backUpFiles[position]);

        // create an intent to open the FileActivity and then create bundle pass File argument inside intent
        Intent openFileActivity = new Intent(context, FileActivity.class);
        Bundle bundle = new Bundle();
        holder.btnImportAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send filename to server to create temp
                String servlet = String.format("http://10.0.2.2:8080/BadAPPles/CreateTempServlet?param1=%1$s&param2=%2$s",
                                                Integer.toString(File), backUpFiles[position]);
                post(context, servlet);

                // add the File argument 0 to the intent and start the FileActivity
                bundle.putInt("File", File);
                bundle.putString("backUpFile", backUpFiles[position]);
                openFileActivity.putExtras(bundle);
                context.startActivity(openFileActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return backUpFiles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button btnImportAdapter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnImportAdapter = itemView.findViewById(R.id.btnImport_Adapter);
        }
    }
}
