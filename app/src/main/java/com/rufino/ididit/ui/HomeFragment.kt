package com.rufino.ididit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.rufino.ididit.R
import com.rufino.ididit.TaskAdapter
import com.rufino.ididit.databinding.FragmentHomeBinding
import com.rufino.ididit.datasource.MockData

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addTaskFragment = AddTaskFragment()

        binding.fabNewTask.setOnClickListener{
            Toast.makeText(requireContext(), "FAB clicked", Toast.LENGTH_SHORT).show()
            parentFragmentManager.commit {
                replace(R.id.fl_fragment_container, addTaskFragment)
                addToBackStack(null)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView(){
        val tasks = MockData.data.getTasks()

        taskAdapter = TaskAdapter(tasks)

        binding.rvTasks.apply {
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}