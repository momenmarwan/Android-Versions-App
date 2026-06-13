# Android-Versions-App

A simple Android app that displays a scrollable list of Android versions, each
shown with a logo, its code name, and its version number. Built with classic,
View-based Android development in **Java** and **XML layouts**.

## Features

- **RecyclerView list** — a vertical, scrollable list of 12 Android versions
  built with a hand-written `RecyclerView.Adapter` and a `LinearLayoutManager`.
- **Item cards** — each row is a `CardView` containing a `ConstraintLayout` with
  a circular logo, the code name (bold), and the version number.
- **Click feedback** — tapping a card shows a `Toast` such as
  `You selected: Lollipop (5.0 - 5.1.1)`.
- **Alternate row colors** — even and odd cards use different background colors
  for better readability.
- **Sort button** — sorts the list alphabetically by code name and updates the
  list instantly. Tapping again toggles between A–Z and Z–A.
- **Responsive layout** — `ConstraintLayout` is used both for the main screen and
  inside each item, so the UI adapts to different screen sizes.

## Tech Stack

- **Language:** Java
- **UI:** XML layouts (no Jetpack Compose)
- **View access:** `findViewById()` (no view/data binding)
- **Components:** `RecyclerView`, `CardView`, `ConstraintLayout`, `AppCompatActivity`
- **Min SDK:** 24

## Project Structure

```
app/src/main/java/com/example/androidversions/
├── MainActivity.java            # Builds the data, sets up the RecyclerView and sort button
├── AndroidVersion.java          # Data model (image, code name, version)
└── AndroidVersionAdapter.java   # RecyclerView adapter + ViewHolder (handles clicks)

app/src/main/res/
├── layout/activity_main.xml          # Header, sort button, RecyclerView
├── layout/item_android_version.xml   # Single card layout
├── drawable/                         # Placeholder version logos + UI shapes
└── values/                           # strings, colors, theme
```

## How to Run

1. Open the project folder in **Android Studio**.
2. Let Gradle sync finish.
3. Select an emulator or a connected device.
4. Click **Run ▶**.

## Notes

The version logos are simple placeholder shape drawables. To use real logos,
replace the files in `res/drawable` (e.g. `ic_lollipop.xml`) with images of the
same name.
