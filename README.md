<h1 align="center">AnimeArch</h1></br>
<p align="center">  
An anime info app for teaching how to use Jetpack Compose (State, Navigation, Animation etc..) with Clean Architecture and shows how to write Unit & Ui test
</p>
</br>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/halilozcan"><img alt="Profile" src="https://img.shields.io/badge/github-halilozcan-blue"/></a> 
</p>


## Screeshots
<p align="center">
<img src="/previews/home_initial.png" width="20%"/>
<img src="/previews/home_expanded.png" width="20%"/>
<img src="/previews/detail_initial.png" width="20%"/>
<img src="/previews/detail_expanded.png" width="20%"/>

</p>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) and [Flow](https://developer.android.com/kotlin/flow)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  -  A single-activity architecture, using the [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) to manage composable transactions.
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [UseCases](https://developer.android.com/topic/architecture/domain-layer) - Located domain layer that sits between the UI layer and the data layer. 
  - [Repository](https://developer.android.com/topic/architecture/data-layer) - Located in data layer that contains application data and business logic.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - is Android’s recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs
- [Android Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency Injection Library
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- [OkHttp](https://square.github.io/okhttp/) An HTTP client that efficiently make network requests
- [Coil Compose](https://coil-kt.github.io/coil/compose/) An image loading library for Android backed by Kotlin Coroutines
- Testing
  - [Mockito](https://site.mockito.org/) A mocking framework that tastes really good. It lets you write beautiful tests with a clean & simple API
  - [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) A scriptable web server for testing HTTP clients
  - [Truth](https://truth.dev/) A library for performing assertions in tests
  - [Turbine](https://github.com/cashapp/turbine) A small testing library for kotlinx.coroutines Flow
- [Material Design 3](https://m3.material.io/) is the latest version of Google’s open-source design system.

## Package Structure
    
    com.halilozcan.animearch # Root Package
    .
    ├── data                # Data layer
    │   ├── api             # AnimeApi     
    │   ├── dto             # Data transfer objects for remote response
    │   ├── repository      # Anime repository
    │   ├── source          # Remote or local data sources(for now remote only)
    |
    ├── di                  # Dependency Injection             
    │   ├── coroutine       # Coroutine Dispatcher Module      
    │   │── mapper          # AnimeMapper Module
    │   │── network         # Network Modu(okHttp & Retrofit) & SourceModule
    │   │── repository      # Repository Module
    |
    ├── domain              # Domain Layer(UseCases) 
    |   ├── entity          # Domain entities
    |   ├── mapper          # Domain mappers
    |   ├── usecase         # Anime usecases
    |
    ├── ui                  # Activity / ViewModel/ Composables (Ui) layer
    │   ├── detail          # DetailUiMapper, ViewModel and detail Composables
    │   ├── home            # HomeUiMapper, ViewModel and detail Composables
    |   ├── theme           # Colors, typography and theme options   
    
## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture

![](https://user-images.githubusercontent.com/21035435/69536839-9f4c8e80-0fa0-11ea-85ee-d7823e5a46b0.png)

## Find this repository useful? :heart:
__[follow](https://github.com/halilozcan)__ me for my next creations! 🤩

# License
```xml
Designed and developed by 2022 halilozcan (Halil ÖZCAN)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
