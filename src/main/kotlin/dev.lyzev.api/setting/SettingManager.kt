/*
 * Copyright (c) 2023. Settings
 * All rights reserved.
 */

package dev.lyzev.api.setting

import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

/**
 * Singleton object responsible for managing settings.
 */
object SettingManager {

    // A mutable set to store all registered settings.
    val settings = mutableSetOf<Setting<*>>()

    /**
     * Get a list of settings belonging to the specified settings container class.
     *
     * @param clazz The class of the settings container.
     * @return A list of settings associated with the specified container class.
     */
    operator fun get(clazz: KClass<*>): List<Setting<*>> = settings.filter { it.container == clazz }

    /**
     * Get a list of settings with the specified name from the specified settings container class.
     *
     * @param clazz The class of the settings container.
     * @param name The name of the setting.
     * @return A list of settings with the specified name associated with the container class.
     */
    operator fun get(clazz: KClass<*>, name: String): List<Setting<*>> =
        settings.filter { it.container == clazz && it.name == name }

    /**
     * Get a setting based on the provided container class name, setting class name, and setting name.
     *
     * @param container The fully qualified name of the container class.
     * @param type The fully qualified name of the setting class.
     * @param name The name of the setting.
     * @return The matching Setting object if found, otherwise null.
     */
    fun get(container: String, type: String, name: String): Setting<*>? =
        settings.firstOrNull { it.container.jvmName == container && it::class.jvmName == type && it.name == name }
}