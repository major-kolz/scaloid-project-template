package edu.winterproject.third

import org.scaloid.common._
import android.graphics.Color

class MainActivity extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      style {
        case b: SButton => b.textColor(Color.BLACK).onClick(toast("You push me!"))
        case t: STextView => t textSize 16.dip
        case e: SEditText => e.backgroundColor(Color.WHITE)
      }
      STextView("Greating! I am Scaloid")
      SButton("Start")
    } padding 20.dip
  }
}
