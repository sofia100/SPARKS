package com.example.android.sparks;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.sparks.models.Unit;
import com.example.android.sparks.services.Service;
import com.example.android.sparks.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context mContext = this;


        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Button createIdea = (Button) findViewById(R.id.idea_create);
        final EditText ideaName = (EditText) findViewById(R.id.idea_name);
        final EditText ideaDescription = (EditText) findViewById(R.id.idea_description);
        final EditText ideaOwner = (EditText) findViewById(R.id.idea_owner);
        final EditText ideaStatus = (EditText) findViewById(R.id.idea_status);

        createIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Unit newIdea = new Unit();
                newIdea.setName(ideaName.getText().toString());
                newIdea.setDescription(ideaDescription.getText().toString());
                newIdea.setStatus(ideaStatus.getText().toString());
                newIdea.setOwner(ideaOwner.getText().toString());

                Service ideaService = ServiceBuilder.buildService(Service.class);
                Call<Unit> request = ideaService.createIdea(newIdea);

                request.enqueue(new Callback<Unit>() {
                    @Override
                    public void onResponse(Call<Unit> request, Response<Unit> response) {
                        Intent intent = new Intent(mContext, ListAcitivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Unit> request, Throwable t) {
                        Toast.makeText(mContext, "Failed to create item.", Toast.LENGTH_SHORT).show();;
                    }
                });
            }
        });
    }
}
//sofia sunam