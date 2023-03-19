# Ordered Pairs
#### A simple 2D vector library for Kotlin

\
This library contains a simple vector class with basic functions. The class stores two floating point coordinates which represent a vector in the Cartesian coordinate system.

## Features

- **Operators :**

    `+`, `+=`, `-`, `-=`,`*`,`*=`,`==` and `!=`


- **Basic Functions :**
    
    Such as: `.length()`, `.dot()`, `.rotDeg()` and much more!
## Example code

Code:
```kotlin
var MyVector: vector2 = vector2(420.0f, 69.0f)
println(MyVector)
val MyVectorLength = MyVector.length()
println(MyVectorLength)
```
Console output:
```
(420.0;69.0)
414.293374
```