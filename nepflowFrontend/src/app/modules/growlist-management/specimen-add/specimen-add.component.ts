import { Component } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-specimen-add',
  templateUrl: './specimen-add.component.html',
  styleUrl: './specimen-add.component.css'
})
export class SpecimenAddComponent {
  localNameControl: any;
  formGroup: FormGroup;


  constructor(private fb: FormBuilder) {

    this.formGroup = this.fb.group({
      localName: new FormControl(""),
    });


  }

  onFilePicked(event: Event) {
    // @ts-ignore
    const file = (event.target as HTMLInputElement).files[0]; // for now only one image allowed
    const reader = new FileReader();
    reader.readAsText(file);
    reader.onload = (e: any) => {
      let fileContent = e.target.result;
      this.formGroup.patchValue({capability: fileContent});

    };

  }

}
