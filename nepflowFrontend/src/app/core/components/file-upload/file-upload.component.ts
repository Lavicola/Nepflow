import {Component, forwardRef} from '@angular/core';
import {AbstractControl, ControlValueAccessor, NG_VALUE_ACCESSOR, ValidationErrors} from "@angular/forms";

@Component({
  selector: 'app-file-upload',
  standalone: true,
  imports: [],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => FileUploadComponent),
      multi: true,
    }
  ],

  templateUrl: './file-upload.component.html',
  styleUrl: './file-upload.component.sass'
})
export class FileUploadComponent implements ControlValueAccessor {

  file!: File


  constructor() {
  }

  ngOnInit() {
  }

  onChange = (value: any) => {
  };
  onTouched = () => {
  };


  writeValue(value: any): void {
    this.file = value;
    this.onChange(value);
  }

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }


  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;

    if (input.files && input.files.length > 0) {
      //this.file = new Blob([file], {type: file.type});
      this.writeValue(input.files[0] as Blob)
    }
  }
}

export function requiredFileType(types: string[]): any {
  return (control: AbstractControl): ValidationErrors | null => {
    const file: File = control.value;
    if (file) {
      const extension = file.name.split('.').pop()?.toLowerCase();
      return extension && types.includes(extension) ? null : {requiredFileType: true};
    } else {
      return null
    }

  };
}

