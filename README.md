# 🚀 Android API Integration Course

An Android application built to demonstrate real-world **REST API integration** using modern Android development practices. This project contains two fully independent mini-projects, each showcasing different patterns and use cases for consuming APIs in Android.

---

## 📦 Projects Overview

| Project | API Source | Key Feature |
|---|---|---|
| **PostAPI** | JSONPlaceholder | GET & POST requests, navigation, detail screen |
| **TheMovieDB** | TMDB API | Movie browsing, image loading, clean architecture |

---

## 🗂️ Project 1 — PostAPI

### 📌 Description

The **PostAPI** project demonstrates how to **fetch and create posts** using the free [JSONPlaceholder](https://jsonplaceholder.typicode.com/) REST API. It showcases two iterations (`postapi` and `postapiI`) of the same feature, progressively improving the architecture — from a basic GET request to a full CRUD flow with a Create Post screen and navigation.

### ✨ Features

- 📋 Fetch and display a list of posts from the API
- 📄 Navigate to a **Post Detail Screen** to view full post content
- ✏️ **Create a new post** via a dedicated form screen (POST request)
- 🔄 Loading, Success, Error, and Idle UI states
- 🧭 Navigation using **Jetpack Navigation Compose**

### 🏗️ Architecture

This project follows **Clean Architecture** principles, separating the codebase into distinct layers:

```
postapi / postapiI
├── data/
│   ├── remote/
│   │   ├── ApiClient.kt          # Ktor HttpClient setup with OkHttp engine
│   │   ├── ApiService.kt         # API call definitions (GET /posts, POST /posts)
│   │   └── dto/
│   │       └── PostDto.kt        # Data Transfer Object (serializable)
│   └── repository/
│       ├── PostRepository.kt     # Repository interface
│       └── PostRepositoryImpl.kt # Concrete implementation
├── domain/
│   └── Post.kt                   # Domain model (clean, UI-facing)
├── mapper/
│   └── PostMapper.kt             # Maps PostDto → Post domain model
├── di/
│   └── AppModule.kt              # Koin DI module
└── ui/
    ├── PostScreen.kt             # Post list screen
    ├── PostDetailScreen.kt       # Post detail screen
    ├── CreatePostScreen.kt       # Create post screen
    ├── PostViewModel.kt          # ViewModel with StateFlow
    ├── PostUiState.kt            # Sealed UI state class
    └── navigation/
        └── AppNavGraph.kt        # Navigation graph
```

### 🔌 API Details

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/posts` | Fetch all posts |
| `POST` | `/posts` | Create a new post |

**Base URL:** `https://jsonplaceholder.typicode.com`

### 📊 UI States

```kotlin
sealed class PostUiState {
    object Idle    : PostUiState()
    object Loading : PostUiState()
    data class Success(val posts: List<Post>) : PostUiState()
    data class Error(val message: String)     : PostUiState()
}
```

---

## 🗂️ Project 2 — TheMovieDB

### 📌 Description

The **TheMovieDB** project integrates with [The Movie Database (TMDB) API](https://www.themoviedb.org/) to display a list of currently **popular movies**. Each movie card shows the poster image, title, and overview. This project highlights clean architecture, DTO → domain mapping, image loading with Coil, and dependency injection with Koin.

### ✨ Features

- 🎬 Browse a list of **popular movies** fetched from TMDB
- 🖼️ Movie **poster images** loaded asynchronously with **Coil 3**
- 📝 Each card displays the movie **title** and **overview**
- ⏳ Loading spinner while data is being fetched
- ❌ Error state handling with user-facing message
- 🔑 API Key & base URL managed via a `NetworkConstants` object
- 🧭 Navigation-ready with typed routes (`HomeRoute`, `DetailsRoute`)

### 🏗️ Architecture

This project strictly follows **Clean Architecture** with clear separation between layers:

```
themoviedb
├── data/
│   ├── remote/
│   │   ├── MovieApi.kt           # Ktor API call — GET /movie/popular
│   │   ├── MovieDto.kt           # Raw API response model (serializable)
│   │   └── MovieResponseDto.kt   # Wrapper for paginated results list
│   ├── mapper/
│   │   └── MovieMapper.kt        # Maps MovieDto ↔ Movie domain model
│   └── MovieRepositoryImpl.kt    # Repository implementation
├── domain/
│   ├── model/
│   │   └── Movie.kt              # Clean domain model
│   └── repository/
│       └── MovieRepository.kt    # Repository interface
├── network/
│   └── NetworkConstants.kt       # BASE_URL, API_KEY, IMAGE_BASE
├── di/
│   └── AppModule.kt              # Koin DI module
├── navigation/
│   ├── MovieNavGraph.kt          # Compose navigation host
│   └── MovieRoutes.kt            # Typed route objects (serializable)
└── ui/
    ├── MovieScreen.kt            # Movie list screen + MovieCard composable
    ├── MovieViewModel.kt         # ViewModel with StateFlow
    └── MovieUiState.kt           # Sealed interface for UI states
```

### 🔌 API Details

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/movie/popular` | Fetch list of popular movies |

**Base URL:** `https://api.themoviedb.org/3`  
**Image Base URL:** `https://image.tmdb.org/t/p/w500`

> ⚠️ **Note:** You need a valid TMDB API key. Replace `"you-api-key-here"` in `NetworkConstants.kt` with your own key from [https://www.themoviedb.org/settings/api](https://www.themoviedb.org/settings/api).

### 📊 UI States

```kotlin
sealed interface MovieUiState {
    object Loading                                  : MovieUiState
    data class Success(val movies: List<Movie>)     : MovieUiState
    data class Error(val errorMessage: String)      : MovieUiState
}
```

### 🃏 Movie Card Preview

Each movie in the list is displayed in a `Card` composable:

```
┌─────────────────────────────────────┐
│  [Poster]  │  Movie Title           │
│  100dp     │  Overview text here... │
│            │  (2 lines max)         │
└─────────────────────────────────────┘
```

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| **Kotlin** | Primary language |
| **Jetpack Compose** | Declarative UI framework |
| **Ktor Client** | HTTP networking (OkHttp engine) |
| **Kotlinx Serialization** | JSON parsing / serialization |
| **Koin** | Dependency Injection |
| **Navigation Compose** | In-app navigation with type-safe routes |
| **Coil 3** | Async image loading for movie posters |
| **StateFlow** | Reactive UI state management |
| **ViewModel** | Lifecycle-aware state holder |
| **Clean Architecture** | Layered separation (data / domain / ui) |

---

## 📐 Dependency Injection (Koin)

Both projects use **Koin** for dependency injection. Each project has its own `AppModule`:

**PostAPI Module:**
```kotlin
val appModule = module {
    single<HttpClient>      { provideHttpClient() }
    single<ApiService>      { ApiService(get()) }
    single<PostRepository>  { PostRepositoryImpl(get()) }
    viewModel               { PostViewModel(get()) }
}
```

**TheMovieDB Module:**
```kotlin
val appModule = module {
    single  { HttpClientFactory.create() }
    single  { MovieApi(get()) }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    viewModel { MovieViewModel(get()) }
}
```

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or newer
- Android SDK 24+
- A valid [TMDB API Key](https://www.themoviedb.org/settings/api) (for TheMovieDB project)

### Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   ```

2. **Open in Android Studio** and let Gradle sync.

3. **Add your TMDB API Key** in:
   ```
   app/src/main/java/com/timzowen/apiintegrationcourse/themoviedb/network/NetworkConstants.kt
   ```
   ```kotlin
   const val API_KEY = "your_actual_api_key_here"
   ```

4. **Switch the active project** in `MainActivity.kt` by uncommenting the desired NavGraph:
   ```kotlin
   setContent {
       ApiIntegrationCourseTheme {
           // AppNavGraph()      // PostAPI v1
           // AppMainNav()       // PostAPI v2 (with Create Post)
           MovieNavGraph()       // TheMovieDB ✅ currently active
       }
   }
   ```

5. **Run the app** on an emulator or physical device (API 24+).

---

## 📁 Project Structure

```
app/src/main/java/com/timzowen/apiintegrationcourse/
├── MainActivity.kt
├── MovieApp.kt
├── postapi/                    # PostAPI v1 (basic GET)
├── postapiI/                   # PostAPI v2 (GET + POST + Navigation)
├── themoviedb/                 # TheMovieDB project
└── ui/
    ├── postapi/                # UI for PostAPI v1
    ├── postapiI/               # UI for PostAPI v2
    └── theme/                  # App theming
```

---

## 📄 License

This project is intended for **educational purposes** as part of an API Integration course.  
Feel free to use, modify, and share it.

---

> Built with ❤️ using Kotlin & Jetpack Compose

