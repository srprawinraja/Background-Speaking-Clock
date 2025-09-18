# ⏰ Background Time Speaker

An Android utility app that **announces the current time aloud whenever the screen is unlocked**.  
It runs a lightweight background service that listens for screen-on events and uses the device’s Text-to-Speech (TTS) engine to speak the time automatically.

---

## ✨ Features
- Speaks the **current time** every time the screen turns on or is unlocked.
- Simple UI with a button to display a Toast message explaining the feature.
- Runs as a **background service** so it works even when the app is not in the foreground.

---

## 🛠 Tech Stack
- **Language:** Kotlin
- **Framework:** Android SDK
- **Components & APIs:**
  - Service for continuous background operation.
  - BroadcastReceiver to detect Intent.ACTION_SCREEN_ON.
  - TextToSpeech API for voice output.
  - Toast for quick on-screen messages.

---


---

## 🚀 Getting Started
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/background-time-speaker.git
2. Open the project in Android Studio.

3. Build and run on a real device or emulator (requires TTS engine support).
