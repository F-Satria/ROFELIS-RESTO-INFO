apply plugin: 'com.android.application'

android {
    compileSdkVersion 29
    buildToolsVersion "29.0.3"

    defaultConfig {
        applicationId "com.example.uasppb_rofelis"
        minSdkVersion 16
        targetSdkVersion 29
        versionCode 1
        versionName "1.0"

        buildConfigField 'String', 'BASE_URL', '"https://developers.zomato.com/api/v2.1/"'
        buildConfigField 'String', 'API_KEY', '"6e5056fee63c97ed1e7fad9074713568"'

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

    //RecycleView
    implementation 'androidx.recyclerview:recyclerview:1.1.0'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'com.github.bumptech.glide:glide:4.9.0'

    //ViewModel
    implementation 'android.arch.lifecycle:viewmodel:1.1.1'
    implementation 'android.arch.lifecycle:extensions:1.1.1'
    annotationProcessor 'android.arch.lifecycle:compiler:1.1.1'

    implementation 'com.squareup.picasso:picasso:2.71828'
    implementation 'com.squareup.okio:okio:2.2.2'
    implementation 'com.squareup.okhttp3:okhttp:3.14.1'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.9.0'

    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    implementation 'com.squareup.retrofit2:converter-scalars:2.3.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'

    //Dagger
    implementation 'com.google.dagger:dagger:2.12'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.12'

    //Maps
    implementation 'com.google.android.gms:p