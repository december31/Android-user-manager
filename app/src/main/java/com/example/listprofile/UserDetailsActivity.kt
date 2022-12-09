package com.example.listprofile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.listprofile.Models.User

class UserDetailsActivity: AppCompatActivity() {

	companion object {
		val USER_DETAILS_CODE = 1
	}

	private var isEditButtonClicked = false
	private lateinit var usersInfoFragment: ArrayList<UserInfo>
	private lateinit var user: User

	@RequiresApi(Build.VERSION_CODES.O)
	@SuppressLint("SetTextI18n")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_user_details)

		usersInfoFragment = ArrayList()

		val bundle = intent.extras
		user = bundle!!.getParcelable("user")!!
		setupUserDetails()

		findViewById<Button>(R.id.editBtn).setOnClickListener {button ->
			isEditButtonClicked = !isEditButtonClicked
			if (button is Button) {
				if(isEditButtonClicked) {
					button.text = "Save"
					onEditBtnClicked()
				} else {
					button.text = "Edit"
					onSaveBtnClicked()
				}
			}
		}

		findViewById<Button>(R.id.cancelBtn).setOnClickListener {
			val trans = supportFragmentManager.beginTransaction()
			for (userInfo in usersInfoFragment) {
				trans.remove(userInfo)
			}
			trans.commit()
			setupUserDetails()
		}
	}

	private fun onSaveBtnClicked() {

		var v: EditText

		for (userInfo in usersInfoFragment) {
			v = userInfo.requireView().findViewById(R.id.edit_text)
			v.isFocusable = false
			v.isFocusableInTouchMode = false
		}
		v = findViewById(R.id.username)
		v.isFocusable = true
		v.isFocusableInTouchMode = true
		val user = User(
			user.id,
			user.avt,
			user.background,
			v.text.toString(),
			usersInfoFragment[0].view?.findViewById<EditText>(R.id.edit_text)?.text.toString(),
			usersInfoFragment[1].view?.findViewById<EditText>(R.id.edit_text)?.text.toString(),
			null,
			usersInfoFragment[2].view?.findViewById<EditText>(R.id.edit_text)?.text.toString(),
		)

		this.user = user
		val intent = Intent()
		val bundle = Bundle()
		bundle.putParcelable("user", user)
		intent.putExtras(bundle)
		setResult(RESULT_OK, intent)
		finish()
	}

	private fun onEditBtnClicked() {
		var v = findViewById<EditText>(R.id.username)
		v.isFocusable = true
		v.isFocusableInTouchMode = true

		for (userInfo in usersInfoFragment) {
			v = userInfo.requireView().findViewById(R.id.edit_text)
			v.isFocusable = true
			v.isFocusableInTouchMode = true
		}

	}

	@SuppressLint("UseRequireInsteadOfGet")
	private fun setupUserDetails() {
		val trans = supportFragmentManager.beginTransaction()
		findViewById<ImageView>(R.id.background).setImageResource(user.background!!)
		findViewById<ImageView>(R.id.avt).setImageResource(user.avt)
		findViewById<EditText>(R.id.username).setText(user.name)

		usersInfoFragment.add(UserInfo("Địa chỉ", user.address!!))
		usersInfoFragment.add(UserInfo("Số điện thoại", user.phoneNumber!!))
		usersInfoFragment.add(UserInfo("Ngày sinh", user.dateOfBirth!!))
		usersInfoFragment.add(UserInfo("Email", user.email))

		for (userInfo in usersInfoFragment) {
			trans.add(R.id.detailsInfo, userInfo)
		}
		trans.commit()
	}
}