/*
 * Copyright (c) 2023. Settings
 * All rights reserved.
 */

package dev.lyzev.api.settings.test

import dev.lyzev.api.settings.Setting
import kotlin.reflect.KClass

/**
 * A specific implementation of the [Setting] class for boolean settings.
 *
 * @param container The class of the settings container where this setting belongs.
 * @param name The name of the setting.
 * @param value The initial value of the boolean setting.
 * @param hide A lambda function that determines whether this setting is hidden or not.
 * @param change A lambda function that will be called when the value of the setting changes.
 */
class BooleanSetting(
    container: KClass<*>, name: String, value: Boolean, hide: () -> Boolean = { false }, change: (Boolean) -> Unit = {}
) : Setting<Boolean>(container, name, value, hide, change)

class Test {
    companion object {
        var setting by BooleanSetting(BooleanSetting::class, "test", true) { println("Setting changed to $it") }
    }
}

fun main() {
    // Create an instance of TestSetting with initial values.

    // Print the initial value of the setting.
    println(Test.setting)

    // Change the value of the setting to 'false'.
    Test.setting = false

    // Print the updated value of the setting.
    println(Test.setting)
}