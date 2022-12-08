package com.example.listprofile.const

import com.example.listprofile.Models.User
import com.example.listprofile.R

class Const {
	companion object {
		lateinit var USER: ArrayList<User>
	}

	init {
		USER = ArrayList()
		USER.add(User(R.drawable.avt, R.drawable.bg, "Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt2,R.drawable.bg, "Nguyen Thi Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt3,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt, R.drawable.bg,"Nguyen Duc An", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt1,R.drawable.bg, "Tran Duc Anh", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt2,R.drawable.bg, "Nguyen Van Cuong", "Hà Nội", "012345678", null, "abc@123.com"))
		USER.add(User(R.drawable.avt3,R.drawable.bg, "Nguyen Hong Hai", "Hà Nội", "012345678", null, "abc@123.com"))

	}
}