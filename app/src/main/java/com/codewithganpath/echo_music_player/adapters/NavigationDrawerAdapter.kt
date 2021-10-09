package com.codewithganpath.echo_music_player.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codewithganpath.echo_music_player.R
import com.codewithganpath.echo_music_player.activities.MainActivity
import com.codewithganpath.echo_music_player.fragments.AboutUsFragment
import com.codewithganpath.echo_music_player.fragments.FavouriteFragment
import com.codewithganpath.echo_music_player.fragments.MainScreenFragment
import com.codewithganpath.echo_music_player.fragments.SettingsFragment
import java.util.*

class NavigationDrawerAdapter(internal var contentList: ArrayList<String>, internal var getImages: IntArray, internal var mContext: Context) : RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): NavViewHolder {
        val itemview = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_custom_navigation_drawer, viewGroup, false)
        return NavViewHolder(itemview)
    }

    override fun onBindViewHolder(navViewHolder: NavViewHolder, i: Int) {
        navViewHolder.icon_GET.setBackgroundResource(getImages[i])
        navViewHolder.text_GET.text = contentList[i]
        navViewHolder.contentHolder.setOnClickListener {
            val x = navViewHolder.adapterPosition
            if (x == 0) {
                val mainScreenFragment = MainScreenFragment()
                (mContext as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.details_fragment, mainScreenFragment)
                        .commit()
            } else if (x == 1) {
                val favouriteFragment = FavouriteFragment()
                (mContext as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.details_fragment, favouriteFragment)
                        .commit()
            } else if (x == 2) {
                val settingsFragment = SettingsFragment()
                (mContext as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.details_fragment, settingsFragment)
                        .commit()
            } else {
                val aboutUsFragment = AboutUsFragment()
                (mContext as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.details_fragment, aboutUsFragment)
                        .commit()
            }
            MainActivity.drawerLayout!!.closeDrawers()
        }
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    class NavViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var icon_GET: ImageView
        internal var text_GET: TextView
        internal var contentHolder: RelativeLayout

        init {
            this.icon_GET = itemView.findViewById(R.id.icon_navdrawer)
            this.text_GET = itemView.findViewById(R.id.text_navdrawer)
            this.contentHolder = itemView.findViewById(R.id.navdrawer_item_content_holder)
        }
    }

}
