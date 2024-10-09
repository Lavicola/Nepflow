import {Component, ElementRef, forwardRef, HostListener, Input, SimpleChanges, ViewChild} from '@angular/core';
import {
  AbstractControl,
  ControlValueAccessor,
  FormControl,
  FormsModule,
  NG_VALUE_ACCESSOR,
  ValidationErrors
} from "@angular/forms";
import {query} from "@angular/animations";
import {MatIcon} from "@angular/material/icon";
import {MatButton} from "@angular/material/button";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-file-upload',
  standalone: true,
  imports: [
    MatIcon,
    MatButton,
    FormsModule,
    NgIf
  ],
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

  file: File|null = null
  fileUrl: string|undefined = undefined
  @ViewChild('fileUpload')
  fileUpload!: ElementRef
  inputFileName: any;
  accept: any;


  constructor() {
  }

  // propagate the fileUpload Dialog
  onClick(event:any) {
    if (this.fileUpload)
      this.fileUpload.nativeElement.click()
  }

  // set preview image
  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.setPreviewImage(input.files[0])
      this.writeValue(input.files[0] as Blob)
    }
  }

  removeImage($event: MouseEvent) {
    $event.stopPropagation()
    this.setPreviewImage()
    this.writeValue(null)

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



  onInput($event: Event) {

  }

  private setPreviewImage(content?:Blob|undefined){
    if(content instanceof Blob){
      this.fileUrl = URL.createObjectURL(content)
    }else{
      this.fileUrl = undefined
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

