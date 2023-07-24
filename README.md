<h1 align="center">Settings</h1>

<p align="center">A flexible Kotlin library for seamless management and tracking of customizable application settings. Simplify the process of integrating user-configurable options into your projects.</p>

<div align="center">
    <a href="https://lyzev.github.io/discord"><img src="https://img.shields.io/discord/610120595765723137?logo=discord" alt="Discord"/></a>
    <br><br>
    <img src="https://img.shields.io/github/last-commit/Lyzev/Settings" alt="GitHub last commit"/>
    <img src="https://img.shields.io/github/commit-activity/w/Lyzev/Settings" alt="GitHub commit activity"/>
    <br>
    <img src="https://img.shields.io/github/languages/code-size/Lyzev/Settings" alt="GitHub code size in bytes"/>
    <img src="https://img.shields.io/github/contributors/Lyzev/Settings" alt="GitHub contributors"/>
</div>

## Usage

[![](https://jitpack.io/v/Lyzev/Settings.svg?label=Release)](https://jitpack.io/#Lyzev/Settings)

### Import

Replace `${version}` with the current version!

<details>
        <summary>Gradle KTS</summary>

```kt
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Lyzev:Settings:${version}")
}
```

</details>

<details>
        <summary>Gradle Groovy</summary>

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Lyzev:Settings:${version}'
}
```

</details>

<details>
        <summary>Maven</summary>

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
<dependency>
    <groupId>com.github.Lyzev</groupId>
    <artifactId>Settings</artifactId>
    <version>${version}</version>
</dependency>
</dependencies>
```

</details>

<details>
        <summary>Raw Jar</summary>

1. Go to the [release page](https://github.com/Lyzev/Settings/releases).
2. Download Settings-${version}.jar.
3. Add the jar to your classpath.

</details>

### Example

<details>
        <summary>TestEvent</summary>

```kt
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
class TestSetting(
    container: KClass<*>, name: String, value: Boolean, hide: () -> Boolean = { false }, change: (Boolean) -> Unit = {}
) : Setting<Boolean>(container, name, value, hide, change)

fun main() {
    // Create an instance of TestSetting with initial values.
    val setting = TestSetting(TestSetting::class, "test", true)

    // Print the initial value of the setting.
    println(setting.value)

    // Change the value of the setting to 'false'.
    setting.value = false

    // Print the updated value of the setting.
    println(setting.value)
}
```

</details>

## Documentation

You can find the documentation [here](https://lyzev.github.io/Settings/dokka).

## Code Quality Monitoring

You can find the qodana report [here](https://lyzev.github.io/Settings/qodana).

## Bugs and Suggestions

### Discord

For assistance with minor concerns, feel free to join our supportive community on
the [Discord server](https://lyzev.github.io/discord). Our friendly members and staff are ready to help you.

### GitHub

To ensure a prompt and effective resolution of bugs or to share your suggestions, please submit them through
the [issue tracker](https://github.com/Lyzev/Settings/issues) of this repository. Kindly utilize the provided templates
and make sure to include all relevant details that would help us understand your issue better. Your cooperation is
greatly appreciated.
