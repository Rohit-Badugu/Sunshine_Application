# Sunshine Application

Homeowners with solar panels installed are not able to gauge the benefits of Solar. People are in a dilemma whether to buy solar panels or not as they fear it is completely dependent on weather conditions . Even though NASA provides data access based on statistical parameters, difficult for commoner to understand the data. In order to solve this problem, we have developed an application which utilizes NASA power data to provide temporal based time series visualizations based on statistical parameters such as temperature, humidity etc.

### Functionality Steps:
1. Get the desired user location
2. Get the time period (Start and End Dates)
3. Access NASA POWER API to retrieve data.
4. Populate the time series chart accordingly
5. Users can move the data by using Pinch Zoom Functionality


## Getting Started

### Clone the Repository

Get started by cloning the project to your local machine:

```
$ https://github.com/Rohit-Badugu/Sunshine_Application.git
```

## Prerequisites
1. Async HTTP client -> https://github.com/android-async-http/android-async-http
2. Graphview for diagrams -> https://github.com/jjoe64/GraphView
3. Google Places SDK -> https://developers.google.com/maps/documentation/places/android-sdk/start
4. Easy Permissions -> https://github.com/googlesamples/easypermissions


## Android Version Targeting
Application is currently built to work with Android API 23(Marshmallow). 


Please feel free to submit issues with any bugs or other unforseen issues you experience. We work diligently to ensure that the ```master``` branch is always bug-free and easy to clone and run from Eclipse. If you experience problems, open an issue describing the problem and how to reproduce it, and we'll be sure to take a look at it.
