# Hello Kotlin Android

A [functional reactive][frp] Android app written in [Kotlin][kotlin] that uses the [Redux][reduxjs] pattern. It has similarities to [React][react] and [re-frame][reframe].

It consists of a counter that fetches Chuck Norris jokes:

![App demo](https://cloud.githubusercontent.com/assets/3226564/18225229/4daefd7e-71c4-11e6-84ce-3a78aac2fbdf.gif)

### Dependencies

| Library        | Concepts           | 
| ------------- |:-------------| 
| [Reduks][reduks]      |  state container, design pattern |
| [Anvil][anvil]      |  view layer, incremental DOM |
| [RxJava][rxjava]      |  observer pattern, multithreading |
| [Dagger][dagger]      |  dependency injection |
| [OKHttp][okhttp]      |  http client |
| [Gson][gson]      |  Json parsing |
| [Mockito][mockito]      |  mocking |
| [Robolectric][robolectric]      |  unit test framework |
| [Espresso][espresso]      |  UI test framework |

### Understanding the code
  The best way to get a good grasp of the code is to clone the repo, import it to Android Studio and start browsing.
  
  If you've never coded Android before, [this][astut] should cover the basics.
  
  It is highly recommended to read the [Reduks tutorial][reduks] as well.
  
  For newcomers it may seem there is too much code for too little, but the idea is to have a scalable pattern.
  
### The pattern in a nutshell

First, we define a state:
```kotlin
data class CounterState(val i: Int, val joke: Joke?)
```
Then we define actions and their reducers:
```kotlin
sealed class CounterActions {
    object INCREMENT
    object DECREMENT
    object JOKE_REQUEST
    data class JOKE_LOADED(val joke: Joke)
}
```
```kotlin
class CounterReducer : Reducer<CounterState> {
    override fun reduce(state: CounterState, action: Any?) =
            when (action) {
                is INCREMENT -> state.copy(i = state.i.plus(1), joke = null)
                is DECREMENT -> state.copy(i = state.i.minus(1), joke = null)
                is JOKE_LOADED -> state.copy(joke = action.joke)
                else -> state
            }
}
```
Later we build ViewModels, that convert state to view properties:
```kotlin
class CounterViewModel(state: CounterState) {
    val counterText = state.i.toString()
    val apiText = state.joke.value.joke
    val isLoading: Boolean = state.joke == null
}
```
Then we define the view:
```kotlin
class CounterView(...) : ModelView<CounterViewModel>(...) {
    override fun view(model: CounterViewModel) {
        xml(R.layout.activity_main) {
            mount(countTV) {
                text(model.counterText)
            }
            mount(plusBT) {
                onClick { v -> dispatch(INCREMENT, JOKE_REQUEST) }
                enabled(!model.isLoading)
            }
            mount(minusBT) {
                onClick { v -> dispatch(DECREMENT, JOKE_REQUEST) }
                enabled(!model.isLoading)
            }
            mount(apiTV) {
                text(model.apiText)
                visibility(!model.isLoading)
            }
            mount(loading) {
                visibility(model.isLoading)
            }
        }
    }
}
```

If necessary, we create middlewares that can mutate the state.

Finally, we create the controller and bind it to the activity:
```kotlin
class CounterController(activity: CounterActivity) : ModelController<CounterState, CounterViewModel>(activity) {
    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState(43, null)
    override fun getModel() = CounterViewModel(activity, getState())
    override fun getMiddlewares(): Array<Middleware<CounterState>> = arrayOf(CounterMiddleware())
    override val view = CounterView(activity, proxy)
}
```

```kotlin
class CounterActivity : BaseActivity<CounterState>() {
    override val controller by lazy { CounterController(this) }
}
```

### Testing
  The project has unit tests and UI tests. In particular, it is accompanied by helpers that make dependency injection setup trivial for tests:
  ```kotlin
  // for unit tests
  DaggerUnitMock.setup(MyClass::java.class, {
    it.someDependency = myTestDependency
  })
  
  // for Espresso tests; default test component
  DaggerEspressoMock.setup()
  
  // for Espresso tests; custom dependency
  DaggerEspressoMock.setup(object: EspressoApplicationProvider() {
    override fun provideSomeDependency() = myTestDependency;
  })
  
  // for Robolectric tests; default test component
  DaggerRoboMock.setup()
  
  // for Robolectric tests; custom dependency
  DaggerRoboMock.setup(object: RoboApplicationProvider() {
    override fun provideSomeDependency() = myTestDependency;
  })
  ```
  
### To do
  - Create `Component` entity that could be reused across screens
  - Use Redux's `combineReducers` and `reselect`
  
  
[frp]: https://gist.github.com/staltz/868e7e9bc2a7b8c1f754
[kotlin]: https://kotlinlang.org/
[reduxjs]: http://redux.js.org/
[react]: https://facebook.github.io/react/
[reframe]: https://github.com/Day8/re-frame

[astut]: https://www.sitepoint.com/12-android-tutorials-beginners/

[reduks]: https://github.com/beyondeye/Reduks
[anvil]: https://github.com/zserge/anvil
[rxjava]: https://github.com/ReactiveX/RxJava
[dagger]: https://github.com/square/dagger
[okhttp]: http://square.github.io/okhttp/
[gson]: https://github.com/google/gson
[mockito]: http://mockito.org/
[robolectric]: http://robolectric.org/
[espresso]: https://google.github.io/android-testing-support-library/docs/espresso/

