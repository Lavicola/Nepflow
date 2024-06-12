import {Injectable} from "@angular/core";
import {BehaviorSubject, Observable} from "rxjs";
import {LabelDto} from "../../../models/label-dto";

@Injectable({
  providedIn: 'root'
})
export class NepenthesDropdownSharedLabelService {
  private selectedValueSubject = new BehaviorSubject<LabelDto>({}); // Default value

  setSelectedValue(value: LabelDto) {
    this.selectedValueSubject.next(value);
  }

  getSelectedValue(): Observable<LabelDto> {
    return this.selectedValueSubject.asObservable();
  }
}
