# 📱 Compose Multiplatform SQLDelight App

A **Kotlin Multiplatform** project using **JetBrains Compose Multiplatform** for UI and **SQLDelight** for local database management. This project targets both **Android** and **iOS**, using **JVM 21** and built with **Android Studio Narwhal**.

---

## 🔧 Tech Stack

- [JetBrains Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Android Studio Narwhal](https://developer.android.com/studio/preview)
- [JVM 21](https://openjdk.org/projects/jdk/21/)

## 🚀 Platforms Supported

- ✅ Android
- ✅ iOS (Device + Simulator)
- ⏳ Desktop (optional, can be added)

## 🗃️ SQLDelight Setup

- SQLDelight database is defined in `shared/src/commonMain/sqldelight`.
- Use `.sq` files to define queries.
- SQLDelight automatically generates Kotlin APIs for DB access.
- Include data migration.

📌 Notes
Uses SQLDelight multiplatform drivers (ios, android).