# Kref
 Android SharedPreference management library made for kotlin

 
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
    implementation 'com.github.dudgns0507:Kref:1.0.1'
}
```


How do I use Kref?
-------------------

Initialize KrefManager:

```java
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

```java
class PrefManager {
    companion object {
        val instance = PrefManager()
    }

    var kString: String by StringPref(default = "")
}

// getValue like this
PrefManager.instance.kString

// setValue like this
PrefManager.instance.kString = "Kref"
```

Support Types:

```java
// default is default value when SharedPreference key-value is empty
// name is SharedPreference key (if name is blank default is "{variable name}_Kref")

var kref: String by StringPref(default = "", name = "")
var kref: String? by StringNullablePref()
var kref: Boolean by BooleanPref(default = false)
var kref: Int by IntPref(default = 0)
var kref: Long by LongPref(default = 0L)
var kref: Float by FloatPref(default = 0F)
var kref: List<Any> by ListPref(default = arrayListOf()))

data class Test(
    var a: String
)

var kref: Test by ObjectPref(Test::class, default = Test(a = ""))
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