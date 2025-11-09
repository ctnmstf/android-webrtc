# Android WebRTC Video Call App

A real-time video calling application built with Android WebRTC. Features Firebase Firestore signaling, ML Kit face detection, and video processing capabilities.

## 🚀 Features

- **WebRTC Video/Audio Call**: Peer-to-peer real-time video and audio communication
- **Firebase Signaling**: Start and join calls using Firebase Firestore
- **Face Detection**: Real-time face detection and landmark marking with ML Kit
- **Video Processing**: Automatic blur effect when no face is detected
- **Call Controls**: Microphone, video, camera switching, and audio output control

## 🛠️ Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/android-webrtc.git
   cd android-webrtc
   ```

2. **Firebase configuration:**
   - Create a new project in Firebase Console
   - Enable Firestore Database
   - Add an Android app
   - Download the `google-services.json` file and place it in the `app/` folder

3. **Open the project:**
   - Open the project in Android Studio
   - Wait for Gradle sync to complete
   - Dependencies will be downloaded automatically

4. **Run:**
   - Connect an Android device or start an emulator
   - Click the Run button or press `Shift+F10`

## 📱 Usage

1. **Start a Call:**
   - Open the app
   - Enter a unique Meeting ID
   - Click the "Start Call" button

2. **Join a Call:**
   - Enter an existing Meeting ID
   - Click the "Join Call" button

3. **Call Controls:**
   - 🎤 Toggle microphone on/off
   - 📹 Toggle video on/off
   - 🔄 Switch camera (front/back)
   - 🔊 Change audio output (Speaker/Earpiece)
   - ❌ End call

## 🏗️ Project Structure

```
app/src/main/java/com/example/androidwebrtc/
├── MainActivity.kt              # Main screen (Meeting ID input)
├── RTCActivity.kt               # Video call screen
├── RTCClient.kt                # WebRTC client implementation
├── SignalingClient.kt          # Firebase Firestore signaling
├── VideoProcessor.kt            # Video frame processing
├── RTCAudioManager.kt           # Audio management
└── ...
```

## 📚 Technologies Used

- **WebRTC**: Google WebRTC library
- **Firebase**: Firestore (for signaling)
- **ML Kit**: Face Detection
- **Kotlin Coroutines**: Asynchronous operations
- **Material Design 3**: UI framework
- **HokoBlur**: Blur effect library

## ⚙️ Configuration

### Firebase Setup

1. Create a project in Firebase Console
2. Enable Firestore Database
3. Add the `google-services.json` file to the `app/` folder
4. Configure Firestore security rules (you can use test mode for development)

### STUN Server

By default, Google's public STUN server is used. To add your own TURN server, update the `iceServer` list in the `RTCClient.kt` file.
