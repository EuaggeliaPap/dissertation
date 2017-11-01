package com.appcook.user.letscookapp.Controllers;

import android.app.Activity;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appcook.user.letscookapp.Model.Category;
import com.appcook.user.letscookapp.Model.SubCategory;
import com.bumptech.glide.Glide;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.List;

import static com.appcook.user.letscookapp.R.drawable;
import static com.appcook.user.letscookapp.R.id;
import static com.appcook.user.letscookapp.R.layout;
import static com.appcook.user.letscookapp.R.string;

public class CustomListAdapter extends ArrayAdapter<Category> {
    private Activity activity;
    private int resourceId;
    private List<Category> lista;
    private ViewHolder holder;

    public CustomListAdapter(Activity activity, int resourceId, List<Category> lista) {
        super(activity, resourceId, lista);
        this.activity = activity;
        this.resourceId = resourceId;
        this.lista = lista;
    }

    public View getView(int position, View view, ViewGroup parent) {

        View itemView = view;
        if (itemView == null) {
            itemView = this.activity.getLayoutInflater().inflate(layout.item_of_list, parent, false);
            holder = new ViewHolder();
            holder.tvCategory = (TextView) itemView.findViewById(id.tvCategory);
            holder.tvCategoryDesc = (HtmlTextView) itemView.findViewById(id.html_texttvCategoryDesc);
            holder.ivCategory = (ImageView) itemView.findViewById(id.ivCategory);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        String currentChild = childrenOfCurrentCat(position);
        String currentCategory = this.lista.get(position).getCattitle();
        String currentCategoryPath = this.lista.get(position).getCatimpath();

        holder.tvCategoryDesc.setText(Html.fromHtml(currentChild));
        holder.tvCategory.setText(currentCategory);
        Glide.with(itemView.getContext())
                .load(currentCategoryPath)
                .placeholder(drawable.placeholder)
                .into(holder.ivCategory);

        return itemView;
    }

    private class ViewHolder {
        private TextView tvCategory;
        private HtmlTextView tvCategoryDesc;
        private ImageView ivCategory;
    }

    public String childrenOfCurrentCat(int position) {
        ArrayList<String> child = new ArrayList<>();
        String text = "";
        if(this.activity instanceof CategoriesActivity){
            text = getContext().getString(string.CustomListAdapterCatDesc);
            for(int i=0;i<lista.get(position).getSubcategory().size();i++) {
                child.add(this.lista.get(position).getSubcategory().get(i).getCattitle());
                if(i== lista.get(position).getSubcategory().size()-1)
                    text = text+ child.get(i);
                else
                    text = text+ child.get(i) + ", ";
            }
        }
        if(this.activity instanceof SubCategoriesActivity){
            text = getContext().getString(string.CustomListAdapterSubCatDesc);
            SubCategory a = (SubCategory) this.lista.get(position);
            for(int i=0;i<a.getRecipe().size();i++) {
                child.add(a.getRecipe().get(i).getRtitle());
                if(i== a.getRecipe().size()-1)
                    text = text+ child.get(i);
                else
                    text = text+ child.get(i) + ", ";
            }
        }
        return text;
    }
}