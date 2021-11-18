# Sunshine Application

This is a sample app provided to show developers what Applicasa looks like in action, and help them see a real example of integrating Applicasa into their applications.

## About NASA SpaceApps Challenge

Applicasa is a Mobile Game Management Platform that provides developers a series of frameworks and a custom SDK for iOS and Android platforms that provide extensive support for In-App Purchases, Promotions, Analytics, and a customizable backend datastore. You can find out more information at [the Applicasa website](http://applicasa.com).

## About Sunshine Application

Egg is an imagined game that shows common scenarios and code samples that developers can learn from and emulate in their own applications.

### What You Will Find in Sunshine:
1. Integrating the Applicasa SDK and frameworks for Android
2. Implementing Applicasa's extensive In-App Purchasing support
  * Virtual Currency support &mdash; whereby users use IAP to purchase in-game currency
  * Virtual Goods support &mdash; whereby users use in-game currency to buy virtual items
  * User Inventory &mdash; whereby users can see the virtual items they've purchased
3. Implementing User handling via Applicasa's SDK and Facebook
  * Register new users
  * Login/Logout via Applicasa
  * Login/Logout via Facebook
4. Implementing Promotion handling via Applicasa's Promotion framework
  * Easy-to-use promotions that are triggered by events that happen inside your game
5. Implementing Push Messages 
  * Send user to users push message

## Getting Started

### Clone the Repository

As usual, you get started by cloning the project to your local machine:

```
$ git://github.com/Applicasa/Sample-App---Android.git
```

## Prerequisites
1. Add the facebook library to your worksapce 
```
https://developers.facebook.com/docs/android/
```


### Open and Run Project in Android Studio

Now that you have cloned the repo:

1. open the project up in Eclipse.

2. Go to the project and link it with the Facebook library

3. Import the SupersonicAds to your workspace. 
**NOTE:** Not needed, SupersonicAds jar was added directly to the libs folder for you convenience. 

  A. File -> Import -> "Existing Projects into your workspace"
  
  B. Go to the path where you cloned the Repo: (repoFolder)\AdNetwork\SSA_production-sdk
  
  C. Link "AppVille" with the SupersonicAds SDK
	

4. Click on the project name "AppVilleEgg" -> "Android Tools" -> "Add Support library"

At this point, you *should* be able to build and run the project in the Android device or emulator.

if you are facing issues see the Help section "Having Trouble?"



## Android Version Targeting

Egg is currently built to work with Android API 15(Ice Cream Sandwich). **However**, Egg's minimum SDK support is 10(Gingerbread).


## Build Configuration
This project was build on JDK 1.8



Please feel free to submit issues with any bugs or other unforseen issues you experience. We work diligently to ensure that the ```master``` branch is always bug-free and easy to clone and run from Eclipse. If you experience problems, open an issue describing the problem and how to reproduce it, and we'll be sure to take a look at it.
