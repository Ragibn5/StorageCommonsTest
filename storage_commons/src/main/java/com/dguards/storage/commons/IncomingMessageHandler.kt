package com.dguards.storage.commons

import android.os.Handler
import android.os.Looper
import android.os.Message

class IncomingMessageHandler(
  looper: Looper,
  private val messageCallback: MessageCallback
) :
  Handler(looper) {
  override fun handleMessage(msg: Message) {
    super.handleMessage(msg)
    messageCallback.onMessage(msg)
  }

  interface MessageCallback {
    fun onMessage(message: Message)
  }
}