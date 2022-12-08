package com.example.listprofile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.listprofile.Models.User

class UserDetailsActivity: AppCompatActivity() {

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
		for (userInfo in usersInfoFragment) {
			val t = userInfo.requireView().findViewById<EditText>(R.id.edit_text)
			t.isFocusable = false
			t.isFocusableInTouchMode = false
		}
		val user = User(
			user.avt,
			user.background,
			user.name,
			usersInfoFragment[0].view?.findViewById<EditText>(R.id.edit_text)?.text.toString(),
			usersInfoFragment[1].view?.findViewById<EditText>(R.id.edit_text)?.text.toString(),
			null,
			usersInfoFragment[2].view?.findViewById<EditText>(R.id.edit_text)?.text.toString(),
		)
		this.user = user
		val intent = Intent(this@UserDetailsActivity, MainActivity::class.java)
		val bundle = Bundle()
		bundle.putParcelable("user", user)
		intent.putExtras(bundle)
		startActivity(intent)
	}

	private fun onEditBtnClicked() {
		for (userInfo in usersInfoFragment) {
			val v = userInfo.requireView().findViewById<EditText>(R.id.edit_text)
			v.isFocusable = true
			v.isFocusableInTouchMode = true
		}
	}

	@SuppressLint("UseRequireInsteadOfGet")
	private fun setupUserDetails() {
		val trans = supportFragmentManager.beginTransaction()
		findViewById<ImageView>(R.id.background).setImageResource(user.background!!)
		findViewById<ImageView>(R.id.avt).setImageResource(user.avt)
		findViewById<TextView>(R.id.username).text = user.name

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