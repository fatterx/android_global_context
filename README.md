# android_global_context

## What

Easy way to get application context in your Android project

## Why

Context is very commonly used parameter in Android development.

We use context for app info, resources, system services, user configurations.

There are two ways to get context:

- Add context as parameter

when we want context in low level library to get resources, we pass context as parameter and pass it
one by one, that's too boring.

If you forget pass context from beginning, it's a lot work to do.

Adding a context parameter change the old method signature, this may cause a series of compile
error.

- Use Application Singleton

You can simple modify your Application instance become a singleton, so that can be accessed in
anywhere.

However, if your project is multiple modules, application singleton is often in App module, which is
the top of your multiple modules hierarchy, other low level modules can not depend App module, thus
they can not access application singleton anymore.

Thank goodness, the Android Team finally discovery this problem, they developed a androidx library
to provider global context, which use a singleton to hold application instance when ContentProvider
attach method called.

This work is smart, but still involved a additional ContentProvider component.

We want a simple and light way to get context anywhere

## How

We use the hidden class ActivityThread

```
    ActivityThread:
    
    public static Application currentApplication() {
        ActivityThread am = currentActivityThread();
        return am != null ? am.mInitialApplication : null;
    }
    
```

[https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/app/ActivityThread.java?q=activitythread&ss=android](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/app/ActivityThread.java?q=activitythread&ss=android)

As you can see, ActivityThread class has method **currentApplication** from Android 4.x to Android
13,

and it's a public method, used internally by the Android Team, so it's safe to use by us.

Cause the Android Team removed ActivityThread.class when packing Android.jar, so we need a little
trick to do.

Good news is the tricky thing has been done for you, you just need add the dependency and joy it!

If you are interested in **a little trick**
, [click this](https://github.com/fatterx/android_hidden_api)

code:

```
    AppGlobal.getApplication()
    AppGlobal.getPackageName()
    AppGlobal.getProcessName()
```

gradle:

```
// add jitpack repo
repositories {
        maven {
            url 'https://jitpack.io'
        }
 }
...

// add dependency
dependencies { 
        implementation "com.github.fatterx:android_global_context:0.0.1"
}
```

relative links:

- [https://github.com/fatterx/android_hidden_api](https://github.com/fatterx/android_hidden_api)