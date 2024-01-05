package com.dguards.storage.commons.helpers

import android.os.Build
import android.os.Bundle
import android.os.Message
import com.dguards.storage.commons.exceptions.MalformedIpcMessageContractException
import com.dguards.storage.commons.models.IpcCommBase

class IpcCommHelper {
  companion object {
    private const val dataKey = "data"

    private fun buildIpcMessageBundle(
      callbackCode: Long,
      packageName: String,
      json: String?
    ): Bundle {
      val bundle = Bundle()
      bundle.putParcelable(
        dataKey,
        IpcCommBase(packageName, callbackCode, json)
      )
      return bundle
    }

    private fun getIpcMessageData(message: Message): IpcCommBase {
      val bundle = message.data

      // set class loader - required
      bundle.classLoader = IpcCommBase::class.java.classLoader

      return (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        bundle?.getParcelable(dataKey, IpcCommBase::class.java)
      } else {
        bundle?.getParcelable(dataKey)
      })
        ?: throw MalformedIpcMessageContractException(
          "No 'IpcCommBase' instance found under 'data' key. " +
            "The storage plugins and the app must communicate through this parcelable model type."
        )
    }
  }
}