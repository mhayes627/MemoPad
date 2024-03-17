package edu.jsu.mcis.cs408.memopad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        MemoPadModel model = new MemoPadModel();
        controller = new MemoPadController(model);


        /* Register Activity View and Model with Controller */

        controller.addView(this);
        controller.addModel(model);

        db = new DatabaseHandler(this, null, null, 1);
        updateRecyclerView();

        ButtonClickHandler click = new ButtonClickHandler();
        ConstraintLayout layout = binding.layout;

        for (int i = 0; i < layout.getChildCount(); ++i) {
            View child = layout.getChildAt(i);
            if(child instanceof Button) {
                child.setOnClickListener(click);
            }
        }

    }

    private class ButtonClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v){
            String tag = ((Button) v).getTag().toString();

            if (tag.equals("add_button")){
                String memo = binding.memoInput.getText().toString();
                controller.addNewMemo(db, new Memo(memo));
            }
            else if (tag.equals("delete_button")){

            }

        }
    }

    public void modelPropertyChange(PropertyChangeEvent evt) {

        updateRecyclerView();

    }

    private void updateRecyclerView() {

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getAllMemosAsList());
        binding.output.setHasFixedSize(true);
        binding.output.setLayoutManager(new LinearLayoutManager(this));
        binding.output.setAdapter(adapter);

    }


}