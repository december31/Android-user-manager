package com.example.listprofile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.listprofile.Models.User

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), Coordinate {

	private lateinit var userLists: ArrayList<User>
	private lateinit var userProfileViewFragments: ArrayList<UserProfileView>
	private val requestCode = 1

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(null)
		setContentView(R.layout.activity_main)
		userLists = ArrayList()
		userLists.add(User(1, R.drawable.avt, R.drawable.bg, "Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(2, R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(3, R.drawable.avt2,R.drawable.bg, "Nguyen Thi Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(5, R.drawable.avt3,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(6, R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(7, R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(8, R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(9, R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(10, R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(11, R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(12, R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(13, R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(14, R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(15, R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(16, R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(17, R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))

		val trans = supportFragmentManager.beginTransaction()

		userProfileViewFragments = ArrayList()
		addFragment(trans)
	}

	override fun changeProfile(user: User) {
		findViewById<ImageView>(R.id.profilePicture).setImageResource(user.avt)
		findViewById<TextView>(R.id.username).text = user.name
	}

	override fun showProfile(user: User) {
		val intent = Intent(this@MainActivity, UserDetailsActivity::class.java)
		val bundle = Bundle()
		bundle.putParcelable("user", user)
		intent.putExtras(bundle)
		startActivityForResult(intent, UserDetailsActivity.USER_DETAILS_CODE)
	}

	private fun updateUserList() {
		val trans = supportFragmentManager.beginTransaction()

		for(user in userProfileViewFragments) {
			trans.remove(user)
		}
		addFragment(trans)
	}

	private fun addFragment(trans: FragmentTransaction) {
		userProfileViewFragments.clear()
		for (user in userLists) {
			val fragment = UserProfileView(user)
			userProfileViewFragments.add(fragment)
			trans.add(R.id.profileList, fragment)
		}
		trans.commit()
	}

	@Deprecated("Deprecated in Java")
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (requestCode == this.requestCode && resultCode == Activity.RESULT_OK) {
			val bundle = data!!.extras
			val user = bundle!!.getParcelable<User>("user")
			for (i in 0 until userLists.size) {
				if (userLists[i].id == user?.id) {
					userLists[i] = user
					updateUserList()
					return
				}
			}
		}
	}

}