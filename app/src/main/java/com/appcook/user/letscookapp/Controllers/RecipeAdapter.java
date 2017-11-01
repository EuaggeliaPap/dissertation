package com.appcook.user.letscookapp.Controllers;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appcook.user.letscookapp.Model.Recipe;
import com.appcook.user.letscookapp.R;
import com.bumptech.glide.Glide;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    private Activity activity;
    private int resourceId;
    private List<Recipe> lista;
    private ViewHolder holder;

    public RecipeAdapter(Activity activity, int resourceId, List<Recipe> lista) {
        super(activity, resourceId, lista);
        this.activity = activity;
        this.resourceId = resourceId;
        this.lista = lista;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View getView(int position, View view, ViewGroup parent) {

        View itemView = view;
        if (itemView == null) {
            itemView = this.activity.getLayoutInflater().inflate(R.layout.item_of_list, parent, false);
            holder = new RecipeAdapter.ViewHolder();
            holder.tvCategory = (TextView) itemView.findViewById(R.id.tvCategory);
            holder.tvCategoryDesc = (HtmlTextView) itemView.findViewById(R.id.html_texttvCategoryDesc);
            holder.ivCategory = (ImageView) itemView.findViewById(R.id.ivCategory);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        String currentRecipe = this.lista.get(position).getRtitle();
        String currentRecipeDesc = this.lista.get(position).getSteps();
        String currentRecipePath = this.lista.get(position).getRimpath();

        holder.tvCategory.setText(currentRecipe);
        holder.tvCategoryDesc.setText(Html.fromHtml(currentRecipeDesc));
        Glide.with(itemView.getContext()).load(currentRecipePath).placeholder(R.drawable.placeholder).into(holder.ivCategory);

        return itemView;
    }

    private class ViewHolder {
        private TextView tvCategory;
        private HtmlTextView tvCategoryDesc;
        private ImageView ivCategory;
    }
}
