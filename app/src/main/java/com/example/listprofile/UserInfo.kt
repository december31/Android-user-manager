package com.example.listprofile

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

class UserInfo(private val key: String, private val value: Any): Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.user_details, container, false)
	}

	@SuppressLint("CutPasteId")
	@RequiresApi(Build.VERSION_CODES.O)
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		view.findViewById<TextView>(R.id.lb).text = key
		view.findViewById<EditText>(R.id.edit_text).isFocusable = false
		view.findViewById<EditText>(R.id.edit_text).isFocusableInTouchMode = false
		if (value is String) {
			view.findViewById<EditText>(R.id.edit_text).setText(value)
		} else {
			view.findViewById<EditText>(R.id.edit_text).setText("hehehehhe")
		}
	}

	public fun editInfo(value: Any) {
		if (value is String) {
			requireView().findViewById<EditText>(R.id.edit_text).setText(value)
		} else {
			requireView().findViewById<EditText>(R.id.edit_text).setText("hehehehhe")
		}
	}

}