package com.changs.navershopping.src.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.changs.navershopping.R
import com.changs.navershopping.src.main.model.Item


class RecyclerviewAdapter(val context : Context, val searchlist : List<Item>) :
    RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var Image: ImageView? = null
        var text1: TextView? = null
        var text2: TextView? = null
        var text3: TextView? = null
        var text4: String? = null
        var uriBtn : Button? = null


        init {
            // Define click listener for the ViewHolder's View.
            Image = view!!.findViewById(R.id.item_imageview_product)
            text1 = view!!.findViewById(R.id.item_textview_product_name)
            text2 = view!!.findViewById(R.id.item_textview_product_price)
            text3 = view!!.findViewById(R.id.item_textview_product_mall)
            uriBtn = view!!.findViewById(R.id.item_btn_get_uri)

            uriBtn!!.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(text4))
                view.getContext().startActivity(intent)
            }

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recyclerview_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.text1?.setText( "상품명 : " + Html.fromHtml(searchlist[position].title))
        viewHolder.text3?.setText("브랜드명 : " + searchlist[position].brand)
        Glide.with(context).load(searchlist[position].image).into(viewHolder.Image!!)
        viewHolder.text4 = searchlist[position].link
        if(searchlist[position].lprice == "0"){
            viewHolder.text2?.setText("최저가 정보가 없습니다.")
        }else{
            viewHolder.text2?.setText("최저가 : " + searchlist[position].lprice + "원")}


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = searchlist.size

}