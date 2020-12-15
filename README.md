# RandstadSearchAnimApplication
Please use Android Studio 4.0 for application gradle build,

Description: 
Using MVVM the app makes a service request to fetch Anime search data, the viewmodel will observe the incoming data and update the UI.
User can search anime by entering keywords like "naruto", "goku" and clicking Search button.

Approach:
The app uses single activity multiple fragment approach using navigation grap where navigation controller will navigate to respective screens.
ViewModel handles the API call from the repository using a coroutine (viewmodelscope) which runs on the ioDispatcher thread.
RecycerView is used to populate the UI with the help of ViewHolder pattern.
Retrofit2 is used to make network requests and provide response.
Sealed classes and data classes are used as Model class objects.

This application has been used below Jetpack components
1. MVVM
2. Live Data
3. Navigation components
4. Repository

Kotlin:
1. Scope functions
2. Higer order functions
3. Coroutines
4. Sealed class
5. data class

Http:
1. Retrofit
2. okHttp

3rd Party Libraries 
Picasso
Universalimageloader
OkHttp3Downloader
