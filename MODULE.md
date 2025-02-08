# Module Kratos

<div align="center">
    <img width="400" src="https://github.com/SchizoidDevelopment/kratos/blob/master/.idea/icon.png?raw=true" alt="Icon of Kratos">
    <br>
    <a href="https://github.com/SchizoidDevelopment/kratos">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/available/github_vector.svg&w=64&h=64" alt="GitHub Repository">
    </a>
    <a href="https://central.sonatype.com/artifact/dev.lyzev.api/kratos">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/available/maven-central_vector.svg&w=64&h=64" alt="Maven Central">
    </a>
    <a href="https://lyzev.dev/discord">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/social/discord-plural_vector.svg&w=64&h=64" alt="Discord">
    </a>
    <a href="https://schizoid.lyzev.dev/kratos/">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/documentation/ghpages_vector.svg&w=64&h=64" alt="Documentation">
    </a>
    <a href="https://github.com/SchizoidDevelopment/kratos/pulls">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/documentation/pull-requests_vector.svg&w=64&h=64" alt="Pull Requests">
    </a>
    <a href="https://github.com/SchizoidDevelopment/kratos/issues">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/documentation/issues_vector.svg&w=64&h=64" alt="Issues">
    </a>
</div>

A flexible Kotlin library for seamless management and tracking of customizable application settings. Simplify the process of integrating user-configurable options into your projects.

<br>

> Kratos is specifically designed for Kotlin and works best when used with Kotlin’s coding style. It’s strongly
> recommended to use it exclusively with Kotlin.

## Key Features

- **Simple, customizable API**: For creating and managing settings.
- **Type-safe and easy integration**: Designed to be type-safe and easy to integrate into Kotlin projects.
- **Change tracking**: Allows tracking changes to settings and performing side effects.
- **Readable, maintainable structure**: Blends naturally with Kotlin code.

## Installation

[![Maven Central](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/available/maven-central_vector.svg)](https://central.sonatype.com/artifact/dev.lyzev.api/kratos)

<br>

<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/dev.lyzev.api/kratos">

Make sure to replace `${version}` with the latest version of Kratos!

### Gradle (Kotlin DSL)

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.lyzev.api:kratos:${version}")
}
```

### Gradle (Version Catalog)

```toml
[versions]
kratos = "${version}"

[libraries]
kratos = { module = "dev.lyzev.api:kratos", version.ref = "kratos" }
```

### Gradle (Groovy DSL)

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'dev.lyzev.api:kratos:${version}'
}
```

### Maven

```xml

<dependencies>
    <dependency>
        <groupId>dev.lyzev.api</groupId>
        <artifactId>kratos</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```

### Raw JAR

1. Visit the [Maven Central Repository](https://search.maven.org/artifact/dev.lyzev.api/kratos) and download the JAR file
   for the version you need.
2. Add the downloaded JAR to your project.

## Usage

Below is a simple example demonstrating how to implement a boolean setting and track its changes:

```kt
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
) : Setting<Boolean>(container, name, null, value, hide, change)

object Test {
    var setting by BooleanSetting(Test::class, "Test", true) { println("Setting changed to $it") }
}

fun main() {
    // Print the initial value of the setting.
    println(Test.setting)

    // Change the value of the setting to 'false'.
    Test.setting = false

    // Print the updated value of the setting.
    println(Test.setting)
}
```

## Bugs and Suggestions

### GitHub Issues

For bugs or suggestions, please submit them via
the [GitHub Issue Tracker](https://github.com/SchizoidDevelopment/kratos/issues). Be sure to use the provided templates
and include all relevant details to help us understand your issue and resolve it swiftly. Your cooperation is greatly
appreciated!

[![GitHub Issues](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/documentation/issues_vector.svg)](https://github.com/SchizoidDevelopment/kratos/issues)

### Discord Community

Need assistance or have **minor** questions? Join our welcoming community on
the [Discord server](https://lyzev.dev/discord). Our members and staff are always ready to help!

[![Discord Server](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/social/discord-plural_vector.svg)](https://lyzev.dev/discord)

## Contribution

We welcome contributions from the community! Please read
our [Contribution Guidelines](https://github.com/SchizoidDevelopment/kratos/blob/master/CONTRIBUTING.md) to get started.

[![Pull Requests](https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/documentation/pull-requests_vector.svg)](https://github.com/SchizoidDevelopment/kratos/pulls)

## Security Policy

Please review our [Security Policy](https://github.com/SchizoidDevelopment/kratos/blob/master/SECURITY.md) to understand how we handle security vulnerabilities.

<br>

> Please do not publicly disclose the vulnerability until it has been fixed.

## License

Copyright (C) 2025 Lyzev

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program. If not, see [https://www.gnu.org/licenses/agpl-3.0.en.html](https://www.gnu.org/licenses/agpl-3.0.en.html).

# Package dev.lyzev.api.setting

The `dev.lyzev.api.setting` package is a core component of the Kratos setting management library. It provides the necessary
interfaces and classes to create and manage settings in your projects.

## Usage Example

### Setting

The `Setting` class is the base class for all settings. It provides the necessary functionality to create and manage
settings.

```kt
class BooleanSetting(
    container: KClass<*>, name: String, description: String?, value: Boolean, hide: () -> Boolean = { false }, change: (Boolean) -> Unit = {}
) : Setting<Boolean>(container, name, description, value, hide, change)
```

### Setting Manager

The `SettingManager` class is responsible for managing settings. It provides the necessary functionality to create,
register, and manage settings.

#### How to add a setting

```kt
SettingManager.settings += setting
```

<br>

> **Note**: Settings are automatically registered when they are created. You do not need to manually register them.

#### How to get a setting

```kt
fun `test setting manager get by container class`() {
    val setting = BooleanSetting(this::class, "test", true)
    val retrievedSettings = SettingManager[this::class]
}

fun `test setting manager get by container class and name`() {
    val setting = BooleanSetting(this::class, "test", true)
    val retrievedSettings = SettingManager[this::class, "test"]
}

fun `test setting manager get by container class and type class`() {
    val setting = BooleanSetting(this::class, "test", true)
    val retrievedSetting = SettingManager.get(this::class, BooleanSetting::class, "test")
}

fun `test setting manager get by container and type`() {
    val setting = BooleanSetting(this::class, "test", true)
    val retrievedSetting = SettingManager.get(
        "dev.lyzev.api.setting.test.SettingTests",
        "dev.lyzev.api.setting.test.BooleanSetting",
        "test"
    )
}
```
