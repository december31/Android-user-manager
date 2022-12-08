package com.example.listprofile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.listprofile.Models.User

class MainActivity : AppCompatActivity(), Coordinate {

	private lateinit var userLists: ArrayList<User>

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(null)
		setContentView(R.layout.activity_main)
		userLists = ArrayList()
		userLists.add(User(R.drawable.avt, R.drawable.bg, "Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt2,R.drawable.bg, "Nguyen Thi Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt3,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		userLists.add(User(R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))

		val trans = supportFragmentManager.beginTransaction()

		for (user in userLists) {
			trans.add(R.id.profileList, UserProfileView(user))
		}
		trans.commit()
	}

	override fun onRestart() {
		super.onRestart()
		val bundle = intent.extras
		val user = bundle!!.getParcelable<User>("user")
		UserProfileView.currentUser = user!!
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
		startActivity(intent)
	}
}