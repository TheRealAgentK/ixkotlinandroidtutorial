package nz.co.ventego_creative.ixkotlinandroidtutorial.model.api

import android.content.Context
import com.google.gson.GsonBuilder
import nz.co.ventego_creative.ixkotlinandroidtutorial.model.data.Pet
import nz.co.ventego_creative.ixkotlinandroidtutorial.model.data.parsing.PetDeserializer
import nz.co.ventego_creative.ixkotlinandroidtutorial.utils.DemoUtils


class PetfinderRequest(val zipCode: String, val animal: String, val myContext: Context) {

    companion object {

        private val PETFINDER_URL = "http://api.petfinder.com/pet.find"
        private val API_KEY = "90c7450f970315f4651d3ea5575cbb6b"
        private val RETURN_FORMAT = "json"

        private val REQUEST_URL = "$PETFINDER_URL?key=$API_KEY&format=$RETURN_FORMAT"

    }

    fun send(): PetfinderResult {

        //val result = URL(REQUEST_URL + "&location=" + zipCode + "&animal=" + animal).readText()


        val result = DemoUtils(myContext).loadJSONFromAsset("sampledata.json")

        val gsonBldr = GsonBuilder()
        gsonBldr.registerTypeAdapter(Pet::class.java, PetDeserializer())
        val targetObject = gsonBldr.create().fromJson(result, PetfinderResult::class.java)
        return targetObject
    }
}