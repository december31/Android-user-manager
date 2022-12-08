package com.example.listprofile

import com.example.listprofile.Models.User

interface Coordinate {
	fun changeProfile(user: User)
	fun showProfile(user: User)
}