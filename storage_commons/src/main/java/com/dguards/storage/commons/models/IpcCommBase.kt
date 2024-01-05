package com.dguards.storage.commons.models

import android.os.Parcel
import android.os.Parcelable

class IpcCommBase(
  val senderPackageName: String,
  val callbackCode: Long,
  val json: String?
) : Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString()!!,
    parcel.readLong(),
    parcel.readString(),
  )

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(senderPackageName)
    parcel.writeLong(callbackCode)
    parcel.writeString(json)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<IpcCommBase> {
    override fun createFromParcel(parcel: Parcel): IpcCommBase {
      return IpcCommBase(parcel)
    }

    override fun newArray(size: Int): Array<IpcCommBase?> {
      return arrayOfNulls(size)
    }
  }
}