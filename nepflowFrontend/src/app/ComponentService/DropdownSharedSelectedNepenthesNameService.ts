import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DropdownSharedSelectedNepenthesNameService {
  private selectedValueSubject = new BehaviorSubject<string>(''); // Default value

  setSelectedValue(value: string) {
    this.selectedValueSubject.next(value);
  }

  getSelectedValue(): Observable<string> {
    return this.selectedValueSubject.asObservable();
  }
}
