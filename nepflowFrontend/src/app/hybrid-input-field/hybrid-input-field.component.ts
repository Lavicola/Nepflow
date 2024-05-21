import {Component, ElementRef, Injector, ViewChild} from '@angular/core';
import {AbstractHybridValidator, MultiHybridValidation, StrategyMap} from "../ComponentService/HybridStrategyNameValidation";
import {MatSelectChange} from "@angular/material/select";
import {HybridArts} from "../ComponentService/HybridStrategyNameValidation"

@Component({
  selector: 'app-hybrid-input-field',
  templateUrl: './hybrid-input-field.component.html',
  styleUrls: ['./hybrid-input-field.component.css']
})
export class HybridInputFieldComponent {

  @ViewChild('main') main!: ElementRef;
  @ViewChild('firstInput') firstInput!: ElementRef;
  @ViewChild('secondInput') secondInput!: ElementRef;

  private strategy!: AbstractHybridValidator;
  hybridArts = HybridArts;



  constructor(private injector: Injector) {
  }

  updateInputfields(hybridname:string){
    if(!this.strategy){
      return;
    }
    if(this.strategy.isValidFormat(hybridname)){
      this.firstInput.nativeElement.value = this.strategy.getMother();
      this.secondInput.nativeElement.value = this.strategy.getFather();
    }else{
      this.firstInput.nativeElement.value = "invalid";
      this.secondInput.nativeElement.value = "invalid";

    }

  }

  onInputChange(event:KeyboardEvent) {
        this.updateInputfields((event.target as HTMLInputElement).value.trim())
    }



  onHybridTypeChange($event: MatSelectChange) {
    this.strategy = this.injector.get<AbstractHybridValidator>(StrategyMap.get($event.value));
    this.updateInputfields(this.main.nativeElement.value);
  }
}
