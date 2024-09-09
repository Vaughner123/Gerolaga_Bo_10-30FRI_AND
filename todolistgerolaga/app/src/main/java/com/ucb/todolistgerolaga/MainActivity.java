package com.ucb.todolistgerolaga;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout todoContainer;
    private EditText editTextTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoContainer = findViewById(R.id.todoContainer);
        editTextTodo = findViewById(R.id.editTextTodo);
        Button buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(v -> {
            String todoText = editTextTodo.getText().toString();
            if (!todoText.isEmpty()) {
                addTodoItem(todoText);
                editTextTodo.setText(""); // Clear the input field
            }
        });
    }

    private void addTodoItem(String text) {
        // Inflate the custom item layout
        View todoView = LayoutInflater.from(this).inflate(R.layout.item_todo, todoContainer, false);

        // Find views inside the inflated layout
        CheckBox checkBox = todoView.findViewById(R.id.checkBox);
        TextView todoText = todoView.findViewById(R.id.todoText);
        ImageView imageView = todoView.findViewById(R.id.imageView);

        // Set the to-do text
        todoText.setText(text);

        // Handle checkbox click for edit/delete functionality
        checkBox.setOnClickListener(v -> {
            String[] options = {"Edit", "Delete"};
            new AlertDialog.Builder(this)
                    .setItems(options, (dialog, which) -> {
                        if (which == 0) {
                            // Edit the to-do item
                            editTodoItem(todoText);
                        } else {
                            // Delete the to-do item
                            todoContainer.removeView(todoView);
                        }
                    }).show();
        });

        // Add the to-do item to the container
        todoContainer.addView(todoView);
    }

    private void editTodoItem(TextView todoText) {
        // Create an EditText for editing the to-do item
        EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setText(todoText.getText().toString());

        // Show an alert dialog to edit the to-do item
        new AlertDialog.Builder(this)
                .setTitle("Edit To-Do")
                .setView(editText)
                .setPositiveButton("Save", (dialog, which) -> {
                    // Update the to-do text with the edited value
                    todoText.setText(editText.getText().toString());
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}