# TfL Coding Challenge -Android

A simple illustration of Android development code challenge for tfl. This is done based on under the
assumption the end user would just be able to see weather each line service is working or not. It
doesn't address the explanation of why or until when questions.

This sample showcases:

* Used repository Pattern with viewModel for easier future maintenance, scalability and easily
  readability.
* As expected the app shows LINE NAME and LINE STATUS values, went extra step and added the line
  colour codes for better UI.
* As the requirement line status is displayed in its own column and it stretches depending on the
  viewport with (tested in few different screen sizes and tablet)
  **Note** : Haven't tested on more than 5-6 devices as this depends as expectations may vary on
  multiple factors
* followed bit mix of BDD/TDD as some how the requirement needs to address different scenarios for
  ease of access for the user(WCAG 2.1 AA Compliant), also only few test cases are added as this is
  not a production app
* tried to address few error cases that handle issues gracefully i.e no network on user's phone, or
  few generic server errors. please try it by switching of the device wifi and data plan, then start
  the app.

# Build and run the code

* user Android Studio Dolphin | 2021.3.1 version, haven't tried in earlier version. As the app's
  target SDK is api 33, one may consider to download it in android studio.
* the code doesn't require any API keys and should work out of the box
* one may run the test cases as usually open the file in this case(TubeStatusRepoTest) in android
  studio and run it.
  # Screen Shots
  ![Current Status](https://user-images.githubusercontent.com/124302730/216433917-54666fc2-aeb4-4a4c-85d3-3d6b6f8c0afa.png)
  ![error handle](https://user-images.githubusercontent.com/124302730/216433664-80f253fa-b9a2-4d2a-ac8b-70b4e77b9192.png)

**Note**
* Obviously there are multiple things can be done to make the app better, considering the time factor these are not included, 
  here are a few further recomendations:-
  - Handle more error cases for better user experience then show the appropriet messege,
  - migrate UI XML to Compose which is now stable ,
  - write more test cases for unit test and UI test,
  - test and support multiple device dimentions eg. smaller and bigger tablets
  - implement databinding and viewBinding then let each component observe directly from the viewModel.
  - check most senarios if it meets the WCAG 2.1 AA Compliant etc...
