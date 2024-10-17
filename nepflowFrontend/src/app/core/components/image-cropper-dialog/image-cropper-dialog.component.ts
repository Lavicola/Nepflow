import {AfterViewInit, Component, ElementRef, EventEmitter, Inject, OnInit, Output, ViewChild} from '@angular/core';
import {ImageCropperComponent, CropperSettings, ImageCroppedEvent, LoadedImage} from "ngx-image-cropper";
import {DomSanitizer, SafeUrl} from "@angular/platform-browser";
import {MatButton} from "@angular/material/button";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";


@Component({
  selector: 'app-image-cropper-dialog',
  standalone: true,
  imports: [
    ImageCropperComponent,
    MatButton
  ],
  templateUrl: './image-cropper-dialog.component.html',
  styleUrl: './image-cropper-dialog.component.sass'
})
export class ImageCropperDialogComponent implements OnInit, AfterViewInit {


  @Output() fileUploadEvent = new EventEmitter<File>();
  @ViewChild('fileInput') fileInput!: ElementRef;

  private file: File
  private fileBlob: Blob | undefined
  private filename: string | undefined
  imageChangedEvent: Event | null = null;
  croppedImage: SafeUrl = '';

  constructor(
    private sanitizer: DomSanitizer,
    @Inject(MAT_DIALOG_DATA) private data: any,
    public dialogRef: MatDialogRef<ImageCropperDialogComponent>,
  ) {
    this.file = data.file

  }

  fileChangeEvent(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.filename = input.files[0].name
      this.imageChangedEvent = event;
    }
  }

  imageCropped(event: ImageCroppedEvent) {
    if (event.objectUrl != null && event.blob) {
      this.croppedImage = this.sanitizer.bypassSecurityTrustUrl(event.objectUrl);
      this.fileBlob = event.blob
    }
  }

  imageLoaded(image: LoadedImage) {
    // show cropper
  }

  cropperReady() {
    // cropper ready
  }

  loadImageFailed() {
    // show message
  }


  emitFile() {
    if (this.fileBlob && this.filename) {
      this.dialogRef.close({
        success: true,
        file: new File([this.fileBlob], this.filename)
      });
    }
  }

  destroyFile() {
    this.dialogRef.close({
      success: false,
    });

  }

  ngOnInit() {


  }

  ngAfterViewInit(): void {


    // not proud of it, but works for now.
    setTimeout(() => {
      const fileToUpload = this.file;
      const dataTransfer = new DataTransfer();
      dataTransfer.items.add(fileToUpload);
      this.fileInput.nativeElement.files = dataTransfer.files;
      const event = new Event('change', {bubbles: true});
      this.fileInput.nativeElement.dispatchEvent(event);
    }, 2);


  }


}

