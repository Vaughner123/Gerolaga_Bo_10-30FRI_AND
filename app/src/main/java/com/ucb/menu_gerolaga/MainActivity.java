package com.ucb.menu_gerolaga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Action Bar");
            getSupportActionBar().setSubtitle("Subtitle Example");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_first_fragment) {
            goToFirstFragment();
            return true;
        } else if (itemId == R.id.action_dialog) {
            openDialogFragment();
            return true;
        } else if (itemId == R.id.action_exit) {
            exitApp();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void goToFirstFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new FirstFragment())
                .addToBackStack(null) //
                .commit();
        Toast.makeText(this, "Navigating to First Fragment", Toast.LENGTH_SHORT).show();
    }

    public void openDialogFragment() {
        DialogFragmentExample dialog = new DialogFragmentExample();
        dialog.show(getSupportFragmentManager(), "dialog");
        Toast.makeText(this, "Opening Dialog", Toast.LENGTH_SHORT).show();
    }

    public void exitApp() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }
}
