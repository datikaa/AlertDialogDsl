![release workflow](https://github.com/datikaa/AlertDialogDsl/actions/workflows/release.yml/badge.svg)
[![](https://jitpack.io/v/datikaa/AlertDialogDsl.svg)](https://jitpack.io/#datikaa/AlertDialogDsl)

# AlertDialogDsl
A simple Kotlin DSL layer above `AlertDialog.Builder`

# Add it to your project

Add it in your root build.gradle at the end of repositories:
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```
Add the dependency:
```gradle
dependencies {
    implementation 'com.github.datikaa:AlertDialogDsl:0.0.5'
}
```
Enjoy! :wink:

# Basic usage
For `Activity` and `Fragment` there are extension functions that will use the available `Context` object, so you don't have to provide it:

```kotlin
class SampleActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        
        alertDialog { 
            title("Title goes here")
            message("Resources can be used too just like for the buttons")
            positiveButton("Yes") { dialogInterface, which ->
                Toast.makeText(this@MainActivity, "Yes clicked", Toast.LENGTH_SHORT).show()
            }
            negativeButton("No")  { dialogInterface, which ->
                Toast.makeText(this@MainActivity, "No clicked", Toast.LENGTH_SHORT).show()
            }
            show()
        }
    }
}
```

In case you want to use it elsewhere, you need to pass a `Context` object to a globally available function:

```kotlin
alertDialog(context) {
    title("Title goes here")
    message("Resources can be used too just like for the buttons")
    positiveButton(R.string.ok) { dialogInterface, which ->
        // handle your click event here for positive button
    }
    show()
}
```

All the `AlertDialog.Builder` functions are there, and there is also a Single/Multi choice item builder:

```kotlin
alertDialog {
    title("Title goes here")
    multiChoiceItems {
        item("Item 1", false)
        item("Item 2", false)
        item("Item 3", true)
        item("Item 4", false)
        onItemClick { dialogInterface, which, isChecked ->
            Toast.makeText(this@MainActivity, "${list[which].first} is ${if (isChecked) "checked." else "not checked."}", Toast.LENGTH_LONG).show()
        }
    }
    positiveButton("Accept") { dialogInterface, which ->
        Toast.makeText(this@MainActivity, "Selection accepted", Toast.LENGTH_LONG).show()
    }
    show()
}
```

Please note that the Dialog won't show automatically, you either have to call `create()` or `show()`.

# Alert dialogs in action:

![Alt Text](https://media.giphy.com/media/tyr4bIh9fv4E7TT81e/giphy.gif)
![Alt Text](https://media.giphy.com/media/SSRm2w1f8G4gvXISYA/giphy.gif)
