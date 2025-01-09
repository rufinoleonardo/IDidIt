package com.rufino.ididit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rufino.ididit.databinding.ItemTaskBinding
import com.rufino.ididit.ui.model.Task

class TaskAdapter(
    var tasks: List<Task>
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    inner class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        // layout inflation for specific item
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        // take the data and fill the view
        holder.binding.tvTaskTitle.text = tasks[position].description
        holder.binding.tvTaskPriority.text = tasks[position].priority
    }
}