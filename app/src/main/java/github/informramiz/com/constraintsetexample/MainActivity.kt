package github.informramiz.com.constraintsetexample

import android.os.Bundle
import android.transition.TransitionManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main1.*

class MainActivity : AppCompatActivity() {

    private var isAnimationApplied = false
    private val constraintSet1 = ConstraintSet()
    private val constraintSet2 = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        loadConstraints()
        registerListeners()
    }

    private fun loadConstraints() {
        constraintSet1.clone(root_view)
        constraintSet2.clone(this, R.layout.activity_main2)
    }

    private fun registerListeners() {
        findViewById<ImageView>(R.id.image_view).setOnClickListener {
            animate()
        }
    }

    private fun animate() {
        val root = findViewById<ConstraintLayout>(R.id.root_view)
        TransitionManager.beginDelayedTransition(root)
        val constraintSet = if (!isAnimationApplied) constraintSet1 else constraintSet2
        constraintSet.applyTo(root)
        isAnimationApplied = !isAnimationApplied
    }
}
