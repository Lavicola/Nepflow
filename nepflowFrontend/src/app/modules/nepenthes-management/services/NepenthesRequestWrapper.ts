import {Observable} from "rxjs";
import {LabelClonesDto} from "../models/label-clones-dto";
import {LabelCloneDto} from "../models/label-clone-dto";
import {CloneDto} from "../models/clone-dto";
import {Injectable} from "@angular/core";
import {NepenthesType} from "../models/nepenthes-type";
import {CloneType} from "../models/clone-type";
import {NepenthesService} from "../services/nepenthes.service";
import { LabelDto } from "../models/label-dto";


/**
 * This Class is used to allow swiftly changing the desired endpoint.
 * Instead, using the Strategy Pattern, the Class has methods to switch to the specific
 * values. This way the method itself can be added to the corresponding Button
 */
@Injectable({ providedIn: 'root' })
export class NepenthesRequestWrapper{

  cloneType!:CloneType;
  nepenthesType!:NepenthesType;

  constructor(private nepenthesService: NepenthesService) {
    this.switchToSpecies()
    this.switchToIv()

  }

  cloneNepenthesTypeGet():Observable<Array<LabelDto>>{
    return this.nepenthesService.cloneNepenthesTypeGet({
        nepenthesType:this.nepenthesType
      }
    )
  }

  cloneNepenthesTypeNameGet(nepenthesName:string):Observable<LabelClonesDto>{

    return this.nepenthesService.cloneNepenthesTypeCloneTypeNameGet(
      {
        name: nepenthesName,
        cloneType: this.cloneType,
        nepenthesType: this.nepenthesType
      }
    )

  }

  cloneNepenthesTypeCloneTypeNameGet(nepenthesName:string):Observable<LabelClonesDto>{
    return this.nepenthesService.cloneNepenthesTypeCloneTypeNameGet(
      {
        nepenthesType: this.nepenthesType,
        cloneType: this.cloneType,
        name: nepenthesName
      }
    )

  }


  cloneNepenthesTypeCloneTypeNamePost( nepenthesName:string,clone:CloneDto):Observable<LabelCloneDto>{

    return this.nepenthesService.cloneNepenthesTypeCloneTypeNamePost(

      {
        name: nepenthesName,
        body:{clone},
        cloneType:this.cloneType,
        nepenthesType: this.nepenthesType
      }






    )


  }
  cloneNepenthesTypeCloneTypeNameInternalCloneIdPut( nepenthesName:string,internalCloneid:string,clone:LabelCloneDto):Observable<LabelCloneDto>{

    return this.nepenthesService.cloneNepenthesTypeCloneTypeNameInternalCloneIdPut(

      {
        name:nepenthesName,
        internalCloneId: internalCloneid,
        cloneType:this.cloneType,
        nepenthesType:this.nepenthesType,
      }







    )


  }

  switchToIv():CloneType{
    this.cloneType= CloneType.iv;
    return this.cloneType
  }

  switchToIc():CloneType{
    this.cloneType=CloneType.ic
    return this.cloneType
  }
  switchToSpecies(){
    this.nepenthesType=NepenthesType.species
  }
  switchToPrimaryHybrid(){
    this.nepenthesType=NepenthesType.primaryhybrid
  }
  switchToMultiHybrid(){
    this.nepenthesType=NepenthesType.multihybrid
  }

  getCurrentCloneType():string{
    return this.cloneType.toString();
  }
  getCurrentNepenthesType():string{
    return this.nepenthesType.toString()
  }

}
