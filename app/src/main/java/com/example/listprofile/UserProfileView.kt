package com.example.listprofile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.listprofile.Models.User

class UserProfileView(private val user: User) :
	Fragment(),
	View.OnClickListener,
	View.OnTouchListener {

	companion object {
		lateinit var currentUser: User
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.user_profile, container, false )
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		requireView().findViewById<ImageView>(R.id.profilePicture).setImageResource(user.avt)
		requireView().findViewById<TextView>(R.id.username).text = user.name
		view.setOnClickListener(this)
		view.setOnTouchListener(this)
	}

	override fun onClick(v: View) {
		val activity = activity
		currentUser = user
		if (activity is Coordinate) {
			activity.showProfile(user)
		}
	}

	@SuppressLint("ClickableViewAccessibility")
	override fun onTouch(v: View?, motion: MotionEvent?): Boolean {

		when(motion!!.action) {
			MotionEvent.ACTION_DOWN -> {
				v!!.setBackgroundResource(R.color.purple_200)
				v.performClick()
			}
			MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
				v!!.setBackgroundResource(R.color.white)
			}
		}
		return true
	}

//	override fun onDrag(v: View?, dragEvent: DragEvent?): Boolean {
//		when(dragEvent!!.action) {
//			DragEvent.ACTION_DRAG_STARTED -> {
//				v!!.setBackgroundResource(R.color.purple_200)
//				v.performClick()
//			}
//			DragEvent.ACTION_DRAG_ENDED -> {
//				v!!.setBackgroundResource(R.color.white)
//			}
//		}
//		return true
//	}
}