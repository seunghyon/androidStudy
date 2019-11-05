package com.example.room_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.room_exam.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private EditText mTodoEditText;
    //private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLifecycleOwner(this);
        //mTodoEditText = findViewById(R.id.todo_edit);
        //mResultTextView = findViewById(R.id.result_text);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        binding.setViewModel(viewModel);

        /*
        // UI 갱신
        viewModel.getAll().observe(this, todos -> {
            //mResultTextView.setText(todos.toString());
            binding.resultText.setText(todos.toString());
        });
        */

        /*
        // 버튼 클릭 시 DB에 insert
        findViewById(R.id.add_button).setOnClickListener(v -> {
            //viewModel.insert(new Todo(mTodoEditText.getText().toString()));
            viewModel.insert(new Todo(binding.todoEdit.getText().toString()));
        });
         */
    }
}
