package sg.edu.np.mad.madpractical4;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList<User> data;
    public UserAdapter(ArrayList<User> input, RecyclerViewInterface recyclerViewInterface) {
        data = input;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(item, recyclerViewInterface);
    }
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = data.get(position);
        if (user.name.charAt(user.name.length() - 1) != '7') {
            holder.name.setVisibility(View.VISIBLE);
            holder.description.setVisibility(View.VISIBLE);
            holder.smallimage.setVisibility(View.VISIBLE);
            holder.bigimage.setVisibility(View.GONE);
            holder.name.setText(user.name);
            holder.description.setText(user.description);

        }
        else {
            holder.name.setVisibility(View.GONE);
            holder.description.setVisibility(View.GONE);
            holder.smallimage.setVisibility(View.GONE);
            holder.bigimage.setVisibility(View.VISIBLE);
        }

    }
    public int getItemCount() {
        return data.size();
    }
}

