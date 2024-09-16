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
                editTextTodo.setText("");
            }
        });
    }

    private void addTodoItem(String text) {
        View todoView = LayoutInflater.from(this).inflate(R.layout.item_todo, todoContainer, false);

        CheckBox checkBox = todoView.findViewById(R.id.checkBox);
        TextView todoText = todoView.findViewById(R.id.todoText);
        ImageView imageView = todoView.findViewById(R.id.imageView);

        todoText.setText(text);

        checkBox.setOnClickListener(v -> {
            String[] options = {"Edit", "Delete"};
            new AlertDialog.Builder(this)
                    .setItems(options, (dialog, which) -> {
                        if (which == 0) {
                            editTodoItem(todoText);
                        } else {
                            todoContainer.removeView(todoView);
                        }
                    }).show();
        });

        todoContainer.addView(todoView);
    }

    private void editTodoItem(TextView todoText) {
        EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setText(todoText.getText().toString());

        new AlertDialog.Builder(this)
                .setTitle("Edit To-Do")
                .setView(editText)
                .setPositiveButton("Save", (dialog, which) -> {
                    todoText.setText(editText.getText().toString());
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}