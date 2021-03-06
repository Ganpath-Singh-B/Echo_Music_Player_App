package com.codewithganpath.echo_music_player.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codewithganpath.echo_music_player.R


/**
 * A simple [Fragment] subclass.
 */
class AboutUsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)
        activity!!.title = "About Us"
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        if (menu != null) {
            super.onPrepareOptionsMenu(menu)
        }
        val item = menu!!.findItem(R.id.action_sort)
        item.isVisible = false
    }

}// Required empty public constructor
