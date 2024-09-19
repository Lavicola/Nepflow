import {Directive, ElementRef, OnInit, Renderer2} from "@angular/core";

@Directive({selector: '[female]', standalone: true})
export class FemaleDirective implements OnInit {
  private path = "M450-120v-80h-80v-60h80v-102q-82-11-136-73.71-54-62.7-54-145.29 0-91.42 64.5-155.21Q389-800 480-800t155.5 63.79Q700-672.42 700-581q0 82.59-54 145.29Q592-373 510-362v102h80v60h-80v80h-60Zm29.8-300q66.2 0 113.2-46.8t47-113q0-66.2-46.8-113.2t-113-47Q414-740 367-693.2t-47 113q0 66.2 46.8 113.2t113 47Z"
  private color = "#EA33F7"
  constructor(
    private elementRef: ElementRef,
    private renderer: Renderer2
  ) {
  }

  ngOnInit() {
    const svg = this.elementRef.nativeElement;
    const newPath = this.renderer.createElement('path', 'http://www.w3.org/2000/svg');
    this.renderer.setAttribute(newPath, 'd', this.path);
    this.renderer.setAttribute(newPath,"fill",this.color)
    this.renderer.appendChild(svg, newPath);
  }
}
