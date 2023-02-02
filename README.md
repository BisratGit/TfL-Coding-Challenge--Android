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