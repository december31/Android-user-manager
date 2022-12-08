package com.example.listprofile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.listprofile.User.User

class MainActivity : AppCompatActivity(), Coordinate {

	private lateinit var userLists: ArrayList<User>

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(null)
		setContentView(R.layout.activity_main)

		userLists = ArrayList()
		userLists.add(User(R.drawable.avt, "Nguyen Duc An"))
		userLists.add(User(R.drawable.avt1, "Tran Duc Anh"))
		userLists.add(User(R.drawable.avt2, "Nguyen Thi Hong Hai"))
		userLists.add(User(R.drawable.avt3, "Nguyen Van Cuong"))
		userLists.add(User(R.drawable.avt, "Nguyen Duc An"))
		userLists.add(User(R.drawable.avt1, "Tran Duc Anh"))
		userLists.add(User(R.drawable.avt2, "Nguyen Van Cuong"))
		userLists.add(User(R.drawable.avt3, "Nguyen Hong Hai"))
		userLists.add(User(R.drawable.avt, "Nguyen Duc An"))
		userLists.add(User(R.drawable.avt1, "Tran Duc Anh"))
		userLists.add(User(R.drawable.avt2, "Nguyen Van Cuong"))
		userLists.add(User(R.drawable.avt3, "Nguyen Hong Hai"))
		userLists.add(User(R.drawable.avt, "Nguyen Duc An"))
		userLists.add(User(R.drawable.avt1, "Tran Duc Anh"))
		userLists.add(User(R.drawable.avt2, "Nguyen Van Cuong"))
		userLists.add(User(R.drawable.avt3, "Nguyen Hong Hai"))

		val trans = supportFragmentManager.beginTransaction()

		for (user in userLists) {
			trans.add(R.id.profileList, UserProfileView(user))
		}
		trans.commit()
	}

	override fun changeProfile(user: User) {
		findViewById<ImageView>(R.id.profilePicture).setImageResource(user.avt)
		findViewById<TextView>(R.id.username).text = user.username
	}
}