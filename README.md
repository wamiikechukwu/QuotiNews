<a name="readme-top"></a>
<br />
<div align="center">
<!-- TODO: Add Official Logo -->
  <!-- <a href="#">
    Replace this logo for a custom official logo 
    <img src="./readme-assets/logos/here_goes_the_logo.png" alt="Logo" width="80" height="80">
  </a> -->

<h1 align = "center">
<b><i>QuotiNews</i></b>
</h1>
    <!-- Add/Remove categories depending on your project -->
  <p align="center">
    A News App with Jetpack Compose!
    <br />
    <!-- IMPORTANT NOTE: If you want to append emojis you'll need to add the '-' sign before and after the header, as shown below:  -->
    <a href="#-screenshots-">Screenshots</a>
    ·
    <a href="#-requirements-">Requirements</a>
    ·
    <a href="#-architecture-">Architecture</a>
    ·
     <a href="#-technologies-">Technologies</a>
    ·
    <a href="#-license-">License</a>
  </p>
</div>

<!-- Here goes the project description -->
**QuotiNews** is an Android App built with Jetpack Compose that consumes the [News API](https://newsapi.org/) with the 
purpose of showing the news of the day, breaking news, news by section (sports / technology / etc) and allows the user to search for a new.


*It is currently under development.*

## 🕹️ UI/UX 🕹️

This section is all about detailing the UI/UX of your project, their themes and animations.

The animations and interactive content from this section should be placed inside of [`readme-assets/gifs`](./readme-assets/gifs).

Animation 1	|	Animation 2	|	Animation 3 | Animation 4	|
:------:|:---------------------:|:-----------------------------:|:-------------:|
![](readme-assets/images/screenshot_placeholder.png)  |  ![](readme-assets/images/screenshot_placeholder.png)  |  ![](readme-assets/images/screenshot_placeholder.png)  |  ![](readme-assets/images/screenshot_placeholder.png)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## 📷 Screenshots 📷

Here you can add your projects's screenshots, reference the Design System used (Material / Cupertino / Custom) and the different UI Modes (Night / Dark).

The screenshots from this section should be placed inside of [`readme-assets/images`](./readme-assets/images/)

| Screen 1  | Screen 2 | Screen 3 |
| ------------- | ------------- |  ------------- |
| ![](readme-assets/images/screenshot_placeholder.png)  | ![](readme-assets/images/screenshot_placeholder.png)  | ![](readme-assets/images/screenshot_placeholder.png)  |
| ![](readme-assets/images/screenshot_placeholder.png)  | ![](readme-assets/images/screenshot_placeholder.png)  | ![](readme-assets/images/screenshot_placeholder.png)  |

| Screen 4  | Screen 5 | Screen 6 |
| ------------- | ------------- |  ------------- |
| ![](readme-assets/images/screenshot_placeholder.png)  | ![](readme-assets/images/screenshot_placeholder.png)  | ![](readme-assets/images/screenshot_placeholder.png)  |
| ![](readme-assets/images/screenshot_placeholder.png)  | ![](readme-assets/images/screenshot_placeholder.png)  | ![](readme-assets/images/screenshot_placeholder.png)  |
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## 📝 Requirements 📝

The current project uses the [News API](https://newsapi.org/) in order to search and provide news information. 
Hence, in order to run this project properly it is necessary to specify such API key in the `local.properties` file, in the following way: 
```groovy
NEWS_API_KEY=029cs8873jd783SomeApiKeyValue
```

These fields are used in the `build.gradle` file from the `app:module` in order to generate `BuildConfig` fields.
```groovy
// Reading the `NEWS_API_KEY` field from local.properties
buildConfigField "String", "API_KEY", "\"${properties.getProperty("NEWS_API_KEY")}\""
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## 🛠 Architecture 🛠

This section should comment the Architecture used in the project.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## 🦾 Technologies 🦾

QuotiNews uses many of the top libraries and tools in the Android Development World, like:
* [Jetpack Compose](https://developer.android.com/jetpack/compose): The Modern Declarative UI Toolkit for Building Native Android UIs.
* [Material Design 2](https://m2.material.io/design): An adaptable system of guidelines, components, and tools that support the best practices of user interface design.
* [Dagger Hilt](https://dagger.dev/hilt/): A static, compile-time dependency injection framework for both Java and Android built on the JSR-330.
* [Coil](https://coil-kt.github.io/coil/): An image loading library for Android backed by Kotlin Coroutines.
* [Retrofit](https://square.github.io/retrofit/): Square's type-safe HTTP Client.
* [Room](https://developer.android.com/topic/libraries/architecture/room): A persistence library which provides an abstraction layer over SQLite.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## 🪶 Author(s) 🪶


Wami Ikechukwu - [@wamiikechukwu](https://github.com/wamiikechukwu)

Fifi Degarr - [@cerver1](https://github.com/cerver1)

Jon Areas - [@jxareas](https://github.com/jxareas)

## 📜 License 📜
<!-- Change this license for the one used in your project -->
```
MIT License

Copyright (c) 2023 Wami Ikechukwu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- This is a custom version of Read-My-README by Jon Areas, found at: https://github.com/jxareas/read-my-readme -->

