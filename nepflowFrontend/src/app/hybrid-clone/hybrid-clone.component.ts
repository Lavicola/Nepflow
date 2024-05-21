import { Component } from '@angular/core';
import {NepenthesManagementService} from "../services/nepenthes-management.service";
import {Observable} from "rxjs";
import {HybridCloneDto} from "../models/hybrid-clone-dto";

@Component({
  selector: 'app-hybrid-clone',
  templateUrl: './hybrid-clone.component.html',
  styleUrls: ['./hybrid-clone.component.css']
})
export class HybridCloneComponent {

  requestMapping = new Map<string, Map<string, Observable<Array<HybridCloneDto>>>>()

  selectedHybridClass: string = "";
  selectedCategory: string = "";
  hybrids: HybridCloneDto[] = []

  constructor(
    public hybridService:NepenthesManagementService
  ) {

    let requestMappingHybrid = new Map<string, Observable<Array<HybridCloneDto>>>();
    requestMappingHybrid.set('all', this.hybridService.cloneHybridsGet());
    requestMappingHybrid.set('iv', this.hybridService.cloneHybridsIvGet());
    requestMappingHybrid.set('ic', this.hybridService.cloneHybridsIcGet());

    let requestMappingMultiHybrid = new Map<string, Observable<Array<HybridCloneDto>>>();
    requestMappingMultiHybrid.set('all', this.hybridService.cloneMultiHybridGet());
    requestMappingMultiHybrid.set('iv', this.hybridService.cloneMultiHybridIvGet());
    requestMappingMultiHybrid.set('ic', this.hybridService.cloneMultiHybridIcGet());
    this.requestMapping.set("Hybrid",requestMappingHybrid)
    this.requestMapping.set("MultiHybrid",requestMappingMultiHybrid)


  }

  onHybridTypeChange(event: any) {
    this.selectedHybridClass = event.value;
    if(this.selectedHybridClass && this.selectedCategory){
      console.log(this.selectedCategory + this.selectedHybridClass)
      this.requestMapping.get(this.selectedHybridClass)?.get(this.selectedCategory)?.subscribe({
        next: (hybridList) => this.hybrids = hybridList,
        error: () => console.log("next"),
      })
      console.log("change")
    }
  }

  onCloneTypeChange(event: any) {
    this.selectedCategory = event.value;
    if(this.selectedHybridClass && this.selectedCategory){
      this.requestMapping.get(this.selectedHybridClass)?.get(this.selectedCategory)?.subscribe({
        next: (hybridList) => this.hybrids = hybridList,
        error: () => console.log("next"),
      })
    }
  }


}
