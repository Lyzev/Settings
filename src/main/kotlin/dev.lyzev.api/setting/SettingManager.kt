/*
 * This file is part of https://github.com/SchizoidDevelopment/kratos.
 *
 * Copyright (c) 2023-2025. Lyzev
 *
 * Kratos is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License, or
 * (at your option) any later version.
 *
 * Kratos is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Kratos. If not, see https://www.gnu.org/licenses/agpl-3.0.en.html.
 */

package dev.lyzev.api.setting

import kotlin.reflect.KClass

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
     * @param container The class of the settings container.
     * @param type The class of the setting.
     * @param name The name of the setting.
     * @return The matching Setting object if found, otherwise null.
     */
    fun get(container: KClass<*>, type: KClass<*>, name: String): Setting<*>? =
        settings.firstOrNull { it.container == container && it::class == type && it.name == name }

    /**
     * Get a setting based on the provided container class name, setting class name, and setting name.
     *
     * @param container The fully qualified name of the container class.
     * @param type The fully qualified name of the setting class.
     * @param name The name of the setting.
     * @return The matching Setting object if found, otherwise null.
     */
    fun get(container: String, type: String, name: String): Setting<*>? =
        settings.firstOrNull { it.container.qualifiedName == container && it::class.qualifiedName == type && it.name == name }
}