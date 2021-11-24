# Kref
 Android SharedPreference management library made for kotlin

 [![](https://jitpack.io/v/dudgns0507/kref.svg)](https://jitpack.io/#dudgns0507/kref)  

Download
-------------------

Use Gradle:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.dudgns0507:Kref:1.1.0'
}
```


How do I use Kref?
-------------------

Initialize KrefManager:

```kotlin
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        KrefManager.init(this)
        // KrefManager.init(this, "SharedPreference Name")
        // KrefManager.init(this, "SharedPreference Name", Context.MODE_PRIVATE)
    }
}
```

Save data to SharedPreference (Example):

```kotlin
class PrefManager {
    companion object {
        val instance = PrefManager()
    }

    var kString: String by Kref(default = "")
}

// getValue like this
PrefManager.instance.kString

// setValue like this
PrefManager.instance.kString = "Kref"

// Clear all value
KrefManager.instance.clear()
```

Support Types:

```kotlin
// default is default value when SharedPreference key-value is empty
// name is SharedPreference key (if name is blank default is "{variable name}_Kref")

var kref: String by Kref(default = "", name = "")
var kref: String? by Kref(default = null)
var kref: Boolean by Kref(default = false)
var kref: Int by Kref(default = 0)
var kref: Long by Kref(default = 0L)
var kref: Float by Kref(default = 0F)
var kref: List<Any> by Kref(default = arrayListOf()))
```

Author
------
Park YoungHun - @dudgns0507 on GitHub

License
-------
```
MIT License

Copyright (c) 2021 dudgns0507

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
