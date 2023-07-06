package com.example.watchmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.watchmovie.DAO.CateItemDAO;
import com.example.watchmovie.adapter.MovieRecycler;
import com.example.watchmovie.model.CateItem;

import java.util.ArrayList;
import java.util.List;

public class addMovie extends AppCompatActivity {

    Context context=this;
    RecyclerView movieRecycler;
    MovieRecycler movieAdapter;
    List<CateItem> cateItemList=new ArrayList<>();
    CateItemDAO cateItemDAO;
    int cateId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        cateId= getIntent().getIntExtra("categoryId",0);

        cateItemDAO=new CateItemDAO(context);
        cateItemList.clear();

        cateItemList=cateItemDAO.getListCateItemWithCateId(cateId);
        setMovieAdapter(cateItemList);
    }

    void setMovieAdapter(List<CateItem> cateItemList)
    {
        movieRecycler=findViewById(R.id.movie_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        movieRecycler.setLayoutManager(layoutManager);
        movieAdapter=new MovieRecycler(this,cateItemList);
        movieRecycler.setAdapter(movieAdapter);
    }
}