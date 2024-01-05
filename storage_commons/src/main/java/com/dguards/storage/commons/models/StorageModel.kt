package com.dguards.storage.commons.models

import com.dguards.storage.commons.enums.StorageProvider

data class StorageModel(
  val uri: String?,
  val auth: String?,
  val provider: StorageProvider,
)