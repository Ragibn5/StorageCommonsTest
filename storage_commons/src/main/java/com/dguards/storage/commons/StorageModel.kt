package com.dguards.storage.commons

data class StorageModel(
    val uri: String?,
    val auth: String?,
    val provider: StorageProvider,
)