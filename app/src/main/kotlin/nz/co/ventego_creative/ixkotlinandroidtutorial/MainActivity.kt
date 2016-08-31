package nz.co.ventego_creative.ixkotlinandroidtutorial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

import nz.co.ventego_creative.ixkotlinandroidtutorial.adapters.AnimalListAdapter
import nz.co.ventego_creative.ixkotlinandroidtutorial.commands.PetFindCommand
import nz.co.ventego_creative.ixkotlinandroidtutorial.model.domain.Pet

import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    @BindView(R.id.animal_list)
    lateinit var animalList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        animalList.layoutManager = LinearLayoutManager(this)

        async() {
            val result = PetFindCommand("90210","cat").execute()
            uiThread {
                animalList.adapter = AnimalListAdapter(result,
                    object: AnimalListAdapter.ItemClickListener{
                        override fun invoke(pet:Pet) {
                            toast(pet.name)
                        }
                    }
                )
            }
        }
    }


}