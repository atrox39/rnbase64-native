
# react-native-base64-native

## Getting started

`$ npm install react-native-base64-native --save`

### Mostly automatic installation

`$ react-native link react-native-base64-native`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-base64-native` and add `RNBase64Native.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNBase64Native.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNBase64NativePackage;` to the imports at the top of the file
  - Add `new RNBase64NativePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-base64-native'
  	project(':react-native-base64-native').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-base64-native/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-base64-native')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNBase64Native.sln` in `node_modules/react-native-base64-native/windows/RNBase64Native.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Base64.Native.RNBase64Native;` to the usings at the top of the file
  - Add `new RNBase64NativePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNBase64Native from 'react-native-base64-native';

// TODO: What to do with the module?
RNBase64Native;
```
  