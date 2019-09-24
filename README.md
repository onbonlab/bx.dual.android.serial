# bx.dual.sdk.android
Android sdk for bx05/06

## Import to android studio
1. copy sdk libs to directory 'libs'

![avatar](https://github.com/onbonlab/bx.dual.sdk.android/blob/master/doc/pic/copy%20libs.png)


2. impletatoin in .gradle file like this
```gradle
implementation files('libs/bx05-0.5.0-SNAPSHOT.jar')
implementation files('libs/bx05.message-0.5.0-SNAPSHOT.jar')
implementation files('libs/bx06-0.6.0-SNAPSHOT.jar')
implementation files('libs/bx06.message-0.6.0-SNAPSHOT.jar')
implementation files('libs/simple-xml-2.7.1.jar')
implementation (name:'uia.pack', ext:'aar')
implementation(name: 'java.awt4a-0.1-release', ext: 'aar')
implementation (name:'serialport-1.0.1', ext:'aar')

```

