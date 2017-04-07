package org.goodev.recyclerviewutils.diffutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.goodev.recyclerviewutils.R;

public class DiffUtilActivity extends AppCompatActivity {
    private ActorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_util);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ActorAdapter(ActorRepository.getActorListSortedByRating());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_by_name:
                adapter.swapItems(ActorRepository.getActorListSortedByName());
                return true;
            case R.id.sort_by_rating:
                adapter.swapItems(ActorRepository.getActorListSortedByRating());
                return true;
            case R.id.sort_by_birth:
                adapter.swapItems(ActorRepository.getActorListSortedByYearOfBirth());
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
