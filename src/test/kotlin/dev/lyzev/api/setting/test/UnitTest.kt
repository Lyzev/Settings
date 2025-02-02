/*
 * This file is part of https://github.com/SchizoidDevelopment/kratos.
 *
 * Copyright (c) 2025. Lyzev
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
 * You should have received a copy of the GNU General Public License along with Kratos. If not, see <https://www.gnu.org/licenses/>.
 */

package dev.lyzev.api.setting.test

import dev.lyzev.api.setting.Setting
import dev.lyzev.api.setting.SettingManager
import org.junit.jupiter.api.BeforeEach
import kotlin.reflect.KClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class BooleanSetting(
    container: KClass<*>, name: String, value: Boolean, hide: () -> Boolean = { false }, change: (Boolean) -> Unit = {}
) : Setting<Boolean>(container, name, null, value, hide, change)

class SettingTests {

    @BeforeEach
    fun setUp() {
        SettingManager.settings.clear()
    }

    @Test
    fun `test setting initialization`() {
        val setting = BooleanSetting(this::class, "test", true)
        assertEquals(true, setting.value)
    }

    @Test
    fun `test setting value change`() {
        val setting = BooleanSetting(this::class, "test", true)
        setting.value = false
        assertEquals(false, setting.value)
    }

    @Test
    fun `test setting onChange callback`() {
        var callbackTriggered = false
        val setting = BooleanSetting(this::class, "test", true) { callbackTriggered = true }
        setting.value = false
        assertTrue(callbackTriggered)
    }

    @Test
    fun `test setting hidden`() {
        val setting = BooleanSetting(this::class, "test", true, hide = { true })
        assertTrue(setting.isHidden)
    }

    @Test
    fun `test setting manager registration`() {
        val setting = BooleanSetting(this::class, "test", true)
        assertTrue(SettingManager.settings.contains(setting))
    }

    @Test
    fun `test setting manager get by container class`() {
        val setting = BooleanSetting(this::class, "test", true)
        val settings = SettingManager[this::class]
        assertTrue(settings.contains(setting))
    }

    @Test
    fun `test setting manager get by container class and name`() {
        val setting = BooleanSetting(this::class, "test", true)
        val settings = SettingManager[this::class, "test"]
        assertTrue(settings.contains(setting))
    }

    @Test
    fun `test setting manager get by container class and type class`() {
        val setting = BooleanSetting(this::class, "test", true)
        val retrievedSetting = SettingManager.get(this::class, BooleanSetting::class, "test")
        assertNotNull(retrievedSetting)
        assertEquals(setting, retrievedSetting)
    }

    @Test
    fun `test setting manager get by container and type`() {
        val setting = BooleanSetting(this::class, "test", true)
        val retrievedSetting = SettingManager.get("dev.lyzev.api.setting.test.SettingTests", "dev.lyzev.api.setting.test.BooleanSetting", "test")
        assertNotNull(retrievedSetting)
        assertEquals(setting, retrievedSetting)
    }
}