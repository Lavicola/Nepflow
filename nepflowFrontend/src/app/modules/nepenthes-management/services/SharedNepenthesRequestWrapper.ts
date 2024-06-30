import {BehaviorSubject, Observable} from "rxjs";
import {NepenthesService} from "../services/nepenthes.service";
import {Injectable} from "@angular/core";
import {NepenthesRequestWrapper} from "./NepenthesRequestWrapper";
@Injectable({
  providedIn: 'root'
})
export class SharedNepenthesRequestWrapper {
  private selectedStrategySubject: BehaviorSubject<NepenthesRequestWrapper>;
  selectedStrategy$: Observable<NepenthesRequestWrapper>;

  constructor(private nepenthesStrategy:NepenthesRequestWrapper) {
    this.selectedStrategySubject = new BehaviorSubject<NepenthesRequestWrapper>(nepenthesStrategy);
    this.selectedStrategy$ = this.selectedStrategySubject.asObservable();
  }

  setSelectedValue(value: NepenthesRequestWrapper) {
    this.selectedStrategySubject.next(value);
  }

  getSelectedValue(): Observable<NepenthesRequestWrapper> {
    return this.selectedStrategySubject.asObservable();
  }
}
