package com.ambulance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String[] title = {"Ambulance locator", "Emergency Chat"};
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridHome);

        MyAdapter adapter = new MyAdapter(this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i){
//                    case 0:intent = new Intent(MainActivity.this,)

                    case 1:intent =new Intent(MainActivity.this, ChatActivity.class);
                        startActivity(intent);

                }


            }
        });

    }
    class MyAdapter extends BaseAdapter {
        Context context;

        MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View gridView;
            if (convertView == null) {

                //gridView = new View(getContext());

                gridView = inflater.inflate(R.layout.grid_layout, parent, false);


                TextView textView = (TextView) gridView.findViewById(R.id.gridTitle);
                ImageView imageView = (ImageView) gridView.findViewById(R.id.gridImage);
                textView.setText(title[position]);
                //imageView.setImageResource(imgs[position]);


            } else {

                gridView = (View) convertView;
            }

            return gridView;
        }


    }

}

