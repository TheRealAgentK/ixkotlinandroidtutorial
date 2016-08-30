package nz.co.ventego_creative.ixkotlinandroidtutorial.model.mappers

import nz.co.ventego_creative.ixkotlinandroidtutorial.model.api.PetfinderResult
import nz.co.ventego_creative.ixkotlinandroidtutorial.model.data.Pet
import nz.co.ventego_creative.ixkotlinandroidtutorial.model.domain.Pet as PetDomain
import nz.co.ventego_creative.ixkotlinandroidtutorial.model.domain.PetList as PetListDomain

class PetDataDomainMapper {

    fun getFromData(result: PetfinderResult): PetListDomain {
        return PetListDomain(convertPetListToDomain(result.petfinder.pets.pet))
    }

    private fun convertPetListToDomain(list: List<Pet>): List<PetDomain> {
        return list.map { convertPetItemToDomain(it) }
    }

    private fun convertPetItemToDomain(pet: Pet): PetDomain {
        return PetDomain(pet.age,pet.size,pet.id,pet.name,pet.sex,pet.animal)
    }
}


