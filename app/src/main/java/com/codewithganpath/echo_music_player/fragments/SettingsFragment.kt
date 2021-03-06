package com.codewithganpath.echo_music_player.fragments


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.Fragment
import com.codewithganpath.echo_music_player.R


/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment() {
    internal var myActivity: Activity? = null
    internal var shakeSwitch: Switch? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        shakeSwitch = view.findViewById(R.id.switchShake)
        activity!!.title = "Settings"
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        myActivity = context as Activity?
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        myActivity = activity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val prefs = myActivity!!.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE)
        val isAllowed = prefs.getBoolean("feature", false)
        if (isAllowed) {
            shakeSwitch!!.isChecked = true
        } else {
            shakeSwitch!!.isChecked = false
        }
        shakeSwitch!!.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                val editor = myActivity!!.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit()
                editor.putBoolean("feature", true)
                editor.apply()
            } else {
                val editor = myActivity!!.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit()
                editor.putBoolean("feature", false)
                editor.apply()
            }
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
        val item = menu!!.findItem(R.id.action_sort)
        item.isVisible = false
    }

    companion object {
        var MY_PREFS_NAME = "ShakeFeature"
    }

}// Required empty public constructor
