# react-native-flag-secure-android
A simple module used to add FLAG_SECURE to the main activity to treat the content of the window as secure, preventing it from:

1. appearing in screenshots
2. being viewed on non-secure displays

## Installation

### Automatic Install

We aren't on the NPM registry yet so:

```bash
npm install github:tombailey/react-native-flag-secure-android --save
```

Link the native modules:

```bash
react-native link
```

### Manual Install

1. Open up `android/app/src/main/java/[...]/MainApplication.java` (React Native 0.29+)
  - Add `import com.kristiansorens.flagsecure.FlagSecurePackage;` to the imports at the top of the file
  - Add `new FlagSecurePackage()` to the list returned by the `getPackages()` method

3. Append the following lines to `android/settings.gradle`:

	```groovy
	include ':react-native-flag-secure-android'
	project(':react-native-flag-secure-android').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-flag-secure-android/android')
	```

4. Insert the following lines inside the dependencies block in `android/app/build.gradle`:

 ```groovy
 compile project(':react-native-flag-secure-android')
 ```

## Usage

You don't need to do anything, the module automatically marks the main activity with FLAG_SECURE.

## Notes
Please note that this module is based on [react-native-flag-secure-android](https://github.com/kristiansorens/react-native-flag-secure-android)
