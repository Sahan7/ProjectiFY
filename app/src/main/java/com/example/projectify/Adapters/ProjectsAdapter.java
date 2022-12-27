package com.example.projectify.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectify.Models.Projects;
import com.example.projectify.R;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder> {
// This is the Adapter class for user profile projects view

    // Define list of Projects and Context
    private List<Projects> projectsList;

    public ProjectsAdapter(List<Projects> projectsList) {
        this.projectsList = projectsList;
    }

    @NonNull
    @Override
    public ProjectsAdapter.ProjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tasks_view,parent,false);
        return new ProjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectsAdapter.ProjectsViewHolder holder, int position) {
        Projects projects = projectsList.get(position);
        holder.projects.setText(projects.getProject());
        holder.tasks.setText(projects.getTask());

        boolean isExpandable = projectsList.get(position).isExpandable();
        holder.linear_expandable.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return projectsList.size();
    }

    public class ProjectsViewHolder extends RecyclerView.ViewHolder {

        TextView projects;
        CheckedTextView tasks;
        LinearLayout linear_expandable,linear_nonexpandable;

        public ProjectsViewHolder(@NonNull View itemView) {
            super(itemView);

            projects = itemView.findViewById(R.id.project_num);
            tasks = itemView.findViewById(R.id.event_text);

            linear_expandable = itemView.findViewById(R.id.linear_expandable);
            linear_nonexpandable = itemView.findViewById(R.id.linear_nonexpandable);

            // Click on Listener
            linear_nonexpandable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Projects projects = projectsList.get(getAdapterPosition());
                    projects.setExpandable(!projects.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            //Click on Checkbox
        }
    }
}
