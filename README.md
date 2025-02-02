<h1 align="center">Kratos</h1>

<p align="center">A flexible Kotlin library for seamless management and tracking of customizable application settings. Simplify the process of integrating user-configurable options into your projects.</p>

<div align="center">
    <a href="https://lyzev.github.io/discord"><img src="https://img.shields.io/discord/610120595765723137?logo=discord" alt="Discord"/></a>
    <br><br>
    <img src="https://img.shields.io/github/last-commit/SchizoidDevelopment/kratos" alt="GitHub last commit"/>
    <img src="https://img.shields.io/github/commit-activity/w/SchizoidDevelopment/kratos" alt="GitHub commit activity"/>
    <br>
    <img src="https://img.shields.io/github/languages/code-size/SchizoidDevelopment/kratos" alt="GitHub code size in bytes"/>
    <img src="https://img.shields.io/github/contributors/SchizoidDevelopment/kratos" alt="GitHub contributors"/>
</div>

## Usage

[![](https://jitpack.io/v/SchizoidDevelopment/kratos.svg?label=Release)](https://jitpack.io/#SchizoidDevelopment/kratos)

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

1. Go to the [release page](https://github.com/SchizoidDevelopment/kratos/releases).
2. Download Settings-${version}.jar.
3. Add the jar to your classpath.

</details>

### Example

<details>
        <summary>Example Boolean Setting</summary>

```kt
import dev.lyzev.api.setting.Setting
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
```

</details>

## Documentation

You can find the documentation [here](https://lyzev.github.io/Settings/dokka).

## Bugs and Suggestions

### Discord

For assistance with minor concerns, feel free to join our supportive community on
the [Discord server](https://lyzev.github.io/discord). Our friendly members and staff are ready to help you.

### GitHub

To ensure a prompt and effective resolution of bugs or to share your suggestions, please submit them through
the [issue tracker](https://github.com/SchizoidDevelopment/kratos/issues) of this repository. Kindly utilize the provided templates
and make sure to include all relevant details that would help us understand your issue better. Your cooperation is
greatly appreciated.
