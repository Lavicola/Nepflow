import {Injectable} from "@angular/core";


export enum HybridArts {
  HYBRID = "Hybrid",
  MULTIHYBRIDD = "Multihybrid",
}


export abstract class AbstractHybridValidator {
  protected motherName: string = "";
  protected fatherName: string = "";

  public abstract isValidFormat(name: string): boolean;
  protected abstract setParents(name: string): void;
  public getMother():string{return this.motherName}
  public getFather():string{return this.fatherName}

}

@Injectable({
  providedIn: 'any',
})
export class HybridValidation extends AbstractHybridValidator {

  constructor() {
    super();
  }
  public isValidFormat(input: string): boolean {
    let isValid:boolean =  /^\w+ x \w+$/.test(input);
    if(isValid){
      this.setParents(input);
    }
    return isValid;
  }

  public setParents(name:string): void {
    let parents : string[] = name.split(" x ")
    this.motherName = parents[0];
    this.fatherName = parents[1];
  }

}

@Injectable({
  providedIn: 'any',
})
export class MultiHybridValidation extends AbstractHybridValidator {

  constructor() {
    super();
  }
  public isValidFormat(input: string): boolean {
    let hybridName = input;
    let isValid:boolean = false;
    let temp = "";
    // substitutionCount must be increased at least 4 times (3 iterations are always guaranteed)
    let substitutionCount = -4;
    while (temp !== input) {
      temp = input;
      // ((NAME x NAME) x NAME) = (NAME x NAME)
      input = input.replace(/\(\(\w+ x \w+\) x \w+\)/g, "(N x N)");
      substitutionCount++;
    }
    temp = "";
    while (temp !== input) {
      temp = input;
      // (NAME x NAME) = NAME
      input = input.replace(/\(\w+ x \w+\)/g, "N");
      substitutionCount++;
    }
    temp = "";
    while (temp !== input) {
      temp = input;
      // NAME x NAME = ""
      input = input.replace(/\w+ x \w+/g, "");
      substitutionCount++;
    }
    isValid = input === "" && substitutionCount > 0;
    if(isValid){
      this.setParents(hybridName)
    }
    return isValid;
  }

  public setParents(name:string): void {
    console.log(name)
    let braceCount = 0;
    let mother = "";
    let father = "";

    if (name.charAt(0) === '(') {
      for (let i = 0; i <= name.length; i++) {
        if (name.charAt(i) === '(') {
          braceCount++;
        } else if (name.charAt(i) === ')') {
          braceCount--;
          if (braceCount === 0) {
            console.log(name)
            mother = name.substring(1, i);
            father = name.substring(i + 4);
            break;
          }
        }
      }
    } else {
      for (let i = name.length - 1; i >= 0; i--) {
        const c = name.charAt(i);
        if (c === ')') {
          braceCount++;
        } else if (c === '(') {
          braceCount--;
          if (braceCount === 0) {
            father = name.substring(i + 1);
            mother = name.substring(0, i - 3);
            break;
          }
        }
      }
    }
    this.motherName = mother;
    this.fatherName = father;
  }

}


export const StrategyMap = new Map<string, any>([
  [HybridArts.HYBRID, HybridValidation],
  [HybridArts.MULTIHYBRIDD, MultiHybridValidation],
]);
