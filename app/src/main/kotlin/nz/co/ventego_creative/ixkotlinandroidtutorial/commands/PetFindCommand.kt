package nz.co.ventego_creative.ixkotlinandroidtutorial.commands

import nz.co.ventego_creative.ixkotlinandroidtutorial.model.api.PetfinderRequest
import nz.co.ventego_creative.ixkotlinandroidtutorial.model.domain.PetList
import nz.co.ventego_creative.ixkotlinandroidtutorial.model.mappers.PetDataDomainMapper

class PetFindCommand(val zipCode: String, val animal: String): Command<PetList> {

    override fun execute(): PetList {
        return PetDataDomainMapper().getFromData(PetfinderRequest(zipCode,animal).send())
    }
}




