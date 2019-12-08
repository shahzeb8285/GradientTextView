# GradientTextView

A UI Library providing `GradientTextView` which can be used as a normal TextView.


## Installation

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

    dependencies {
	  implementation 'com.github.shahzi8285:GradientTextView:0.1'
    }


## Usage

```python

 <in.birdcommunication.gradienttextview.GradientTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hey I am Heading 1"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginTop="5dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

Attributes:-
1. gt_direction  = left|up|right|bottom
2. gt_angle      = integer
3. gt_end_color  = color
4. gt_start_color  = color
 
```





## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.


## Contact us
[Bird Communication](https://www.birdcommunication.in/contact/)
## License
[MIT](https://www.birdcommunication.in/mit-licence/)
