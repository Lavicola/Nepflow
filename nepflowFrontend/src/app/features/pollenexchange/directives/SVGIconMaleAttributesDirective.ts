import {Directive, ElementRef, OnInit, Renderer2} from "@angular/core";

@Directive({selector: '[male]', standalone: true})
export class MaleDirective implements OnInit {
  private path = "M800-800v220h-60v-117L556-514q21 29 32.5 63.5T600-380q0 92-64 156t-156 64q-92 0-156-64t-64-156q0-92 64-156t156-64q36 0 70 11.5t63 32.5l184-184H580v-60h220ZM380.2-540Q314-540 267-493.2t-47 113q0 66.2 46.8 113.2t113 47q66.2 0 113.2-46.8t47-113q0-66.2-46.8-113.2t-113-47Z"
  private color = "#0000F5"
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
