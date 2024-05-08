package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Random rand = new Random();
        for (int i = 1; i <= 20; i++) {
            int name = Math.abs(rand.nextInt());
            int description = Math.abs(rand.nextInt());
            User user = new User("Name"+name, "description "+description, i, false);
            users.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.RVprofile);
        UserAdapter mAdapter = new UserAdapter(users, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }


    public void onItemClick(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Profile");
        builder.setMessage(users.get(position).name);
        builder.setCancelable(true);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent activityMain = new Intent(ListActivity.this, MainActivity.class);
                activityMain.putExtra("Name",users.get(position).name);
                activityMain.putExtra("Desc",users.get(position).description);
                startActivity(activityMain);
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
