<div align="center">
    <img width="400" src=".idea/icon.png" alt="Icon of Kratos">
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

# Kratos: Setting Management for Kotlin

A flexible Kotlin library for seamless management and tracking of customizable application settings. Simplify the
process of integrating user-configurable options into your projects.

> [!IMPORTANT]
> Kratos is specifically designed for Kotlin and works best when used with Kotlin’s coding style. It’s strongly
> recommended to use it exclusively with Kotlin.

## :old_key: Key Features

- **Simple, customizable API**: For creating and managing settings.
- **Type-safe and easy integration**: Designed to be type-safe and easy to integrate into Kotlin projects.
- **Change tracking**: Allows tracking changes to settings and performing side effects.
- **Readable, maintainable structure**: Blends naturally with Kotlin code.

## :package: Installation

[![Maven Central](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/available/maven-central_vector.svg)](https://central.sonatype.com/artifact/dev.lyzev.api/kratos)

[![Maven Central Version](https://img.shields.io/maven-central/v/dev.lyzev.api/kratos)](https://central.sonatype.com/artifact/dev.lyzev.api/kratos)

Replace `${version}` with the latest version of Kratos!

<details>
    <summary>Gradle (Kotlin DSL)</summary>

```kt
repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.lyzev.api", "kratos", "${version}")
}
```

</details>

<details>
    <summary>Gradle (Version Catalog)</summary>

```toml
[versions]
kratos = "${version}"

[libraries]
kratos = { module = "dev.lyzev.api:kratos", version.ref = "kratos" }
```

</details>

<details>
    <summary>Gradle (Groovy DSL)</summary>

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'dev.lyzev.api:kratos:${version}'
}
```

</details>

<details>
    <summary>Maven</summary>

```xml
<dependencies>
    <dependency>
        <groupId>dev.lyzev.api</groupId>
        <artifactId>kratos</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```

</details>

<details>
    <summary>Raw Jar</summary>

1. Visit the [Maven Central Repository](https://search.maven.org/artifact/dev.lyzev.api/kratos) and download the JAR
   file for the version you need.
2. Add the downloaded JAR to your project.
3. You're all set!

</details>

## :bulb: Usage

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

In this example:

1. We define a `BooleanSetting` that extends `Setting<Boolean>`.
2. We create a `Test` object with a mutable property powered by `BooleanSetting`.
3. Changing the property triggers a callback, which can be logged or used to update your UI.

> [!TIP]
> The library is quite intuitive, so it's a good idea to try it out. You'll quickly learn its capabilities.

## :books: Documentation

> [!WARNING]
> This documentation is automatically generated by Dokka.

For documentation, check out the [Kratos Documentation](https://schizoid.lyzev.dev/kratos/).

[![Documentation](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/documentation/ghpages_vector.svg)](https://schizoid.lyzev.dev/kratos/)

## :lady_beetle: Bugs and Suggestions

### GitHub Issues :bug:

For bugs or suggestions, please submit them via
the [GitHub Issue Tracker](https://github.com/SchizoidDevelopment/kratos/issues). Kindly use the provided templates and
include all relevant details to ensure we can resolve your issue quickly. Your cooperation is greatly appreciated!

[![GitHub Issues](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/documentation/issues_vector.svg)](https://github.com/SchizoidDevelopment/kratos/issues)

### Discord Community :speech_balloon:

Need help with **minor** concerns or have questions? Join our supportive community on
the [Discord server](https://lyzev.dev/discord). Our friendly members and staff are here to assist you!

[![Discord Server](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/social/discord-plural_vector.svg)](https://lyzev.dev/discord)

## :handshake: Contribution Guidelines

We welcome contributions from the community! Please read our [Contribution Guidelines](CONTRIBUTING.md) to get started.

[![Pull Requests](https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/documentation/pull-requests_vector.svg)](https://github.com/SchizoidDevelopment/kratos/pulls)

## :lock: Security Policy

Please review our [Security Policy](SECURITY.md) to understand how we handle security vulnerabilities.

> [!CAUTION]
> Please do not publicly disclose the vulnerability until it has been fixed.

## :page_facing_up: License

Copyright (C) 2025 Lyzev

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see https://www.gnu.org/licenses/agpl-3.0.en.html.

---
*Kratos is developed and maintained by Schizoid Development. Thank you for using Kratos!*
