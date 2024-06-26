plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    `maven-publish`
}
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "io.github.wq-william"
            artifactId = "utils"
            version = "0.0.1"
            afterEvaluate {
                from(components["release"])
            }
            pom {
                name = "wq utils Library"
                description = "A concise description of my library"
                url = "https://github.com/wq-william/utils"
                properties = mapOf(
                    "myProp" to "value",
                    "prop.with.dots" to "anotherValue"
                )
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "github_13477226"
                        name = "415906626@qq.com"
                        email = "415906626@qq.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/wq-william/utils.git"
                    developerConnection = "scm:git:ssh://github.com/wq-william/utils.git"
                    url = "https://github.com/wq-william/utils"
                }
            }
        }

    }

}
android {
    namespace = "hz.wq.utilslbrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    publishing {
        multipleVariants {
            withSourcesJar()
            allVariants()
            withJavadocJar()
        }
//        singleVariant("release") {
//            withSourcesJar()
//            withJavadocJar()
//        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
//            ...
            enableUnitTestCoverage = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
}