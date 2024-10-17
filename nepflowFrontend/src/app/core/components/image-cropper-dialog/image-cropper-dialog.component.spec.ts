import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageCropperDialogComponent } from './image-cropper-dialog.component';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

describe('ImageCropperDialogComponent', () => {
  let component: ImageCropperDialogComponent;
  let fixture: ComponentFixture<ImageCropperDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ImageCropperDialogComponent],
      providers: [
        {provide: MAT_DIALOG_DATA, useValue: {}},
        {provide: MatDialogRef, useValue: {}}
      ]

    })
    .compileComponents();

    fixture = TestBed.createComponent(ImageCropperDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
