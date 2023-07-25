package dev.lyzev.api.settings

import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * A generic abstract class representing a setting that can be used in a settings container.
 *
 * @param T The type of value this setting holds.
 * @property container The class of the settings container where this setting belongs.
 * @property name The name of the setting.
 * @property value The current value of the setting.
 * @property hidden A lambda function that determines whether this setting is hidden or not.
 * @property onChange A lambda function that will be called when the value of the setting changes.
 */
abstract class Setting<T>(
    val container: KClass<*>,
    val name: String,
    value: T,
    private val hidden: () -> Boolean = { false },
    protected val onChange: (T) -> Unit = {}
) {

    /**
     * The current value of the setting.
     * Setting this property will trigger the [onChange] callback.
     */
    var value = value
        set(value) {
            field = value
            onChange(value)
        }

    /**
     * Get the value of the setting.
     *
     * @param ref The reference to the container instance (unused).
     * @param prop The property for which the value is requested (unused).
     * @return The current value of the setting.
     */
    open operator fun getValue(ref: T?, prop: KProperty<*>): T = value

    /**
     * Set the value of the setting.
     * This will also trigger the [onChange] callback.
     *
     * @param ref The reference to the container instance (unused).
     * @param prop The property for which the value is being set (unused).
     * @param value The new value to set for the setting.
     */
    open operator fun setValue(ref: T?, prop: KProperty<*>, value: T) {
        this.value = value
    }

    /**
     * Check if the setting is hidden.
     *
     * @return True if the setting is hidden, false otherwise.
     */
    val isHidden: Boolean
        get() = hidden()

    /**
     * Initialize the setting by adding it to the [SettingManager] for tracking.
     */
    init {
        @Suppress("LeakingThis")
        SettingManager.settings += this
    }

    companion object {
        // Various extension functions to provide readable expressions for checking setting conditions.

        /**
         * Check if the value of the property equals the specified value.
         *
         * @param value The value to compare against.
         * @return A lambda function that returns true if the condition is met, false otherwise.
         */
        infix fun <T> KProperty<T>.eq(value: T): () -> Boolean = { getter.call() == value }

        /**
         * Check if the value of the property does not equal the specified value.
         *
         * @param value The value to compare against.
         * @return A lambda function that returns true if the condition is met, false otherwise.
         */
        infix fun <T> KProperty<T>.neq(value: T): () -> Boolean = { getter.call() != value }

        /**
         * Check if the value is in the specified collection property.
         *
         * @param value The value to check for existence in the collection.
         * @return A lambda function that returns true if the condition is met, false otherwise.
         */
        infix fun <T> KProperty<Collection<T>>.isIn(value: T): () -> Boolean = { value in getter.call() }

        /**
         * Check if the value is not in the specified collection property.
         *
         * @param value The value to check for non-existence in the collection.
         * @return A lambda function that returns true if the condition is met, false otherwise.
         */
        infix fun <T> KProperty<Collection<T>>.notIn(value: T): () -> Boolean = { value !in getter.call() }

        /**
         * Check if the value of the property is less than the specified value.
         *
         * @param value The value to compare against.
         * @return A lambda function that returns true if the condition is met, false otherwise.
         */
        infix fun <T : Comparable<T>> KProperty<T>.lt(value: T): () -> Boolean = { getter.call() < value }

        /**
         * Check if the value of the property is greater than the specified value.
         *
         * @param value The value to compare against.
         * @return A lambda function that returns true if the condition is met, false otherwise.
         */
        infix fun <T : Comparable<T>> KProperty<T>.gt(value: T): () -> Boolean = { getter.call() > value }

        /**
         * Check if the value of the property is less than or equal to the specified value.
         *
         * @param value The value to compare against.
         * @return A lambda function that returns true if the condition is met, false otherwise.
         */
        infix fun <T : Comparable<T>> KProperty<T>.leq(value: T): () -> Boolean = { getter.call() <= value }

        /**
         * Check if the value of the property is greater than or equal to the specified value.
         *
         * @param value The value to compare against.
         * @return A lambda function that returns true if the condition is met, false otherwise.
         */
        infix fun <T : Comparable<T>> KProperty<T>.geq(value: T): () -> Boolean = { getter.call() >= value }
    }
}