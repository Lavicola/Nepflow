import {PollenOfferDto} from "../models/pollen-offer-dto";

export function getNameOfCross(offer: PollenOfferDto, offer2: PollenOfferDto): string {
  let female: string = ""
  let male: string = ""

  if (offer.sex != offer2.sex) {
    // @ts-ignore
    female = offer.sex == "Female" ? offer.nepenthesName : offer2.nepenthesName
    // @ts-ignore
    male = offer.sex != "Female" ? offer.nepenthesName : offer2.nepenthesName


  } else {
    return "both offer same sex"
  }


  return female != male ? `(${female}) x (${male})` : female


}


