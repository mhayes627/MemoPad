package edu.jsu.mcis.cs408.memopad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import java.beans.PropertyChangeEvent;

import edu.jsu.mcis.cs408.memopad.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AbstractView{

    private MemoPadController controller;
    private ActivityMainBinding binding;

    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        MemoPadModel model = new MemoPadModel("Default Note");
        controller = new MemoPadController(model);


        /* Register Activity View and Model with Controller */

        controller.addView(this);
        controller.addModel(model);

        db = new DatabaseHandler(this, null, null, 1);
        updateRecyclerView();

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewMemo();
            }
        });


    }

    public void addNewMemo() {

        String note = binding.memoInput.getText().toString();
        db.addMemo(new Memo(note));
        updateRecyclerView();

    }

    private void updateRecyclerView() {

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getAllMemosAsList());
        binding.output.setHasFixedSize(true);
        binding.output.setLayoutManager(new LinearLayoutManager(this));
        binding.output.setAdapter(adapter);

    }

    public void modelPropertyChange(final PropertyChangeEvent evt) {


    }
}