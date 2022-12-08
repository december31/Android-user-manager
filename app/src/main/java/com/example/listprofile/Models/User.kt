package com.example.listprofile.Models

import android.os.Parcel
import android.os.Parcelable
import com.example.listprofile.R
import java.util.Date

data class User(
	val avt: Int,
	val background: Int?,
	val name: String,
	val address: String?,
	val phoneNumber: String?,
	val dateOfBirth: Date?,
	val email: String,
): Parcelable {
	constructor(parcel: Parcel) : this(
		avt = parcel.readInt(),
		background = parcel.readInt(),
		name = parcel.readString().toString(),
		address = parcel.readString(),
		phoneNumber = parcel.readString(),
		dateOfBirth = Date(parcel.readLong()),
		email = parcel.readString().toString()
	) {
	}

	override fun describeContents(): Int {
		TODO("Not yet implemented")
	}

	override fun writeToParcel(dest: Parcel?, p1: Int) {
		dest?.writeInt(avt)
		if (background != null) {
			dest?.writeInt(background)
		} else {
			dest?.writeInt(R.drawable.bg)
		}
		dest?.writeString(name)
		dest?.writeString(address)
		dest?.writeString(phoneNumber)
		if (dateOfBirth != null) {
			dest?.writeLong(dateOfBirth.time)
		} else {
			dest?.writeLong(0)
		}
		dest?.writeString(email)
	}

	companion object CREATOR : Parcelable.Creator<User> {
		override fun createFromParcel(parcel: Parcel): User {
			return User(parcel)
		}

		override fun newArray(size: Int): Array<User?> {
			return arrayOfNulls(size)
		}
	}

}